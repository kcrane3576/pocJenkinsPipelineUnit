#!/usr/bin/env groovy

def checkout(){

    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
        }
    }
}