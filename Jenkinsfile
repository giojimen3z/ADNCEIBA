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
          branches: [[name: '*/develop']],
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
    stage('Build') {
      steps {
        //Construir sin tarea test que se ejecutó previamente

            dir("Parking"){
                sh 'gradle build -x test'
        }
      }
    }

    stage('Tests') {
      steps {
        echo "------------>Unit Tests<------------"
          
        dir("Parking"){
        sh 'gradle test'
        }
              //sh 'gradle --b ./build.gradle test'
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

  
  }

  post {
    always {
      echo 'This will always run'
    }

    failure {
      echo 'This will run only if failed'
      mail (to: 'jaime.jimenez@ceiba.com.co', subject: "Failed Pipeline:${currentBuild.fullDisplayName}",
            body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }

  }
}
