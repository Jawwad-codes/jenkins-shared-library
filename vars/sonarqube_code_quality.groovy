def call(){
  timeout(time: 4, unit: "MINUTES"){
      waitForQualityGate abortPipeline: false
  }
}