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

rootProject.name = "BonVoyage"
include(":app")
include(":network")
include(":network-impl")
include(":core-di")
include(":persistence")
include(":persistence-impl")
include(":entity")
include(":use-cases")
include(":use-cases-impl")
include(":repository")
include(":repository-impl")
