package br.com.itau.exemplo;

public interface ProducerService {
    void send(String topico,String key, String mensagem);
}
