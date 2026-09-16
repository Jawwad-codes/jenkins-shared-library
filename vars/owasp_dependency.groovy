def call() {
    dependencyCheck(
        odcInstallation: 'DP-Check',
        additionalArguments: '--scan .'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}