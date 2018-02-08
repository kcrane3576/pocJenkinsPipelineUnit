# Jenkinsfile for this shared library
```groovy
#!/usr/bin/env groovy

@Library("jenkinsfiles") _

def pipeline = new main.groovy.pipelineGeneral()

//expected pattern: sytem-service
def serviceName = "ip-service1"

pipeline.checkout(serviceName)
```
