# explore-kafka (windows)
**Some important kafka commands**

**Start kafka server:** 

Step 1: C:\kafka> bin\windows\kafka-storage.bat random-uuid (gives random uuid)

Step 2: C:\kafka> bin\windows\kafka-storage.bat format -t <given-random-uuid> -c config/server.properties

Step 3: C:\kafka> bin\windows\kafka-server-start.bat config/server.properties

**Create a new topic:** bin\windows\kafka-topics.bat --create --topic test-events --bootstrap-server localhost:9092

**Describe existing topic:** bin\windows\kafka-topics.bat --describe --topic test-events --bootstrap-server localhost:9092

**List Topics:** bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

**Produce events:** bin\windows\kafka-console-producer.bat --topic test-events --bootstrap-server localhost:9092

**Consume Events:** bin\windows\kafka-console-consumer.bat --topic test-events --from-beginning --bootstrap-server localhost:9092
