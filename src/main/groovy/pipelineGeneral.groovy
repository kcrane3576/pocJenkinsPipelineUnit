Map<String, String> imports() {
    [
            configBuilder            : 'pocJenkinsPipelineUnit/src/main/groovy/configBuilder.groovy'
    ]
}

def checkout(String serviceName){
    node{
        stage("checkout"){
            checkout scm

//            def configBuilder = main.groovy.configBuilder

            def jenkinsfileConfig = configBuilder.getJenkinsfileConfig(serviceName)
            println(jenkinsfileConfig)

            println(jenkinsfileConfig.obj.id)
            println(jenkinsfileConfig.name)
            println(jenkinsfileConfig.env.splunk)
            println(jenkinsfileConfig.env.vpc)

        }
    }
}

return this