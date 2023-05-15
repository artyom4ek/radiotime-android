pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Radiotime"
include(":app")
include(":common")
include(":data")
include(":domain")
include(":features")
include(":features:categorydetails")
include(":features:details")
include(":features:home")
include(":features:radio")
include(":features:podcasts")
include(":navigation")
