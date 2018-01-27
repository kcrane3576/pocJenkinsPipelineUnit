#!/usr/bin/env groovy

def checkout(){

    node{

        sh('cd .. && ls -a')

        stage("checkout"){
            checkout scm
//            sh('ls -a')
        }
    }
}