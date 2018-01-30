#!/usr/bin/env groovy

package main.groovy.mypipeline;
import groovy.json.JsonSlurperClassic

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            def libResource = libraryResource "service-config/general.json"
            def object = readJSON text: libResource
            println(libResource)
            println(object.name)

            sh('ls -a')
        }
    }
}

