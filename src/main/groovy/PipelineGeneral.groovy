#!/usr/bin/env groovy

package main.groovy.mypipeline;

import groovy.json.JsonSlurper

def getConfig(){

    def inputFile = new File('../resources/service-config/general.json')
    def inputJson = new JsonSlurper().parse(inputFile)
    println(inputJson)


}

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
            getConfig()
        }
    }
}