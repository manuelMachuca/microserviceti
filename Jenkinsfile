pipeline {

   agent any

   stages {

      stage('Build') {
         withMaven {
               sh "mvn clean verify"
         }
      }

   }

}
