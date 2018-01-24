def gitCheckout(){
    node{
        stage("checkout"){
            checkout scm
        }
    }
}