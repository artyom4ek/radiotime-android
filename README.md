# Radiotime

The Radiotime app allows you to listen to your favorite radio stations and podcasts from around the
world.

## Features

- Universal data parsing and display by category
- Playing audio in the player bar with the ability to stop and resume
- Ability to show more radio stations or podcasts
- Convenient app navigation
- Data loading screen with shimmer
- Dark mode/light mode
- Advanced UX
- Design using Material Design 3 concepts

## Project description

### UI/UX

The initial link contains 7 elements:

- Local Radio
- Music
- Talk
- Sports
- By Location
- By Language
- Podcasts

After analyzing each link, I grouped them into separate screens:

- `Home` (contains other categories, which can be either radio stations or podcasts)
- `Radio` (contains local radio stations)
- `Podcasts` (contains a list of podcast categories)

Thus, we can use the `BottomBar` and assign this group to each tab.

### Core logic

The project consists of modules:

- `navigation` and `common` modules
- individual features (screens) are stored in `features`
- business logic in `domain` module
- the data is in the `data` module.

The main logic for providing and processing data is located in `data` module. The main classes are
the `parser` and `mappers` (the main one being `RawDataMapper`). The `Parser` serves to parse the
response and analyze its objects. The analysis consists in finding out what type of data needs to be
processed.

After a deep analysis of the links, I identified 4 categories (Content Type):

- `grid` (we can assume that this is a category that consists only of the name and type of link)
- `list` (we can assume that this is also a category, but it has the items "show", "station" and
  others)
- `audio list` (contains audio elements)
- `empty list` (contains no elements)

Also the response (object) can contain `children`. Each such object can be considered as a `Tab`
which contains elements of one of the `4 types` that were described above.
`RawDataMapper` is needed in order to convert raw data into data of specific types (`ContentType`),
and the `Parser` helps it in this. The rest of the mappers (`DomainMapper`) convert the raw data
into specific objects with specific fields.
Thus, we have a universal parser and only one screen (`DetailsScreen`), which can display content
with different data.

## Tech Stack

* UI
    * [Jetpack Compose](https://developer.android.com/jetpack/compose) declarative UI framework
    * [Material Design 3](https://developer.android.com/jetpack/compose/designsystems/material3)

* Tech/Tools
    * [Kotlin](https://kotlinlang.org/) 100% coverage
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
      and [Flow](https://developer.android.com/kotlin/flow) for async operations
    * Gradle
        * Gradle Dependency management
        * Kotlin DSL
    * [Jetpack](https://developer.android.com/jetpack)
        * [Compose](https://developer.android.com/jetpack/compose)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) for
          navigation between composables
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that
          stores, exposes and manages UI state
        * [Media3](https://developer.android.com/jetpack/androidx/releases/media3) for playing audio

    * [Dependency Injection](https://developer.android.com/training/dependency-injection)
        * [Hilt](https://dagger.dev/hilt/) - Standard library to incorporate Dagger dependency
          injection into an Android application
        * [Hilt-ViewModel](https://developer.android.com/training/dependency-injection/hilt-jetpack)
            - DI for injecting `ViewModel`

    * Networking
        * [Retrofit 2](https://square.github.io/retrofit/)
        * [Kotlinx Serialization](https://kotlinlang.org/docs/serialization.html)
        * OkHttp3
        * Json structure

    * [Coil](https://github.com/coil-kt/coil) for image loading

    * [Compose Shimmer](https://github.com/valentinilk/compose-shimmer) for a shimmer effect that
      traverses across the whole screen
    * [Timber](https://github.com/JakeWharton/timber) logger

* Modern Architecture
    * Single Activity architecture
    * [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
    * MVI (Model View Intent)
    * [Modularization](https://developer.android.com/topic/modularization)
    * Repository pattern
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture)
    * Solid Principles

* Tests
    * jUnit4
    * Mockito

## Module Design

| Module name        | Type                 | Description                                  |
| -------------      | -------------        | -------------                                |
| [app](/app/)  | Android Application  | MainActivity, BaseApplication, Theme, Hilt setup. |
| [buildSrc](/buildSrc/)               | Kotlin DSL  | Gradle Dependency management. |
| [common](/common/)    | Java/Kotlin Library  | Common components and settings for all modules. |     
| [data](/data/)    | Java/Kotlin Library  | Data-source (network, mappers, repositories etc). |
| [domain](/domain/)        | Java/Kotlin Library  | Domain models and interfaces data for feature modules. |
| [features-details](/features/details/)   | Java/Kotlin Library  | UI components for the Details screen.   |
| [features-home](/features/home/)        | Java/Kotlin Library      | UI components for the Home screen.    |
| [features-podcasts](/features/podcasts/)      | Java/Kotlin Library      | UI components for the Podcasts screen.|
| [features-radio](/features/radio/)          | Java/Kotlin Library  | UI components for the Radio screen.|
| [navigation](/navigation/)         | Java/Kotlin Library      | Project navigation logic. |

## TODOs

* Improve data parsing logic (see `TODO` annotation)
* Add screen state when changing tabs (see `FIXME` annotation)
* Move MainActivity and logic to Main feature
* Improve Theme and move duplicate components into a common module
* Show screen with player and audio data when clicking on audio element and player bar
* Add Shared ViewModel for Media
* Add custom errors to Domain module
* Add dynamic title to Details Screen toolbar
* Add PullRefresh for each screen
* Add a foreground service to play audio in the background
* Add an audio loading indicator
* Add favorite podcast/station list tab
* Add tests for classes with core logic
* etc.