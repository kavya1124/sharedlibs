def call(ip,sshagent,warname){
  sshagent(["${sshagent}"]) {
    sh "scp -o StrictHostKeyChecking=no "target/${warname}*.war" ec2-user@"${ip}":/opt/tomcat9/webapps/"
    sh "ssh ec2-user@"${ip}" /opt/tomcat9/bin/shutdown.sh"
    sh "ssh ec2-user@"${ip}" /opt/tomcat9/bin/startup.sh"
  }
 }            
