pipeline {
  agent any
  stages {
    stage('Prepare') {
      steps {
        sh './gradlew clean'
        sh './gradlew compile'
      }
    }
    stage('Test') {
      parallel {
        stage('Test') {
          steps {
            sh './gradlew test'
            sh './gradle integrationTest'
          }
        }
        stage('Static Analsysis') {
          steps {
            sh './gradlew staticAnalysis'
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
        sh '''




docker build -t gregoriomelo/springboot-starter-web-demo/:`git rev-parse --abbrev-ref HEAD`-`git rev-parse --short HEAD`'''
      }
    }
  }
}