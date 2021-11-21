def call(warname){
sshagent(['tomcat-dev']) {
    sh "scp -o StrictHostKeyChecking=no "target/${warname}*.war" ec2-user@172.31.34.136:/opt/tomcat9/webapps/"
    sh "ssh ec2-user@172.31.34.136 /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ec2-user@172.31.34.136 /opt/tomcat9/bin/startup.sh"
  }
 }            
