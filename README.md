# Clean Architecture News App

This is a simple news application built to demonstrate clean architecture principles using Jetpack Compose, ViewModel, MVVM, Coroutines, Flows, Hilt, abstracted Repository Layer, and Data Source Layers.

## Features

- Fetches and displays news articles from a remote data source.
- Implements a clean architecture to ensure separation of concerns.
- Utilizes Jetpack Compose for the user interface.
- Implements the MVVM (Model-View-ViewModel) architecture pattern.
- Uses Coroutines and Flows for asynchronous and reactive programming.
- Integrates Hilt for dependency injection.
- Incorporates an abstracted Repository Layer for handling data operations.
- Integrates Data Source Layers for managing the source of data.

## Tech Stack

- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern Android UI toolkit.
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Architecture component for managing UI-related data.
- [MVVM](https://developer.android.com/jetpack/guide) - Model-View-ViewModel architectural pattern.
- [Coroutines](https://developer.android.com/kotlin/coroutines) - Kotlin's concise and expressive way of handling asynchronous programming.
- [Flows](https://kotlinlang.org/docs/flow.html) - Kotlin's reactive streams for asynchronous programming.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency injection library for Android.
- Abstracted [Repository Layer](https://developer.android.com/jetpack/guide#data) - Handling data operations and providing a clean API to the rest of the application.
- [Data Source Layers](https://developer.android.com/jetpack/guide#data) - Managing the source of data, whether it be a network or local database.

## Getting Started

- Clone the repository and open the project in Android Studio.
- Add your news api key (you can get it from [News Api](https://newsapi.org/)).
- Build and run the application on an emulator or a physical device.

## Contribution

- Contributions are welcome! Feel free to open issues or submit pull requests to improve the application.
  License

This project is licensed under the MIT License - see the [LICENSE](/) file for details.



## Simple News Application

This application demonstrates clean architecture principles implemented with Jetpack Compose, MVVM, Coroutines, Flows, States, Hilt, and an abstracted repository layer.

### Architecture

* **Clean Architecture:** The application is divided into layers:
    * **Presentation:** View and ViewModel (MVVM) using Jetpack Compose
    * **Data:** Repository and data sources (remote and local)
    * **Domain:** Model and business logic
* **Jetpack Compose:** Used for building the UI
* **MVVM:** ViewModel handles data and business logic, exposing it to the View
* **Coroutines:** Used to run asynchronous tasks
* **Flows:** Used to handle data streams from the repository
* **States:** Used to represent the current state of the application
* **Hilt:** Used for dependency injection
* **Abstracted Repository Layer:** Provides a single point of access to data, regardless of the source
* **Data Source Layers:** Separate implementations for local and remote data sources

### Features

* Displays a list of news articles
* Allows refreshing the news list
* Shows a loading indicator while fetching data
* Displays an error message if there is an error fetching data
* Allows saving articles to favorites
* Displays a list of favorite articles

### Technology Stack

* Android Studio
* Kotlin
* Jetpack Compose
* MVVM
* Coroutines
* Flow
* StateFlow
* Hilt
* Room (local storage)
* Retrofit (remote data)
* Dagger (dependency injection)

### Getting Started

1. Clone or download the project.
2. Add your news api key (you can get it from [News Api](https://newsapi.org/)).
3. Open the project in Android Studio.
4. Build and run the application.

### Contributing

Feel free to contribute to this project by creating pull requests.

### License

This project is licensed under the Apache License 2.0.

### Disclaimer

This project is intended for educational purposes only and is not a complete or production-ready application.
****

