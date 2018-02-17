#!/usr/bin/env groovy

package main.groovy

def checkout(String serviceName){
    node{
        stage("checkout"){
            checkout scm

//            def configBuilder = main.groovy.configBuilder()
            def configBuilder = load "src/main/groovy/configBuilder.groovy"
            def jenkinsfileConfig = configBuilder.getJenkinsfileConfig(serviceName)
            println(jenkinsfileConfig)

            println(jenkinsfileConfig.obj.id)
            println(jenkinsfileConfig.name)
            println(jenkinsfileConfig.env.splunk)
            println(jenkinsfileConfig.env.vpc)

        }
    }
}