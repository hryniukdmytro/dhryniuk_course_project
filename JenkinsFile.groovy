pipeline {

    tools {
        maven 'Maven'
        jdk 'JDK_17'
    }
    agent any

    parameters {
        choice(name: 'testSuite',
                choices:
                        ['allTests',
                         'onlyAPITests',
                         'onlyUITests',
                         'projectTests',
                         'taskTests',
                         'userTests'],
                description:
                        'Select the test suite to execute'
        )
    }

    stages {
        stage('Build and Run Tests') {
            steps {
                script {
                    sh "mvn clean test -Dsuite=${params.testSuite}"
                }
            }
        }
    }
}
