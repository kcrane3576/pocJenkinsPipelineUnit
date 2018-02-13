#!/usr/bin/env groovy

package main.groovy

import groovy.json.JsonBuilder

def checkout(String serviceName){
    node{
        stage("checkout"){
            checkout scm

            def jsonBuilder = new main.groovy.jsonBuilder()
            def json = jsonBuilder.getJenkinsfileConfig(serviceName)
            println(new JsonBuilder(json).toPrettyString())

        }
    }
}