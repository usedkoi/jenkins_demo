pipeline{
    agent any
    stages{
        stage('Checkout'){
            steps{
                git url:"https://github.com/usedkoi/jenkins_demo.git", branch: "master"
                echo "checkout"
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
               sh "docker tag jenkins_demo blooming12/jenkins_demo "
               sh "docker push blooming12/jenkins_demo ."
           }
        }
    }
}