pipeline {
    agent any
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }

            post {
                success {
                    // Archive Surefire reports
                    archiveArtifacts '**/target/surefire-reports/*.xml'
                    // Generate Javadoc
                    sh 'mvn javadoc:jar'
                    // Archive Javadoc as an artifact
                    archiveArtifacts '**/target/site/apidocs/*'
                }
            }
        }

        stage('pmd') {
            steps {
                sh 'mvn pmd:pmd'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
            post {
                always {
                    // Archive Surefire reports
                    archiveArtifacts '**/target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/site/**', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
        }
    }
}