import groovy.json.JsonSlurperClassic


Map<String, String> imports() {
    [
            fileLoader            : 'pocJenkinsPipelineUnit/src/main/groovy/fileLoader.groovy'
    ]
}


// retrieve 1 json configuration from 3 sources
// - 'service' takes precedence over 'system'
// - 'system' takes precedence over 'default'
def getJenkinsfileConfig(serviceName){
    def system = getSystem(serviceName)
    def json = getConfig(serviceName, system)

    return json
}

def getSystem(serviceName){
    def system = serviceName.substring(0, serviceName.indexOf('-'))

    return system
}

def getConfig(serviceName, system){
    def filePaths = getFilePaths(serviceName, system)

//    def fileLoader = main.groovy.fileLoader
    def jsonSlurperClassic = new JsonSlurperClassic()
    def defaultJson = jsonSlurperClassic.parseText((String) fileLoader.getLibraryResource(filePaths.get("default")))
    def systemJson =  jsonSlurperClassic.parseText((String) fileLoader.getLibraryResource(filePaths.get("system")))
    def serviceJson =  jsonSlurperClassic.parseText((String) fileLoader.getLibraryResource(filePaths.get("service")))

    def result = combineConfig(systemJson, defaultJson)
    result = combineConfig(serviceJson, result)

    return result
}

def getFilePaths(serviceName, system){
    def filePaths = [:]

    def configDirectory = "service-config"
    def jsonFormat = ".json"

    def defaultFilePath = configDirectory + "/default" + jsonFormat
    filePaths.put("default", defaultFilePath)

    def systemFilePath = configDirectory + "/" + system + "/" + system + jsonFormat
    filePaths.put("system", systemFilePath)

    def serviceFilePath = configDirectory + "/" + system + "/" +serviceName + jsonFormat
    filePaths.put("service", serviceFilePath)

    return filePaths
}


def combineConfig(dominant, recessive){
    def result = [:]

    //loop over each element in the dominant map
    dominant.each{ dKey, dValue ->

        def rValue = recessive.get(dKey)

        //check if the recessive object includes the same key
        if(rValue != null){
            //check if the value of the key is a map
            //based on how the files are structured, they will both be maps if one is
            if(rValue instanceof HashMap){
                def recursiveResult = [:]

                //step into the object and repeat check for the same keys
                recursiveResult.put(dKey, combineConfig(dValue, rValue))

                //add all the remaining key/value pairs from recursive call to the result map
                result.putAll(recursiveResult)

                //remove the overlapping key from the recessive map so the remaining map can be added to the result map
                recessive.remove(dKey)
            }else {
                //place dominant key/value in result map
                result.put(dKey, dValue)

                //remove recessive key/value from recessive map
                recessive.remove(dKey)
            }

        }else{
            //place key/value from dominant map in result map if not found in recessive map
            result.put(dKey, dValue)
        }

        //add all remaining key/value pairs in recessive map to the result map
        result.putAll(recessive)
    }

    return result
}

return this