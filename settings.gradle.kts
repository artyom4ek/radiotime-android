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
include(":features")
include(":features:home")
include(":features:radio")
include(":features:podcasts")
include(":domain")
include(":data")
