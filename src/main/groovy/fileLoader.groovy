package main.groovy

def getLibraryResource(pathToFile){
    try{
        def result = librarResource pathToFile
    }catch(Exception e){
        error("Unable to load file: " + pathToFile)
    }

    return result
}