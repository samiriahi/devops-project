pipeline {
    agent any

    tools {
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }
     stages {
        stage('Getting project from Github') {
            steps {
                git branch : 'fournisseur' ,
                    url : 'https://github.com/Muhammed-Alaa-Kanzari/achat-back';
            }
        }
         stage('Cleaning the project') {
            steps{
                sh 'mvn clean'
            }

        }
        stage ('Integration testing'){	
		  	steps{
		  		  sh 'mvn verify -DskipUnitTests'
		  	 }
		  }
        stage ('Maven Build'){	
		  	steps{
		  		  sh 'mvn clean install '
		  	 }
		  }	
    }
    
     
}