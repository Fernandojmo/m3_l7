pipeline {
    agent any

    stages {
        // stage('Clonar Repositorio') {
        //     steps {
        //         git 'https://github.com/clabca/java-maven-app.git'
        //     }
        // }

        stage('Construir') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Pruebas') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Empaquetar') {
            steps {
                sh 'mvn package'
            }
        }
        stage('SonarQube analysis') {
             environment {
                SCANNER_HOME = tool 'SonarQube Conexion'
            }
            steps {
              withSonarQubeEnv(credentialsId: 'SecretTextContent', installationName: 'SonarQube') {
                sh '''$SCANNER_HOME/bin/sonar-scanner \
                    -Dsonar.projectKey=projectKey \
                    -Dsonar.projectName=projectName \
                    -Dsonar.sources=src/ \
                    -Dsonar.exclusions=src/test/java/***/*.java \
                    -Dsonar.projectVersion=${BUILD_NUMBER}-${GIT_COMMIT_SHORT}'''
             }
            }
        }

        stage('Desplegar') {
            when {
                expression {
                    return !["UNSTABLE", "FAILURE"].contains(currentBuild.getPreviousBuild()?.result?.toString())
                }
            }
            steps {
                // Agrega aquí los pasos para desplegar tu aplicación
                sh 'echo "Desplegando la aplicación..."'
            }
        }        
        stage('Enviar Nexus') {
            nexusArtifactUploader credentialsId: 'AdminNexus', groupId: 'MyWebApp', nexusUrl: 'localhost:8081/repository/Ropositorio-prueba-m3-l5/', nexusVersion: 'nexus2', protocol: 'http', repository: 'Ropositorio-prueba-m3-l5', version: '1.0'
            post {
                always {
                    // slackSend channel: '#notificajenkins', color: 'purple', message: 'Mensaje MOD3 LEC7 Slack'
                    echo 'send slack message'
                }
            }
        }
    }
}
