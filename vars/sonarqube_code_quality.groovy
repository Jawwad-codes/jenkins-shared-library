def call(){
  timeout(time: 16, unit: "MINUTES"){
      waitForQualityGate abortPipeline: false
  }
}