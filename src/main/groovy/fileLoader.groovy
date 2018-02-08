package main.groovy

def getLibraryResource(pathToFile){
    try{
        def result = libraryResource pathToFile
    }catch(Exception e){
        error("Unable to load file: " + pathToFile)
    }

    return result
}