pipeline{
    agent any
    stages{
        stage('Set Variables'){
            steps{
                sh "echo SetVariables"
                script{
                    DOCKER_HUB_URL = 'registry.hub.docker.com'
                    DOCKER_HUB_FULL_URL = 'https://' + DOCKER_HUB_URL
                    DOCKER_HUB_CREDENTIAL_ID = 'dkr_blooming12'
                }
            }
        }

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
               sh "docker build -t jenkins_demo ."
           }
        }

        stage("Docker push"){
           steps{
               sh "echo "$DOCKER_HUB_CREDENTIAL_ID" | docker login -u <username> --password-stdin"
               sh "docker tag jenkins_demo blooming12/jenkins_demo "
               sh "docker push blooming12/jenkins_demo"
           }
        }
    }
}