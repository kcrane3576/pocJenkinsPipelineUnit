#!/usr/bin/env groovy

package main.groovy.mypipeline;

import groovy.json.JsonSlurper

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
            def libResource = libraryResource "general.json"
            println(libResource)
        }
    }
}