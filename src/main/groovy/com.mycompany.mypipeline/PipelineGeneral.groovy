#!/usr/bin/env groovy

package main.groovy.com.mycompany.mypipeline;

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
        }
    }
}