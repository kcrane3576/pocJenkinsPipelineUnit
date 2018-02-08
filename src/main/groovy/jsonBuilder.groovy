
package main.groovy

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

    def resource = new main.groovy.fileLoader()
    resource.getLibraryResource(filePaths.get("default"))

    def defaultJson = libraryResource filePaths.get("default")
    def systemJson = libraryResource filePaths.get("system")
    def serviceJson = libraryResource filePaths.get("service")

    println(defaultJson)
    println(systemJson)
    println(serviceJson)
    
    //TODO merge json

}

def getFilePaths(serviceName, system){
    def filePaths = [:]

    def serviceConfig = "service-config"
    def jsonFormat = ".json"

    //builds the default file path
//    def defaultFilePath = new StringBuilder()
//            .append(serviceConfig)
//            .append("/")
//            .append("default")
//            .append(jsonFormat)
//            .toString()

    def defaultFilePath = serviceConfig + "/default/" + jsonForma

    //builds the system file path
//    def systemFilePath = new StringBuilder()
//            .append(serviceConfig)
//            .append("/")
//            .append(system)
//            .append("/")
//            .append(system)
//            .append(jsonFormat)
//            .toString()

    def systemFilePath = serviceConfig + "/" + system + "/" + system + jsonFormat

    //builds the service file path
//    def serviceFilePath = new StringBuilder()
//            .append(serviceConfig)
//            .append("/")
//            .append(system)
//            .append("/")
//            .append(serviceName)
//            .append(jsonFormat)
//            .toString()

    def serviceFilePath = serviceConfig + "/" + system + "/" +serviceName + jsonFormat

    filePaths.put("default", defaultFilePath)
    filePaths.put("system", systemFilePath)
    filePaths.put("service", serviceFilePath)

    return filePaths
}

def combineJson2(dominant, recessive){

    def dominantKeys = dominant.keySet()
    def recessiveKeys = recessive.keySet()

}

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
