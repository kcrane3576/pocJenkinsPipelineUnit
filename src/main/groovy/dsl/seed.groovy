import groovy.util.*

def getPipelineConfig(){

    def slurper = new ConfigSlurper()
    def workspacePath = "${new File(__FILE__).parent}"
    def pipelineConfigPath = workspacePath + "/pipelineConfig.groovy"
    def config = slurper.parse(readFileFromWorkspace(pipelineConfigPath))

    return config.pipelineConfig

}

def buildPipeline(pipelineConfig, service){

    pipelineJob(service.jobName) {

        definition {
            cpsScm{
                scm {
                    git {

                        remote { url(service.repository) }
                        branches(pipelineConfig.definition.scm.branch)
                        extensions { }  // required as otherwise it may try to tag the repo, which you may not want

                    }
                }
                scriptPath(pipelineConfig.definition.scm.scriptPath)
            }
        }
        parameters {
            passwordParameterDefinition {

                def passwordParameterDefinition = pipelineConfig.parameters.passwordParameterDefinition

                name(pipelineConfig.parameters.passwordParameterDefinition.name)
                defaultValue(passwordParameterDefinition.defaultValue)
                description(passwordParameterDefinition.description)

            }
            gitParameterDefinition {

                def gitParameterDefinition = pipelineConfig.parameters.gitParameterDefinition

                name(gitParameterDefinition.name)
                type(gitParameterDefinition.type)
                defaultValue(gitParameterDefinition.defaultValue)
                description(gitParameterDefinition.description)
                branch(gitParameterDefinition.branch)
                branchFilter(gitParameterDefinition.branchFilter)
                tagFilter(gitParameterDefinition.tagFilter)
                sortMode(gitParameterDefinition.sortMode)
                selectedValue(gitParameterDefinition.selectedValue)
                useRepository(gitParameterDefinition.useRepository)
                quickFilterEnabled(gitParameterDefinition.quickFilterEnabled)

            }
        }
    }
}

def buildPipelineJobs(){

    def pipelineConfig = getPipelineConfig()

    pipelineConfig.services.each{ service, data ->
        buildPipeline(pipelineConfig, data)
    }

}

buildPipelineJobs()