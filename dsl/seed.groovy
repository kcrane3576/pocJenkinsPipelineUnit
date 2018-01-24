pipelineJob('Pipeline02') {

    def repo = 'https://bitbucket.org/kcrane/jhipster-basic-micro-mongo.git'

    definition {
        scm {
            git {
                remote { url(repo) }
                branches('master')
                scriptPath('Jenkinsfile')
                extensions { }  // required as otherwise it may try to tag the repo, which you may not want
            }
        }
        parameters {
            passwordParameterDefinition {
                name('SECRET_ACCESS_KEY')
                defaultValue(null)
                description('')
            }
            gitParameterDefinition {
                name('branch_selector')
                type('PT_BRANCH_TAG')
                defaultValue('origin/master')
                description('')
                branch('')
                branchFilter('.*')
                tagFilter('*')
                sortMode('ASCENDING')
                selectedValue('DEFAULT')
                useRepository('')
                quickFilterEnabled(false)
            }
        }
    }
}


