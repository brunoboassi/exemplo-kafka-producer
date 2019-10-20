package br.com.itau.exemplo;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Override
    public void send(String topico, String key,String mensagem) {
        ProducerRecord producerRecord = new ProducerRecord(topico,key,mensagem);
        System.out.println("Mensangem : " + mensagem + " | Chave : " + key);
        kafkaTemplate.send(producerRecord);
    }
}
