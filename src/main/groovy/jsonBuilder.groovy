package main.groovy


// retrieve 1 json configuration from 3 sources
// - 'service' takes precedence over 'system'
// - 'system' takes precedence over 'default'
def getJenkinsfileConfig(serviceName){
    def system = getSystem(serviceName)
    def json = getJson(serviceName, system)

    //TODO return merged json to be used within the pipeline
}

def getSystem(serviceName){
    def system = serviceName.substring(0, serviceName.indexOf('-'))

    return system
}

def getJson(serviceName, system){
    def filePaths = getFilePaths(serviceName, system)

    def fileLoader = new main.groovy.fileLoader()
    def defaultJson = fileLoader.getLibraryResource(filePaths.get("default"))
    def systemJson =  fileLoader.getLibraryResource(filePaths.get("system"))
    def serviceJson =  fileLoader.getLibraryResource(filePaths.get("service"))

    println(defaultJson)
    println(systemJson)
    println(serviceJson)
    
    //TODO merge json
}

def getFilePaths(serviceName, system){
    def filePaths = [:]

    def serviceConfig = "service-config"
    def jsonFormat = ".json"

    def defaultFilePath = serviceConfig + "/default" + jsonFormat
    filePaths.put("default", defaultFilePath)

    def systemFilePath = serviceConfig + "/" + system + "/" + system + jsonFormat
    filePaths.put("system", systemFilePath)

    def serviceFilePath = serviceConfig + "/" + system + "/" +serviceName + jsonFormat
    filePaths.put("service", serviceFilePath)

    return filePaths
}


//TODO IN DEVELOPMENT
def combineJson2(dominant, recessive){
    def dominantKeys = dominant.keySet()
    def recessiveKeys = recessive.keySet()
}

//TODO IN DEVELOPMENT
def combineJson(gen, sys, sysServ){

    def jenkinsfileConfig = [:]

    def genKeys = gen.keySet()
    def sysKeys = sys.keySet()
    def sysServKeys = sysServ.keySet()

    for(int i = 0; i < genKeys.size(); i++){
        if(sysServKeys[i].equals(genKeys[i])){
            jenkinsfileConfig[sysServKeys[i]] = sys.sysServKeys[i]
        }
    }

    jenkinsfileConfig.each { key, value ->
        println("${key}:${value}")

    }

}
