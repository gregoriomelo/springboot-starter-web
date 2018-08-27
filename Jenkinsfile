pipeline {
  agent any
  stages {
    stage('Prepare') {
      steps {
        sh './gradlew clean'
        sh './gradlew compileJava'
      }
    }
    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            sh './gradlew test'
          }
        }
        stage('Static Analsysis') {
          steps {
            sh './gradlew sonarqube'
          }
        }
      }
    }
    stage('Functional Tests') {
      steps {
        sh './gradlew functionalTest'
      }
    }
    stage('Build') {
      steps {
        sh './gradlew bootJar'
        sh 'docker build -t gregoriomelo/springboot-starter-web-demo/:`git rev-parse --abbrev-ref HEAD`-`git rev-parse --short HEAD`'
      }
    }
  }
}