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
                sh " ./gradlew/compileJava"
            }
        }
    }
}