package main.groovy

def getLibraryResource(pathToFile){

    try{
        throw new Exception("this happened")

        def result = librarResource pathToFile
    }catch(Exception e){
        println(e)
        error("Unable to load file:" + pathToFile)
    }



}