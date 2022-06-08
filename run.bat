SET kafka_folder="c:\kafka_2.13-3.2.0\"
SET current=%~dp0
CD /D %kafka_folder%

START bin\windows\zookeeper-server-start.bat config/zookeeper.properties
timeout /t 30
START bin\windows\kafka-server-start.bat config/server.properties
timeout /t 30
START bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic FACTURATION


CD /D %current%
:: start all java micro-services
:: start react app

