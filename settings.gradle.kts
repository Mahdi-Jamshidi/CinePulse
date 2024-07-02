pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "CinePulse"
include(":app")
include(":data:model")
include(":data:network")
include(":data:api:tmdb")
include(":data:tmdb-movies")
include(":domain:tmdb-movies")
include(":feature:movie-detail")
include(":feature:home")
