# producer-consumer-message-count
1. Build project with gradle
2. Run DeviceMonitorApplication


Example Output:
````
2022-05-17 12:42:54.920  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : DiskPayload{temperature=0.9354546676196763, spaceTotal=0.9102625408146996, spaceFree=0.3913017516567041}
2022-05-17 12:42:54.920  INFO 7552 --- [           main] c.e.d.d.h.PowerSourceMessageHandler      : PowerSourcePayload{temperature=0.40466887084202297, powerLevel=0.1593760117678914}
2022-05-17 12:42:54.920  INFO 7552 --- [           main] c.e.d.d.h.PowerSourceMessageHandler      : PowerSourcePayload{temperature=0.8136318223399178, powerLevel=0.8404958603396885}
2022-05-17 12:42:54.921  INFO 7552 --- [           main] c.e.d.d.h.PowerSourceMessageHandler      : PowerSourcePayload{temperature=0.39776383338093924, powerLevel=0.24836876491173066}
2022-05-17 12:42:54.921  INFO 7552 --- [           main] c.e.d.d.h.PowerSourceMessageHandler      : PowerSourcePayload{temperature=0.6857652797999124, powerLevel=0.7055036471985557}
2022-05-17 12:42:54.926  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.378878476131705, powerLevel=0.8684026939305352, connectedClients=78}
2022-05-17 12:42:54.926  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.19219624412001168, powerLevel=0.22997195966253137, connectedClients=37}
2022-05-17 12:42:54.926  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.5673971086669831, powerLevel=0.18339759548244472, connectedClients=76}
2022-05-17 12:42:54.926  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.2982929185944915, powerLevel=0.1711430835879202, connectedClients=40}
2022-05-17 12:42:54.926  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.2993235526012299, powerLevel=0.33056974391706184, connectedClients=25}
2022-05-17 12:42:54.927  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.02603150998950643, powerLevel=0.0020097796992640804, connectedClients=28}
2022-05-17 12:42:54.927  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.36577885627097984, powerLevel=0.5111441052182223, connectedClients=35}
2022-05-17 12:42:54.927  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.293465143356313, powerLevel=0.1339001594045367, connectedClients=22}
2022-05-17 12:42:54.927  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.3475387652272407, powerLevel=0.042584872749257596, connectedClients=70}
2022-05-17 12:42:54.927  INFO 7552 --- [           main] c.e.d.domain.handler.DiskMessageHandler  : GatewayPayload{temperature=0.5162272797816927, powerLevel=0.5285337503332631, connectedClients=54}
2022-05-17 12:42:57.937  INFO 7552 --- [           main] c.e.demo.domain.handler.MetricsHandler   : Total messages: 60
2022-05-17 12:42:57.938  INFO 7552 --- [           main] c.e.demo.domain.handler.MetricsHandler   : {P1=25, G1=10, D1=10, D2=15}
````