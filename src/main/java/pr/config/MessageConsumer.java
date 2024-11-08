package pr.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@EnableKafka
@Component
public class MessageConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @KafkaListener(topics = "Topic-A", groupId = "Group-A")
    public void listeningToTopicA(String message) {
        logger.info("Received Message from Topic-A in Group-A: " + message);
    }
}