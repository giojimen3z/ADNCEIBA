pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'Slave_Induccion'
    }

    //Opciones específicas de Pipeline dentro del Pipeline
    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }

    //Una sección que define las herramientas “preinstaladas” en Jenkins
    tools {
        jdk 'JDK8_Centos' //Preinstalada en la Configuración del Master
        gradle 'Gradle5.6_Centos' //Preinstalada en la Configuración del Master
    }

    //Aquí comienzan los “items” del Pipeline
    stages{
        stage('Checkout') {
            steps{
                echo "------------>Checkout<------------"
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    gitTool: 'Git_Centos',
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        credentialsId: 'GitHub_Giovanny.Jimenez',
                        url:'https://github.com/giojimen3z/ADNCEIBA.git'
                    ]]
                ])        
            }
        }

        stage('Tests') {
            steps {
                echo "------------>Unit Tests<------------"
                dir("backend"){
                    sh 'gradle --b ./build.gradle clean test jacocoTestReport'
                }
            }
        }  

        stage('Static Code Analysis') {       
            steps{
                echo '------------>Análisis de código estático<------------'         
                withSonarQubeEnv('Sonar') {
                    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
                }
            }
        }

        stage('Build') {
        steps {
                dir("backend"){
                    sh 'gradle build -x test'
                }
            }
        }
    
        
    }

    post {
        failure {
            echo 'This will run only if failed'
            mail (to: 'jaime.jimenez@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
                body: "Something is wrong with ${env.BUILD_URL}")
        }
    }
}