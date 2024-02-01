pipeline {

    tools {
        maven 'Maven'
        jdk 'JDK_17'
    }

    agent any

    stages {
        stage('Build and Run Tests') {
            steps {
                script {
                    sh 'mvn clean test -Dsuite=onlyAPITests'
                }
            }
        }
    }
}
