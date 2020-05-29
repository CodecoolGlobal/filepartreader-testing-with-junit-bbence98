pipeline {
    agent {
        docker {
            image 'ubuntu:18.04'
        }
    }
    
    stages {
        stage('Build') {
            steps {
                sh 'apk add maven'
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
