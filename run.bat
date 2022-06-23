SET kafka_folder="C:\kafka_2.13-3.2.0\"
SET current=%~dp0
CD /D %kafka_folder%

START bin\windows\zookeeper-server-start.bat config/zookeeper.properties
timeout /t 10
START bin\windows\kafka-server-start.bat config/server.properties
timeout /t 20
START bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic FACTURATION
timeout /t 15
START bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic FACTURATION_TOTAL --property print.key=true --property print.value=true --property key.deserialzer=org.apache.kafka.common.serialization.StringDeserializer  --property value.deserializer=org.apache.kafka.common.serialization.LongDeserializer
START bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic FACTURATION_TOTAL_FOR_CLIENTS --property print.key=true --property print.value=true --property key.deserialzer=org.apache.kafka.common.serialization.StringDeserializer  --property value.deserializer=org.apache.kafka.common.serialization.DoubleDeserializer


CD /D %current%

CD /D front
:: START npm start

CD /D %current%
:: start all java micro-services
:: start react app

