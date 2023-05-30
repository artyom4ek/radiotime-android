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

## Screenshots

<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/6159ca76-d600-4880-8397-2c41536bfcda" alt="Home Tab" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/51591bd7-84c5-4027-b37d-7eb3f5f2e69d" alt="Radio Tab" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/de800446-b1ca-4b6d-adff-4cb6dcb690c4" alt="Podcasts Tab" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/adcc3447-d046-4c18-ae80-d824bf9653d5" alt="Category Grid" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/f8a81045-10e2-4e64-8c4f-ce279b8f1824" alt="Category List" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/17dded82-ea1a-4245-a349-d7b0e79cb1c9" alt="Audio List" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/d082abb7-aba2-44f6-960a-8017d6e25318" alt="Playing Audio" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/19416b7a-278d-4352-808a-6fe8882cb99b" alt="Home tab with Player Bar" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/dcc9f096-0417-484d-8b87-090a020ce964" alt="Display Error" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/027a61d2-d6be-4496-9132-1efc116066b7" alt="Empty screen" width="20%" height="20%">

### Light Theme

<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/9d819d1c-8fcc-4ba0-8ac9-a784e4e15408" alt="Home Tab" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/9792639a-d856-4d38-8443-6e341faa650f" alt="Radio Tab" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/c7d067ff-e4d5-4e81-a624-bd8a1cb7338f" alt="Podcasts Tab" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/a49097a9-20de-4140-ae95-99c6ce181648" alt="Category Grid" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/d9d94ea4-a951-473e-b2cb-2d9c9d766f33" alt="Category List" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/d1acec93-1021-43e8-ab87-835a27ddb1b5" alt="Audio List" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/07a161ea-e817-43c4-a0ab-8dc521db4735" alt="Playing Audio" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/7957ef86-1283-4461-93eb-c4a9f8b5532b" alt="Home tab with Player Bar" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/01f3e6d5-c5e9-40a1-a11c-87630434dace" alt="Display Error" width="20%" height="20%">
<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/2aa4d628-11a2-49ef-be52-e513823656d5" alt="Empty Screen" width="20%" height="20%">

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

- `Home` (contains categories that can be both radio stations and podcasts)
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

- `grid` (it can be assumed that this is a category consisting only of the name and link type)
- `list` (it can be assumed that this is also a category, but it contains the items "show", "
  station" and others)
- `audio list` (contains only audio elements)
- `empty list` (contains no elements)

Also the response (object) can contain `children`. Each such object can be considered as a `Tab`
which contains elements of one of the `4 types` that were described above.
`RawDataMapper` is needed in order to convert raw data into data of specific types (`ContentType`),
and the `Parser` helps it in this. The rest of the mappers (`DomainMapper`) convert the raw data
into specific objects with specific fields.
Thus, we have a universal parser and only one screen (`DetailsScreen`), which can display content
with different data.

## Development process

* Standard `Git Flow` with branches:
    * `main` - represents the stable and deployable version of the codebase
    * `develop`- serves as a staging area for ongoing development work
    * `features` - used for implementing specific features or functionality in separate branches

## Tech Stack

* IDE
    * Android Studio Flamingo 2022.2.1 Patch 2
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

## Architectural Design

<img src="https://github.com/artyom4ek/radiotime-android/assets/10499697/206f5b13-2213-499a-9ecd-4254d4a9c215" alt="Architectural Design" width="60%" height="60%">

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

## Tests

### Unit tests

1. [ParserTest.kt](data/src/androidTest/kotlin/com/tunein/radiotime/data/parser/ParserTest.kt)

## Tested on

1. Physical device: Xiaomi Redmi Note 6 Pro (Android 9, API level 29)
2. Virtual device: Android smartphone emulators (Android 13, API level 33)

## TODOs

* Improve data parsing logic (see `TODO` annotation)
* Add screen state when changing tabs (see `FIXME` annotation)
* Fix "Source Error" error when playing some audio formats
* Add Splash screen
* Move MainActivity and logic to Main feature
* Improve shimmer color for light theme
* Improve Theme and move duplicate components into a common module
* Customize design for tablets
* Show screen with player and audio data when clicking on audio element and player bar
* Add Shared ViewModel for Media logic
* Add custom errors to Domain module
* Add dynamic title to Details Screen toolbar
* Add more Unit tests for classes with core logic
* Add UI tests
* Add PullRefresh for each screen
* Add a foreground service to play audio in the background
* Add an audio loading indicator
* Add favorite podcast/station list tab
* etc.