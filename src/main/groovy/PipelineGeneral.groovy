#!/usr/bin/env groovy

package main.groovy.mypipeline;
import groovy.json.JsonSlurperClassic

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            def general = libraryResource "service-config/general.json"
            def system = libraryResource "service-config/ip/ip-general.json"
            def systemService = libraryResource "service-config/ip/ip-service.json"
            def gen = readJSON text: general
            def sys = readJSON text: system
            def sysServ = readJSON text: systemService

//            println(general)
//            println(object.name)
            println(gen.name)
            println(sys.name)
            println(sysServ.name)
            combineJson(gen, sys, sysServ)

//            sh('ls -a')


        }
    }
}


def combineJson(gen, sys, sysServ){

    def jenkinsfileConfig = [:]

    def genKeys = gen.keySet()
    def sysKeys = sys.keySet()
    def sysServKeys = sysServ.keySet()

    for(int i = 0; i < genKeys.length; i++){
        if(sysServKeys[i].equals(genKeys[i])){
            jenkinsfileConfig[sysServKeys[i]] = sys.sysServKeys[i]
        }
    }

    jenkinsfileConfig.each { key, value ->
        println("${key}:${value}")

    }

}
