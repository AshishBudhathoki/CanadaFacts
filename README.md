# Canada Facts

An Android app as the assignment to fetch the data from the given API. 
Designed with clean architecture guidelines,modular approach, Repository Pattern,  MVVM architectural pattern with Android Architecture Components.

Min API Level Supported : 16 (Jelly Bean)

## Prerequisite

Before running the project, please check if your gradle version matches the project's version
```
package-name: com.mvvmclean.trendingrepos
```
    compileSdkVersion = 29
    targetSdkVersion = 16
    minSdkVersion = 16
    buildToolsVersion = "29.0.2"

    
## Development Environment

  Android Studio 4.1.2
  Build #AI-201.8743.12.41.7042882, built on December 20, 2020
  Runtime version: 1.8.0_242-release-1644-b3-6915495 x86_64
  VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
  macOS 10.15.2
  

## Architecture

The Application is split into a three layer architecture inorder to provide clean separation of concerns - making the code easier to navigate and maintain.
- Data - Layer that holds APIs, Database, Cache
- Domain - Layer that holds Use Cases, and Model Objects. Business logic happens here.
- Application - Layer that holds presentation, Android components, Viewmodels, Dagger components/modules handles Dependency Injection, etc. MVVM exists at this layer.

The three layered architectural approach is majorly guided by clean architecture which provides
a clear separation of concerns with its Abstraction Principle.
 
## Testing

 - `app/test/ - Unit tests` - test -> Right click on package name(com.demo.aboutcanada) -> Run Test In 'com.demo.aboutcanada'
 - `app/androidTest/ - Instrumentation tests` - androidTest -> Right click on package name(com.demo.aboutcanada) -> Run Test In 'com.demo.aboutcanada'

## Libraries

Following are the Libraries used:

- [Material Design](https://material.io/develop/android/docs/getting-started/) - Google material design UIs.
- [Dagger2](https://github.com/google/dagger) - Dependency Injection lib with large community support.
- [Retrofit](https://square.github.io/retrofit/) - Network Http Client
- [Jetpack](https://developer.android.com/jetpack)
- [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Channel between use cases and UI
- [Data Binding](https://developer.android.com/topic/libraries/data-binding) - For binding of UI components in layouts to data sources, and coroutines support.
- [Moshi](https://github.com/square/moshi) - Data, Model & Entity JSON Parser that understands Kotlin non-nullable and default parameters
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - logs HTTP request and response data.
- [Mockito](https://site.mockito.org/) - Mocking framework used in unit tests.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines, provides `runBlocking` coroutine builder used in tests
- [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) - web server for testing HTTP clients.
- [Leak Canary](https://square.github.io/leakcanary/) - Leak Detection Library
- [Espresso](https://developer.android.com/training/testing/espresso) - Test framework to write UI Tests
- [recyclerview-animators](https://github.com/wasabeef/recyclerview-animators) - Recycler View Animations
- [Room Persistence Library](https://developer.android.com/topic/libraries/architecture/room) - Robust database access while harnessing the full power of SQLite
- [Robolectric](http://robolectric.org/) - Android Unit Tests framework.
- [Truth](https://truth.dev/) - Provides fluent assertions for Java and Android

## Extras

#### Gradle Dependencies

- dependencies.gradle - Centralized versioning of gradle dependencies in a global file

#### Resource Values

- Fonts
- Dimension & String Values
- Themes & Styles
- Network Config






