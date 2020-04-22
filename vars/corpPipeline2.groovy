def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
        agent {
            kubernetes {
                label 'my-pod-template'
                defaultContainer 'jnlp'
                k8stemplate()
            }
        }
        stages {
            stage('Run maven') {
                steps {
                    container('maven') {
                        sh 'mvn -version'
                    }
                    container('busybox') {
                        script{
                            try {
                                sh 'exit 1'
                            }
                            catch (exc){
                                echo 'somthing failed'

                            }
                        }
                    }
                }
            }
        }
    }
}
