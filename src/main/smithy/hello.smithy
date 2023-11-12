$version: "2.0"

metadata smithy4sErrorsAsScala3Unions = true
metadata smithy4sDefaultRenderMode = "NONE"
namespace tech.igorramazanov.playground

use alloy.proto#grpc

@grpc
service HealthService {
    version: "1.0.0"
    operations: [HealthCheck]
}

@readonly
operation HealthCheck {
    input := {}
    output := {}
}
