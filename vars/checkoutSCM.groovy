#!/usr/bin/env groovy
import groovy.json.*

void getJenkinsfileConfig() {
//    def serviceConfigDirectory = "../service-config/"
//    def serviceConfigPath = serviceConfigDirectory + "general-config.json"

    def genConf = libraryResource "../service-config/general-config.json"
    println(genConf)

//    def jsonSlurper = new JsonSlurper()
//    def data = jsonSlurper.parseText(new File(serviceConfigPath).text)
//    for(String key : data){
//        println(key)
//    }
}

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
        }
    }

    x

    getJenkinsfileConfig()
}
