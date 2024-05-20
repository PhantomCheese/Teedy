pipeline {
    agent any
    stages {

        stage('Package') {
            sh 'mvn -B -DskipTests clean package'
        }

        stage('Building image') {
            sh 'docker build -t teedy2024_manual .'
        }
        
        stage('Upload image') {
            sh 'sudo docker tag teedy2024_manual phantomcheese976/myteedy:v1.0'
            sh 'sudo docker push phantomcheese976/myteedy:v1.0'
        }

        stage('Run containers') {
            sh 'docker run -d -p 8084:8080 --name teedy_manual01 teedy2024_manual'
            sh 'docker run -d -p 8082:8080 --name teedy_manual02 teedy2024_manual'
            sh 'docker run -d -p 8083:8080 --name teedy_manual03 teedy2024_manual'
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

    post {
        always {
            archiveArtifacts artifacts: '**/target/site/**', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
            archiveArtifacts artifacts: '**/target/surefire-reports/*.xml'
            archiveArtifacts artifacts: '**/target/site/apidocs/*'
            archiveArtifacts artifacts: '**/target/site/pmd.html'
        }
    }
}