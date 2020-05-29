pipeline {
    agent {
        docker {
            image 'ubuntu:18.04'
        }
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'sudo apt-get install -y maven'
                sh 'mvn clean install'
                sh 'mvn versions:use-latest-releases'
            }
        }
        stage('Test') { 
            steps {
                sh 'mvn test' 
            }
        }
    }
}
