
package main.groovy

def getJenkinsfileConfig(serviceName){
    def system = getSystem(serviceName)
    def json = getJson(serviceName, system)

    println(json)

}

def getSystem(serviceName){
    def system = serviceName.substring(0, serviceName.indexOf('-'))

    return system
}

def getJson(serviceName, system){

    def filePaths = getFilePaths(serviceName, system)

    def defaultJson = libraryResource filePaths.get("default")
    def systemJson = libraryResource filePaths.get("system")
    def serviceJson = libraryResource filePaths.get("service")

    println(defaultJson)
    println(systemJson)
    println(serviceJson)

}


def getFilePaths(serviceName, system){
    def filePaths = [:]

    def serviceConfig = "service-config"
    def jsonFormat = ".json"

    //builds the default file path
    def defaultFilePath = new StringBuilder()
            .append(serviceConfig)
            .append("/")
            .append("default")
            .append(jsonFormat)
            .toString()

    //builds the system file path
    def systemFilePath = new StringBuilder()
            .append(serviceConfig)
            .append("/")
            .append(system)
            .append("/")
            .append(system)
            .append(jsonFormat)
            .toString()

    //builds the service file path
    def serviceFilePath = new StringBuilder()
            .append(serviceConfig)
            .append("/")
            .append(system)
            .append("/")
            .append(serviceName)
            .append(jsonFormat)
            .toString()

    println(serviceFilePath)

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
