pipeline {

    agent any

    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t=kjosipovic/selenium ."
            }
        }
        stage('Push Image') {
            steps {
                bat "docker push kjosipovic/selenium"
            }
        }
    }
}