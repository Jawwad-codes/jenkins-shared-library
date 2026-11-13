
def call() {
    sh """
        trivy fs \
            --timeout 15m \
            --db-repository ghcr.io/aquasecurity/trivy-db:2 \
            . \
            -o results.json
    """
}
