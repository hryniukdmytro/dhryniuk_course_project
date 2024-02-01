pipeline {
    tools {
        maven 'Maven'
        jdk 'JDK_17'
    }
    agent any

    parameters {
        choice(name: 'testSuite',
                choices: ['allTests', 'onlyAPITests', 'onlyUITests', 'projectTests', 'taskTests', 'userTests'],
                description: 'Select the test suite to execute'
        )
    }

    stages {
        stage('Build and Run Tests') {
            steps {
                script {
                    def testSuiteParameters = [
                            'All Tests': '-Dsuite=allTests',
                            'All API Tests': '-Dsuite=onlyAPITests',
                            'All UI Tests': '-Dsuite=onlyUITests',
                            '[API & UI] Project Tests': '-Dsuite=projectTests',
                            '[API & UI] Task Tests': '-Dsuite=taskTests',
                            '[API & UI] User Tests': '-Dsuite=userTests'
                    ]

                    sh "mvn clean test ${testSuiteParameters[params.testSuite]}"
                }
            }
        }
    }
}
