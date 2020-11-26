@Library('jenkins-sharedlib@master')
import sharedlib.JenkinsfileUtil

def utils = new JenkinsfileUtil(steps, this)

try {
  node() {

    stage('Build & U.Test') { 
		utils.buildMaven("-U", true) 
	
	  }
    stage('QA Analisys') { 
	  }
    
    stage('Post Execution') {
      }
    }
  } catch (Exception e) {
  node {
    throw e
  }
}