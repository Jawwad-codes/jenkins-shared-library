def call (Map config = [:]) {
    def imageName = config.imageName ?: error("imageName is required")
    def imageTag = config.imageTag ?: error("imageTag is required")
    def dockerhubUsername = config.dockerhubUsername ?: error("dockerhubUsername is required")
    def dockerfile = config.dockerfile?: 'Dockerfile'
    def contextDir = config.contextDir?: '.'
    echo "Building docker image:${dockerhubUsername}/${imageName}:${imageTag} using Dockerfile: ${dockerfile} in context: ${contextDir}"
    sh "docker build -t ${dockerhubUsername}/${imageName}:${imageTag} -f ${dockerfile} ${contextDir}"
}