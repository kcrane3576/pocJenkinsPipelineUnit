pipelineConfig {
    definition {
        scm {
            scriptPath = "jenkinsfiles/Jenkinsfile"
            branch = "master"
        }
    }
    parameters {
        passwordParameterDefinition {
            name = "SECRET_ACCESS_KEY"
            defaultValue = null
            description = ""
        }
        gitParameterDefinition {
            name = "\${branch_selector}"
            type = "PT_BRANCH_TAG"
            defaultValue = "origin/master"
            description = ""
            branch = ""
            branchFilter = ".*"
            tagFilter = "*"
            sortMode = "ASCENDING"
            selectedValue = "DEFAULT"
            useRepository = ""
            quickFilterEnabled = false
        }
    }
    logRotator {
        numToKeep = 10
    }
    triggers {
        scm = "H/5 * * * *"
    }
    services {
        micro1 {
            jobName = "pocMonolith"
            testName = "pocMonolith-test"
            repository = "https://github.com/kcrane3576/pocMonolith.git"
        }
    }

}