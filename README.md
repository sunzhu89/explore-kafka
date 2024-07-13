# explore-kafka

Some important kafka commands

Start zookeeper: bin\windows\zookeeper-server-start.bat config\zookeeper.properties
Start kafka server: \bin\windows\kafka-server-start.bat .\config\server.properties
Create a new topic: bin\windows\kafka-topics.bat --create --topic test-events --bootstrap-server localhost:9092
Describe existing topic: bin\windows\kafka-topics.bat --describe --topic test-events --bootstrap-server localhost:9092
List Topics: bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
Produce events: bin\windows\kafka-console-producer.bat --topic test-events --bootstrap-server localhost:9092
Consume Events: bin\windows\kafka-console-consumer.bat --topic test-events --from-beginning --bootstrap-server localhost:9092
