pipeline {
    tools {
        maven 'Maven'
        jdk 'JDK_17'
    }
    agent any

    parameters {
        choice(
                name: 'Test Suite',
                choices: [
                        'All Tests',
                        'All API Tests',
                        'All UI Tests',
                        '[API & UI] Project Tests',
                        '[API & UI] Task Tests',
                        '[API & UI] User Tests'
                ],
                description: 'Select the test suite to execute'
        )
        string(
                name: 'Base URL',
                defaultValue: 'http://127.0.0.1',
                description: 'Enter the base URL (leave untouched if running on the local version)'
        )
        string(
                name: 'API URL',
                defaultValue: 'http://127.0.0.1/jsonrpc.php',
                description: 'Enter the API URL (leave untouched if running on the local version)'
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

                    sh "mvn clean test ${testSuiteParameters[params.testSuite]} -DbaseURL=${params.baseURL} -DapiURL=${params.apiURL}"
                }
            }
        }
    }
}
