try {
  node() {

    stage('Build & U.Test') { 
		git url: 'https://github.com/manuelMachuca/microserviceti'
    withMaven {
      sh "mvn clean verify"
    } // withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBugs r
	
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
