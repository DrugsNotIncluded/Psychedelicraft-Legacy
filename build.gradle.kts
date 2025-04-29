repositories {
    mavenCentral()
}

plugins {
    id("com.gtnewhorizons.gtnhconvention")
}

dependencies {
    implementation("org.eclipse.jgit:org.eclipse.jgit:6.8.0.202311291450-r")
}

val NEXT_VERSION = "1.5.3"
version = NEXT_VERSION

fun getGitHash(): String {
    return try {
        org.eclipse.jgit.lib.RepositoryBuilder()
            .findGitDir(project.rootDir)
            .build()
            .use { repo -> repo.resolve("HEAD")?.name?.take(7) ?: "unknown" }
    } catch (e: Exception) {
        "unknown"
    }
}

fun hasUncommittedChanges(): Boolean {
    return try {
        org.eclipse.jgit.lib.RepositoryBuilder()
            .findGitDir(project.rootDir)
            .build()
            .use { repo ->
                org.eclipse.jgit.api.Git(repo).status().call().hasUncommittedChanges()
            }
    } catch (e: Exception) {
        false
    }
}

// Apply version suffixes
if (!project.hasProperty("noCommitHash")) {
    val gitHash = getGitHash()
    version = "$version"
    if (hasUncommittedChanges()) {
        version = "$version-dirty"
    }
}