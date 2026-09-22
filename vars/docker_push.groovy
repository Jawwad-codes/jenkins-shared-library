def call(Map config = [:]) {
    def imageName = config.imageName ?: error("Image name is required")
    def imageTag = config.imageTag ?: 'latest'
    def dockerhubUsername = config.dockerhubUsername ?: error("dockerhubUsername is required")
    def credentials = config.credentials ?: 'docker-hub-credentials'

    def fullImageName = "${dockerhubUsername}/${imageName}"

    echo "Pushing Docker image: ${fullImageName}:${imageTag}"

    withCredentials([usernamePassword(
        credentialsId: credentials,
        usernameVariable: 'DOCKER_USERNAME',
        passwordVariable: 'DOCKER_PASSWORD'
    )]) {
        try {
            sh """
                echo "\$DOCKER_PASSWORD" | docker login -u "\$DOCKER_USERNAME" --password-stdin
                docker push ${fullImageName}:${imageTag}
            """
            if (imageTag != 'latest') {
                sh """
                    docker tag ${fullImageName}:${imageTag} ${fullImageName}:latest
                    docker push ${fullImageName}:latest
                """
            }
        } finally {
            sh 'docker logout'
        }
    }
}