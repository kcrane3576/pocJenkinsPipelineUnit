#!/usr/bin/env groovy

package main.groovy

def checkout(String serviceName){
    node{
        stage("checkout"){
            checkout scm

            def jsonBuilder = new main.groovy.jsonBuilder()
            jsonBuilder.getJenkinsfileConfig(serviceName)
        }
    }
}