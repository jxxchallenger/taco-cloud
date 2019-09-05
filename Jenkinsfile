pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                bat 'mvn clean compile package -Dmaven.test.skip=true -Dmaven.compile.fork=true'
            }
        }
    }
}