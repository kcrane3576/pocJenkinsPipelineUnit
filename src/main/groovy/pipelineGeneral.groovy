#!/usr/bin/env groovy

package main.groovy

def checkout(String serviceName){
    node{
        stage("checkout"){
            checkout scm

            def jsonBuilder = new main.groovy.jsonBuilder()
            def jenkinsfileConfig = jsonBuilder.getJenkinsfileConfig(serviceName)
            println(jenkinsfileConfig)
            println(jenkinsfileConfig.getClass())

            println(jenkinsfileConfig.obj.id)
            println(jenkinsfileConfig.name)
            println(jenkinsfileConfig.env.splunk)
            println(jenkinsfileConfig.env.vpc)

        }
    }
}