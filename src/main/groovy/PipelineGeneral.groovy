#!/usr/bin/env groovy

package main.groovy.mypipeline;

import groovy.json.JsonSlurper

def writeIt(){
    def functions = libraryResource 'src/main/resources/functions.sh'
    writeFile file: 'functions.sh', text: functions
    sh "source function.sh && foofoo"
}


def checkout(){
    node{
        stage("checkout"){
            checkout scm
            def libResource = libraryResource "../src/main/resources/general.json"
            println(libResource)
            writeIt()
            sh('ls -a')
        }
    }
}

