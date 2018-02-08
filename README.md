# Usage
```groovy
#!/usr/bin/env groovy

@Library("jenkinsfiles") _

def pipeline = new main.groovy.pipelineGeneral()

//the pattern expected is sytem-service
def serviceName = "poc-jhipster"
pipeline.checkout(serviceName)
```
