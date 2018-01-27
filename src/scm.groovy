def gitCheckout(){
    node{
        stage("checkout"){
            sh(ls -a)

            checkout scm
        }
    }
}