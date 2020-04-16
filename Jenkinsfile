pipeline
 
{
	// add build no use $BUILD_NUMBER
	//to use replace latest by $BUILD_NUMBER

    environment 
 
    {
 
        registry = 'rohitkktr/tomcat2'
 
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
 
                    dockerImage = docker.build registry + ":latest"
 
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
 
                       bat "docker push rohitkktr/tomcat2:latest"
 
                      
 
                    }
 
                }
 
            }
 
        }
   stage('run') 
 
        {
 
            steps
 
            {
 
                bat "docker run -d --rm -p 8899:8080 --name test $registry:latest"
 
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
 
                bat "docker rmi rohitkktr/tomcat2:latest"
 
            }
 
        }
 
        
 
        
 
        
 
    
 
    }
 
}
