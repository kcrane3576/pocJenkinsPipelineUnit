#!/usr/bin/env groovy

package main

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
        }
    }
}