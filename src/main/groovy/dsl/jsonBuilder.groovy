
def DEFAULT = "default"
def SERVICE_CONFIG = "service-config"
def JSON_FORMAT = ".json"

def getJenkinsfileConfig(serviceName){
    def system = getSystem(serviceName)
    def json = getJson(serviceName, systemm)

}

def getSystem(serviceName){
    def system = serviceName.substring(0, serviceName.indexOf('-'))

    return system
}

def getJson(serviceName, system){


//    def service = libraryResource "service-config/service.json"
//    def ip = libraryResource "service-config/ip/ip.json"
//    def ipService1 = libraryResource "service-config/ip/ip-service.json"

    def defaultJson = libraryResource SERVICE_CONFIG + "/" DEFAULT + JSON_FORMAT
    def systemJson = libraryResource SERVICE_CONFIG + "/" + system + "/" + system + JSON_FORMAT
    def serviceJson = libraryResource SERVICE_CONFIG + "/" + system + "/" + serviceName + JSON_FORMAT

    println(defaultJson)
    println(systemJson)
    println(serviceJson)

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
