pipeline {
    tools {
        maven 'Maven'
        jdk 'JDK_17'
    }
    agent any

    parameters {
        choice(
                name: 'testSuite',
                choices: ['allTests', 'onlyAPITests', 'onlyUITests', 'projectTests', 'taskTests', 'userTests'],
                description: 'Select the test suite to execute'
        )

        string(
                name: 'baseURL',
                defaultValue: 'http://127.0.0.1',
                description: 'Enter the base URL (leave untouched if running on the local version)'
        )
    }

    stages {
        stage('Build and Run Tests') {
            steps {
                script {
                    def testSuiteParameters = [
                            'allTests': '-Dsuite=allTests',
                            'onlyAPITests': '-Dsuite=onlyAPITests',
                            'onlyUITests': '-Dsuite=onlyUITests',
                            'projectTests': '-Dsuite=projectTests',
                            'taskTests': '-Dsuite=taskTests',
                            'userTests': '-Dsuite=userTests'
                    ]

                    sh "mvn clean test ${testSuiteParameters[params.testSuite]} -DbaseURL=${params.baseURL}"
                }
            }
        }
    }
}
