pipelineConfig {
    definition {
        scm {
            scriptPath = "Jenkinsfile"
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
            jobName = "jhipster-basic-mono-micro"
            testName = "jhipster-basic-mono-micro-test"
            repository = "https://github.com/kcrane3576/pocMonolith.git"
        }
    }

}