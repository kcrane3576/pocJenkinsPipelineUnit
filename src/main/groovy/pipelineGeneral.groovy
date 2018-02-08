#!/usr/bin/env groovy

package main.groovy;

def checkout(serviceName){
    node{
        stage("checkout"){
            checkout scm

//            def service = libraryResource "service-config/service.json"
//            def ip = libraryResource "service-config/ip/ip.json"
//            def ipService1 = libraryResource "service-config/ip/ip-service.json"

//            combineJson(gen, sys, sysServ)

            println(serviceName)

//            jsonBuilder.getJenkinsfileConfig(serviceName)


        }
    }
}

def getSystem(serviceName){

}

def getJenkinsfileConfig(json){

}

def combineJson2(dominant, recessive){

    def dominantKeys = dominant.keySet()
    def recessiveKeys = recessive.keySet()

}

def combineJson(gen, sys, sysServ){

    def jenkinsfileConfig = [:]

    def genKeys = gen.keySet()
    def sysKeys = sys.keySet()
    def sysServKeys = sysServ.keySet()

    for(int i = 0; i < genKeys.size(); i++){
        if(sysServKeys[i].equals(genKeys[i])){
            jenkinsfileConfig[sysServKeys[i]] = sys.sysServKeys[i]
        }
    }

    jenkinsfileConfig.each { key, value ->
        println("${key}:${value}")

    }

}