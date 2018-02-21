package main.groovy

def getLibraryResource(pathToFile){
    def result
    try{
        result = libraryResource pathToFile
    }catch(Exception e){
        error("Unable to load: " + pathToFile)
    }

    return result
}

return this