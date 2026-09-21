def call(){
    withCredentials([string(credentialsId: 'NVD-KEY', variable: 'NVD_API_KEY')]) {
        dependencyCheck additionalArguments: '--scan ./ --format XML --nvdApiKey ${NVD_API_KEY}', odcInstallation: 'OWASP'
    }
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}