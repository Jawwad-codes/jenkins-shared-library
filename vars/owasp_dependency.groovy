def call() {
    dependencyCheck(
        odcInstallation: 'OWASP',
        additionalArguments: '--scan .'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}