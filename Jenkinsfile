pipeline {
    agent any
    stages {

        
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }

        stage('K8s') {
            steps {
                sh 'kubectl set image deployments/hello-node docs=sismics/docs:latest'
            }
        }
        
        // stage('Build') { 
        //     steps {
        //         sh 'mvn -B -DskipTests clean package'
        //         sh 'mvn surefire-report:report' 
        //         sh 'mvn javadoc:javadoc --fail-never'
        //     }
        // }

        // stage('Doc') {
        //     steps {
        //         sh 'mvn javadoc:javadoc --fail-never'
        //         sh 'mvn javadoc:jar'
        //     }
        // }

        // stage('pmd') {
        //     steps {
        //         sh 'mvn pmd:pmd'
        //     }
        // }

        // stage('Test') {
        //     steps {
        //         sh 'mvn test'
        //     }
        // }
    }

    // post {
    //     always {
    //         archiveArtifacts artifacts: '**/target/site/**', fingerprint: true
    //         archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
    //         archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
    //         archiveArtifacts artifacts: '**/target/surefire-reports/*.xml'
    //         archiveArtifacts artifacts: '**/target/site/apidocs/*'
    //         archiveArtifacts artifacts: '**/target/site/pmd.html'
    //     }
    // }
}