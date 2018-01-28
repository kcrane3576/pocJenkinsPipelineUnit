# Usage
```groovy
#!/usr/bin/env groovy

@Library("jenkinsfiles") _

def pipeline = new main.groovy.PipelineGeneral()
pipeline.checkout()
```
