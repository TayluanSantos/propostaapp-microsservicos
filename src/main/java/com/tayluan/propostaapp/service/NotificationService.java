package com.tayluan.propostaapp.service;

import com.tayluan.propostaapp.dto.PropostaResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class NotificationService {
    private RabbitTemplate rabbitTemplate;

    public void notificar(PropostaResponseDto propostaResponseDto,String exchange) {
        rabbitTemplate.convertAndSend(exchange,"",propostaResponseDto);
    }
}
