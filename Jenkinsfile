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
    }
}