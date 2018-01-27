import groovy.util.*
import groovy.json.*

def getServiceConfig(String fileName){

    def serviceConfigPath = "../service-config/"
    def pathToFile = serviceConfigPath + fileName


    //executing shell command
    def sout = new StringBuilder(), serr = new StringBuilder()
    def proc = 'ls -a'.execute()
    proc.consumeProcessOutput(sout, serr)
    proc.waitForOrKill(1000)
    println(sout)

    //Checking current directory
    def currentDir = new File(".").getAbsolutePath()
    println currentDir

    def jsonSlurper = new JsonSlurper()
    def json = jsonSlurper.parseText(new File(pathToFile).text)
    for (Object key: json) {
        println(key)
    }


}

//need to read in xml as there is not an option to set script path for multipipelineJob at this time
def getFactoryNode(){
    def factorySource='''
    <factory class="org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory">
        <owner class="org.jenkinsci.plugins.workflow.multibranch.WorkflowMultiBranchProject" reference="../.."/>
        <scriptPath>jenkinsfiles/Jenkinsfile</scriptPath>
    </factory>'''

    def factoryNode= new XmlParser().parseText(factorySource)

    return factoryNode
}

def getTriggerNode(){
    def triggersSource='''
    <org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty>
        <triggers>
            <hudson.triggers.SCMTrigger>
                <spec>H/5 * * * *</spec>
                <ignorePostCommitHooks>false></ignorePostCommitHooks>
            </hudson.triggers.SCMTrigger>
        </triggers>
    </org.jenkinsci.plugins.workflow.job.properties.PipelineTriggersJobProperty>
    '''

    def triggerNode = new XmlParser().parseText(triggersSource)

    return triggerNode
}

def getPipelineConfig(){

    def slurper = new ConfigSlurper()
    def workspacePath = "${new File(__FILE__).parent}"
    def pipelineConfigPath = workspacePath + "/pipeline-config.groovy"
    def config = slurper.parse(readFileFromWorkspace(pipelineConfigPath))

    return config.pipelineConfig
}

def buildTestPipeline(pipelineConfig, service){
    def factoryNpde = getFactoryNode()
    def triggerNode = getTriggerNode()

    println(triggerNode)

    multibranchPipelineJob(service.testName) {
        branchSources{
//            git{
//                remote(service.repository)
//                includes('*')
//            }
            github{
                repository(service.repository)
            }

        }
        orphanedItemStrategy{
            discardOldItems{
                numToKeep(pipelineConfig.logRotator.numToKeep)
            }
        }
//        triggers{
//            bitbucketPush()
//        }
        configure { project ->
            project << triggerNode
        }
        configure { project ->
            project << factoryNode
        }

    }
}

def buildPipelineJobs(){

    def pipelineConfig = getPipelineConfig()

    pipelineConfig.services.each{ service, data ->
        buildTestPipeline(pipelineConfig, data)
    }
}

buildPipelineJobs()