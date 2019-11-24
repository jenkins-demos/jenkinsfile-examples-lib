 def call(body) {
  def pipelineParams= [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = pipelineParams
  body()

  pipeline {
    agent none
    stages {
      stage('Build and Test Java') {
        parallel {
          stage('java8') {
            agent { label 'java8' }
            stages {
              stage("build8") {
                steps {
                  echo "run build 8"
                }
                post {
                  success {
                    echo "ran build 8"
                  }
                }
              }
              stage('Backend Java 8') {
                steps {
                   echo "run backend java 8"
                }
                post {
                  always {
                     echo "junit run build java 8"
                  }
                }
              }
              stage('Frontend') {
                steps {
                   echo "run frontend"
                }
                post {
                  always {
                   echo "ran frontend"
                  }
                }
              }
              stage('Performance Java 8') {
                steps {
                   echo "run perf java 8"
                }
              }
              stage('Static Java 8') {
                steps {
                  echo "run static java 8"
                }
              }
            }
          }
          stage('java7') {
            agent { label 'java7' }
            stages {
              stage("build7") {
                steps {
                   echo "run java 7"
                }
                post {
                  success {
                     echo "run java 7"
                  }
                }
              }
              stage('Backend Java 7') {
                steps {
                  echo "run backend java 7"
                }
                post {
                  always {
                   echo "ran backend java 7"
                  }
                }
              }
              stage('Frontend Java 7') {
                steps {
                  echo "run frontend java 7"
                }
                post {
                  always {
                    echo "ran frontend java 7"
                  }
                }
              }
              stage('Performance Java 7') {
                steps {
                  echo "run perf java 7"
                }
              }
              stage('Static Java 7') {
                steps {
                  echo "ran perf java 7"
                }
              }
            }
          }
        }
      }
      stage('Confirm Deploy') {
        when { branch 'master' }
        steps {
          timeout(time: 3, unit: 'MINUTES') {
            input(message: 'Okay to Deploy to Staging?', ok: 'Let\'s Do it!')
          }
        }
      }
      stage('Fluffy Deploy') {
        agent { label 'java7' }
        when { branch 'master' }
        steps {
          echo "run deploy to staging java 7"
        }
      }
    }
    options {
      durabilityHint('MAX_SURVIVABILITY')
    }
  }
}
