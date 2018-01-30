#!/usr/bin/env groovy

package main.groovy.mypipeline;
import groovy.json.JsonSlurper

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            def libResource = libraryResource "service-config/general.json"
            println(libResource)
            def jsonSlurper = new JsonSlurper()
            assert libResource instanceof String
            data = jsonSlurper.parseText(libResource)
            println(data.name)


            println(data.name)
            sh('ls -a')
        }
    }
}

