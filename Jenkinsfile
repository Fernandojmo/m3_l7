pipeline {
    agent any
    stages {
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
            steps {
                // nexusArtifactUploader artifacts: [[artifactId: 'myapp', classifier: '', file: 'target/my-app-1.0-SNAPSHOT.jar', type: 'jar']], credentialsId: 'UserNexus', groupId: 'M3L6clc', nexusUrl: 'nexus.sisge.cl/repository/M3L6Ejercicio/', nexusVersion: 'nexus2', protocol: 'http', repository: 'M3L6Ejercicio', version: '1.0.${BUILD_NUMBER}'
                nexusArtifactUploader artifacts: [[artifactId: 'App', classifier: '', file: 'src/main/java/com/mycompany/app/App.java', type: 'java']], credentialsId: 'AdminNexus', groupId: 'MyWebApp', nexusUrl: 'localhost:8081/repository/Ropositorio-prueba-m3-l5/', nexusVersion: 'nexus2', protocol: 'http', repository: 'Ropositorio-prueba-m3-l5', version: '1.0.${BUILD_NUMBER}'
            }
            // post {
            //     always {
            //         // slackSend channel: '#grupo-2', color: 'purple', message: 'Test Generated, version: '1.0.${BUILD_NUMBER}''
            //         echo 'send slack message'                }
            // }
        }
        stage('Slack Message') {
            steps {
                slackSend channel: '#grupo-2', message: 'Test Generated, version: '1.0.${BUILD_NUMBER}''
                echo 'send slack message' 
                } 
        }
    }
}
