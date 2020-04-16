pipeline
 
{
 
    environment 
 
    {
 
        registry = 'rohitkkrt/tomcat2'
 
        registryCredential = 'dockerkey'
 
        dockerImage = ''
 
    }
 
    
 
    agent any
 
    
 
    stages
 
    {        
 
        
 
        stage('docker build') 
 
        {
 
            steps
 
            {
 
                script 
 
                {
 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
 
                }
 
            }
 
        }
 

 
        
 
        stage('docker push') 
 
        {
 
            steps
 
            {
 
                script 
 
                {
 
                    docker.withRegistry( '', registryCredential ) 
 
                    {
 
                        dockerImage.push()
 
                      
 
                    }
 
                }
 
            }
 
        }
   stage('run') 
 
        {
 
            steps
 
            {
 
                bat "docker run -d --rm -p 8899:8080 --name test $registry:$BUILD_NUMBER"
 
            }
 
        }
        
 
        stage('docker remove image') 
 
        {
		input
		{
			message "image remove" 
			ok "stop cantainer"
		}
		
 
            steps
 
            {
		    bat "docker stop test"
 
                bat "docker rmi $registry:$BUILD_NUMBER"
 
            }
 
        }
 
        
 
        
 
        
 
    
 
    }
 
}
