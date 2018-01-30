#!/usr/bin/env groovy

package main.groovy.mypipeline;

import json

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            def libResource = libraryResource "service-config/general.json"
            println(libResource)
            def data = json.loads(libResource)
            println(data.name)
            sh('ls -a')
        }
    }
}

