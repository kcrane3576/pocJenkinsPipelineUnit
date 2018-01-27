#!/usr/bin/env groovy

def checkout(){

    node{
        stage("checkout"){
            sh(ls -a)

            checkout scm
        }
    }
}