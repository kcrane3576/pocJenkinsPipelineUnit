#!/usr/bin/env groovy

package main.groovy.mypipeline;

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            //TODO this works for top level resources directory
//            def libResource = libraryResource "general.json"
            def libResource = libraryResource "../src/main/resources/general.json"
            println(libResource)
            sh('ls -a')
        }
    }
}

