# Usage
```groovy
#!/usr/bin/env groovy

@Library("jenkinsfiles") _

def pipeline = new main.groovy.pipelineGeneral()

//expected pattern (sytem-service)
def serviceName = "poc-jhipster"

pipeline.checkout(serviceName)
```
