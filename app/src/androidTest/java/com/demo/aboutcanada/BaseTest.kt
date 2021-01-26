package com.demo.aboutcanada

import android.os.SystemClock
import android.util.Log
import com.demo.aboutcanada.sample.apiSuccessResult
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import java.net.HttpURLConnection

open class BaseTest {

    companion object {
        const val SYSTEM_ACTION_INTERVAL_TIME = 2000L
    }

    lateinit var mockWebServer: MockWebServer

    @Before
    open fun setup() {
        mockWebServer = MockWebServer().apply {
            dispatcher = CanadaInfoApiRequestActivity()
            start(8081)
        }
    }

    @After
    open fun tearDown() {
        mockWebServer.shutdown()
    }

    fun sleep() {
        SystemClock.sleep(SYSTEM_ACTION_INTERVAL_TIME)
    }
}

internal class CanadaInfoApiRequestActivity : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {
        return when (request.path) {
            "/facts" -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(apiSuccessResult)
            }
            else -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
            }
        }
    }

}