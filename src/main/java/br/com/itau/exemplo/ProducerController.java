package br.com.itau.exemplo;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProducerController {
        @Value("${producer.topico}")
        String topico;

       private final ProducerService producerService;

       @PostMapping(path = "/producer/{quantidade}")
        public String producerSend(@PathVariable("quantidade") int quantidade)
       {
           String key;
           String mensagem;
           for (int i=0;i<=quantidade;i++)
           {
               key=String.valueOf(i);
               mensagem="Mensagem numero "+i;
               producerService.send(topico,key,mensagem);
           }
           return "Produção finalizada";
       }
}
