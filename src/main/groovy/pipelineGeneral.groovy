#!/usr/bin/env groovy

package main.groovy
import main.groovy.configBuilder

def checkout(String serviceName){
    node{
        stage("checkout"){
            checkout scm

            def configBuilder = loadScript('configBuilder.groovy')

            def jenkinsfileConfig = configBuilder.getJenkinsfileConfig(serviceName)
            println(jenkinsfileConfig)

            println(jenkinsfileConfig.obj.id)
            println(jenkinsfileConfig.name)
            println(jenkinsfileConfig.env.splunk)
            println(jenkinsfileConfig.env.vpc)

        }
    }
}