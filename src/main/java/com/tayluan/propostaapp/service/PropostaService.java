package com.tayluan.propostaapp.service;

import com.tayluan.propostaapp.dto.PropostaRequestDto;
import com.tayluan.propostaapp.dto.PropostaResponseDto;
import com.tayluan.propostaapp.entity.Proposta;
import com.tayluan.propostaapp.mapper.PropostaMapper;
import com.tayluan.propostaapp.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private NotificationService notificationService;

    public PropostaResponseDto criar (PropostaRequestDto requestDto) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(requestDto);// Converte de DTO para entidade para salvar no banco
        propostaRepository.save(proposta);

        PropostaResponseDto responseDto = PropostaMapper.INSTANCE.convertEntityToDto(proposta);// Converto de entidade para DTO para retornar a resposta
        notificationService.notificar(responseDto,"proposta-pendente.ex");

        return responseDto;
    }

    public List<PropostaResponseDto> obterPropostas() {
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostaRepository.findAll());
    }
}
