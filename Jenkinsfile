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
                nexusArtifactUploader artifacts: [[artifactId: 'myapp', classifier: '', file: 'target/my-app-1.0-SNAPSHOT.jar', type: 'jar']], credentialsId: 'UserNexus', groupId: 'M3L6clc', nexusUrl: 'nexus.sisge.cl/repository/M3L6Ejercicio/', nexusVersion: 'nexus2', protocol: 'http', repository: 'M3L6Ejercicio', version: '1.0.${BUILD_NUMBER}'
            }
            post {
                always {
                    slackSend channel: '#notificajenkins', color: 'purple', message: 'Mensaje MOD3 LEC7 Slack'
                }
            }
        }
    }
}
