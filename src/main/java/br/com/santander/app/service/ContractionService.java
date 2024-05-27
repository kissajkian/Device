package br.com.santander.app.service;


import br.com.santander.domain.usecase.SendContractionUserCase;
import br.com.santander.app.dto.DeviceContracted;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ContractionService implements SendContractionUserCase {

    private static final Logger logger = LoggerFactory.getLogger(ContractionService.class);

    private final String topic;
    private final KafkaTemplate<String, DeviceContracted> kafkaTemplate;

    public ContractionService(@Value("${topic.consumer-contractions-events}") String topic, KafkaTemplate<String, DeviceContracted> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void execute(DeviceContracted device) {
        logger.info("Enviando para o Topic Kafka.");
        kafkaTemplate.send(topic, device);
    }

}