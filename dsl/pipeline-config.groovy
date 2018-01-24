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
            jobName = "jhipster-basic-micro-mongo"
            testName = "jhipster-basic-micro-mongo-test"
            repository = "https://bitbucket.org/kcrane/jhipster-basic-micro-mongo.git"
        }
        micro2 {
            jobName = "jhipster-basic-micro-mongo2"
            testName = "jhipster-basic-micro-mongo2-test"
            repository = "https://bitbucket.org/kcrane/jhipster-basic-micro-mongo.git"
        }
    }

}