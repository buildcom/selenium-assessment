//Declarative Jenkinsfile Template: Delete these top lines before merging your Jenkinsfile with master
//Pipeline Syntax Resource: https://jenkins.io/doc/book/pipeline/syntax/
//nodejs used in declarative: https://github.com/buildcom/react-supply-store/blob/master/Jenkinsfile
//maven used in declarative: https://github.com/buildcom/customer-services/blob/master/Jenkinsfile
//Most projects on leroy.fergcs.com are now declarative, so those can be used as reference for your project
//Or you can ask your fellow SREs for assistance :)

pipeline {
  agent {
    label 'CentOS7'
  }
  tools {
    git 'Latest'
    //if your project is maven
    maven 'MavenAuto'
    //if your project is nodejs, change version accordingly
    nodejs 'NodeJS v10+'
  }
  options {
    disableConcurrentBuilds()
    parallelsAlwaysFailFast()
  }
  //Specify Global Environment Variables
  //If they need to be changed for all stages in a sub stage, you'll need to do so in a script block as per the Tests Completed stage below
  //All variables in the environment block are saved as strings, so you'll need to add .toBoolean() to get boolean values, see Wait for Tests stage
  environment {
    repositoryName = 'selenium-assessment'
    gitRepoUrl = "https://github.com/buildcom/${repositoryName}.git"
    testCompletedSuccessfully = false
    //mavenCommandOptions = "--fail-at-end --batch-mode --quiet --settings settings.xml -Dmaven.repo.local=.localMavenRepo"
    //mavenSettingsConfig = 'org.jenkinsci.plugins.configfiles.maven.MavenSettingsConfig1426267345601'
  }
  stages {
    //If you want to use parallel stages, use the below stage to get going, otherwise put the stages in sequential order in this stages block
    stage ('Parallel Stages') {
      parallel {
        stage ('Build and Test') {
          //Specifying the agent here makes sure that parallel stages run on different hosts
          agent {
            label 'CentOS7'
          }
          //Define variables that will be exclusive to the Build and Test parallel stages.
          //You can have the environment block in any stage, but only that stage and it's substages will have access to the new value
          environment {
            testEnvSpecificVar = 'somevar'
          }
          stages {
            //Build and Test Stages Here
            stage ('Tests Completed') {
              steps {
                script {
                  testCompletedSuccessfully = true
                }
              }
            }
          }
        }
        //Running in parallel with Build and Test
        stage ('Build and Deploy') {
          agent {
            label 'CentOS7'
          }
          environment {
            deployEnvSpecifiVar = 'someothervar'
          }
          when {
            branch 'master'
          }
          stages {
            //Build and Deploy Stages here
            stage ('Wait for Tests') {
              options {
                timeout(time: 20, unit: 'MINUTES')
              }
              steps {
                waitUntil {
                  script {
                    testCompletedSuccessfully.toBoolean()
                  }
                }
              }
            }
            stage ('Jira Label and Git Tag') {
              steps {
                setJiraLabels(repositoryName)
                gitTag gitRepoUrl, repositoryName
              }
            }
          }
        }
      }
    }
  }
  //post block will run after your build is completed, check the Pipeline Syntax Resource guide for all post block options
  post {
    cleanup {
      cleanWs()
    }
  }
}