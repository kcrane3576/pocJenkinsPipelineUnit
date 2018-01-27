def checkout(){
    node{
        stage("checkout"){
            checkout scm
            sh('ls -a')
        }
    }
}