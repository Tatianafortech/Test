pipelineJob("Repo QA job"){
  parameters {
    stringParam('test', '', 'DEPLOYMENT to QA')
  }
  properties {
    githubProjectUrl("https://github.com/Tatianafortech/Test")
  }
  definition {
    cps {
      sandbox(true)
      script('''
def NEW_IMAGE

pipeline {
  agent any
  stages {
    stage('Run tests') {
      steps {
        sh """echo test """
      }
    }
  }
  post {
    always {
      cleanWs()
    }
  }
}
      '''.stripIndent())
     }
   }
}
