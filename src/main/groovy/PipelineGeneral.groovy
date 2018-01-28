#!/usr/bin/env groovy

package main.groovy.mypipeline;

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
        }
    }
}