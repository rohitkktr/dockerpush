pipeline
{
	agent any
	stages
	{
		stage('compile stage')
		{
			steps
			{
				bat 'mvn clean compile'
			}
		}

		


		stage('testing stage')
		{
			steps
			{
				bat 'mvn test'
			}
		}
	
		stage('package stage')
		{
			steps
			{
				bat 'mvn package'
			}
		}
		
		stage ('Artifactory configuration') {
            steps {
                 rtMavenDeployer (
                    id: "MAVEN_DEPLOYER",
                    serverId: "Artifactory",
                    releaseRepo: "jenkins",
                    snapshotRepo: "jenkins"
                )
            }
        }

        stage ('Artifactory Exec Maven') {
            steps {
                 rtMavenRun (
                    tool: "Maven3", // Tool name from Jenkins configuration
                    pom: 'pom.xml',
                    goals: 'clean package',
                    deployerId: "MAVEN_DEPLOYER",
                )
            }
        }
        stage ('Publish build info') {
            steps {
               rtPublishBuildInfo (
                    serverId: "Artifactory"
                )
            }
        }
	stage ('docker') {
            steps {
              bat 'docker build -t rohitkktr/helloo .'    
		    bat 'docker run -d --rm -p 8880:8080 rohitkktr/helloo'
		    bat 'docker push rohitkktr/helloo'
            }
        }
		
		
		stage('Deploy'){
			steps{
        deploy adapters: [tomcat8(credentialsId: '88e5e28d-5e07-4250-8d07-9ac404b7e9b3', path: '', url: 'http://localhost:8813')], contextPath: null, onFailure: false, war: '**/*.war'
			}
		}	
	}
}
