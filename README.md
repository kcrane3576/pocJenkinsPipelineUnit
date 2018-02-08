# Usage
```groovy
#!/usr/bin/env groovy

@Library("jenkinsfiles") _

def pipeline = new main.groovy.pipelineGeneral()
pipeline.checkout(serviceName)
```
