package com.tayluan.propostaapp.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratágia de geração de PK é delegada ao banco de dados
    private Long id;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String telefone;

    private Double renda;

    @OneToOne(mappedBy = "usuario") // Passo como está definido a minha entidade no outro lado do relacionamento
    private Proposta proposta;

}
