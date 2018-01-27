#!/usr/bin/env groovy

package main.org.cranek.v1;

def checkout(){
    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
        }
    }
}