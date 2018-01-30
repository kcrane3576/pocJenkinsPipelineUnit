#!/usr/bin/env groovy

package main.groovy.mypipeline;
import groovy.json.JsonSlurperClassic

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            def general = libraryResource "service-config/general.json"
            def system = libraryResource "service-config/ip-general.json"
            def systemService = libraryResource "service-config/ip-service.json"
            def gen = readJSON text: general
            def sys = readJSON text: system
            def sysServ = readJSON text: systemService

//            println(general)
//            println(object.name)
            println(gen.name)
            println(sys.name)
            println(sysServ.name)

//            sh('ls -a')


        }
    }
}

