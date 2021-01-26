package com.demo.data.source

import com.demo.data.api.ApiService
import com.demo.data.db.CanadaInfoDao
import com.demo.data.mappers.toEntity
import com.demo.data.models.entity.CanadaInfoEntity
import com.demo.data.utils.AppLogger
import com.demo.data.utils.SharedPrefsHelper
import com.demo.domain.model.ToolbarTitle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CanadaInfoDataSource @Inject constructor(
    private val apiService: ApiService,
    private val trendingRepoDao: CanadaInfoDao,
    private val sharedPrefsHelper: SharedPrefsHelper
) {

    private val cLassName = CanadaInfoDataSource::class.java.name

    /**
     * Takes in [forceRefresh] to decide how to fetch data
     * i.e either from remote(true) or local db(false)
     * @return list of search results
     */
    suspend fun query(forceRefresh: Boolean): Flow<List<CanadaInfoEntity>> {

        //check if cacheAvailable
        val isCacheAvailable = trendingRepoDao.isCacheAvailable() > 0

        when {
            forceRefresh -> {
                AppLogger.logD(
                    cLassName,
                    "{Clearing cache - action Force Refresh}"
                )
                trendingRepoDao.deleteAllCanadaInfo()
                sharedPrefsHelper.clear()

            }
            isCacheAvailable -> {
                AppLogger.logD(
                    cLassName, "{Cache Found}"
                )
                //return data from local db
                return flow { emit(trendingRepoDao.getAllCanadaInfo()) }
            }
        }

        //call Remote Api
        val apiResponse = apiService.getCanadaInfoFromApi()
        //map domain to entity
        val canadaInfoList = mutableListOf<CanadaInfoEntity>()
        apiResponse.rows.forEachIndexed { index, canadaInfoModel ->
            canadaInfoList.add(canadaInfoModel.toEntity(index))
        }
        //save to database
        trendingRepoDao.saveCanadaInfo(canadaInfoList)
        //save Title to SharedPreferences
        sharedPrefsHelper.put(
            SharedPrefsHelper.TOOLBAR_TITLE,
            apiResponse.title
        )
        return flow { emit(canadaInfoList) }
    }

    /**
     * Returns Toolbar titile from shared preferences
     */
    fun getToolbarTitle(): ToolbarTitle {
        return ToolbarTitle(sharedPrefsHelper[SharedPrefsHelper.TOOLBAR_TITLE, "Toolbar"])

    }
}