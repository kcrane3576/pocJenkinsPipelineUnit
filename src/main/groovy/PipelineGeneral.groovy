#!/usr/bin/env groovy

package main.groovy.mypipeline;

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            def libResource = libraryResource "service-config/general.json"
            println(libResource)
            sh('ls -a')
        }
    }
}

