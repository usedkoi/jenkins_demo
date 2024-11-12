pipeline{
    agent any
    environment{
       DOCKERHUB_CREDENTIALS = credentials("us_dkr_blooming12")
    }
    stages{
        stage('Permission'){
            steps{
                sh "chmod +x ./gradlew"
            }
        }

        stage('Compile'){
            steps{
                sh " ./gradlew compileJava"
            }
        }

        stage("Unit Test"){
           steps{
               sh "./gradlew test"
           }
        }

        stage("Code Coverage"){
           steps{
               sh "./gradlew jacocoTestCoverageVerification "
               sh "./gradlew jacocoTestReport"
                   publishHTML(target: [
                       reportDir: 'build/reports/jacoco/test/html',
                       reportFiles: 'index.html',
                       reportName: 'Jacoco Report'
                   ])
           }
        }

        stage("Static Code Analysis"){
           steps{
               sh "./gradlew checkstyleMain"
                   publishHTML(target: [
                       reportDir: 'build/reports/checkstyle',
                       reportFiles: 'main.html',
                       reportName: 'Checkstyle Report'
                   ])
           }
        }

        stage("Gradle Build"){
           steps{
               sh "./gradlew clean build"
           }
        }

        stage("Docker Build"){
           steps{
               sh "docker build -t ${DOCKERHUB_CREDENTIALS_USR}/jenkins_demo:${BUILD_ID} ."
           }
        }

        stage('docker hub login'){
          steps{
              sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
          }
        }

        stage('docker hub push'){
          steps{
              sh "docker push ${DOCKERHUB_CREDENTIALS_USR}/jenkins_demo:${BUILD_ID}"
          }
        }

        stage('deployment'){
           steps{
               sh "docker run -d --rm -p 8081:8080 --name jenkins_demo ${DOCKERHUB_CREDENTIALS_USR}/jenkins_demo"
           }
        }

        stage('acceptance test'){
          steps{
              sleep 60
              sh 'chmod +x acceptance_test.sh && ./acceptance_test.sh'
          }
        }
    }
}