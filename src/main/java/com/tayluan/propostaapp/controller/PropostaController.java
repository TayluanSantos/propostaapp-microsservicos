package com.tayluan.propostaapp.controller;

import com.tayluan.propostaapp.dto.PropostaRequestDto;
import com.tayluan.propostaapp.dto.PropostaResponseDto;
import com.tayluan.propostaapp.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController // Define um controller de uma aplicação do tipo REST
@RequestMapping("/proposta") // Mapeamento global de rotas
public class PropostaController {

    @Autowired // Faz a injeção de uma dependência
    private PropostaService propostaService;

    @PostMapping // Define o verbo HTTP sendo do tipo POST
    public ResponseEntity<PropostaResponseDto> criar(@RequestBody PropostaRequestDto requestDto){
        PropostaResponseDto response = propostaService.criar(requestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(response.getId())
                .toUri())
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> obterPropostas(){
        return ResponseEntity.ok(propostaService.obterPropostas());
    }
}
