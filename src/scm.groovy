def checkout(repo){
    node{
        stage("checkout"){
            scm {
                git {
                    remote { url(repo) }
                    branches('master')
                    scriptPath('Jenkinsfile')
                    extensions { }  // required as otherwise it may try to tag the repo, which you may not want
                }
            }
        }
    }
}