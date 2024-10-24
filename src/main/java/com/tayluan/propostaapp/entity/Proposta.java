package com.tayluan.propostaapp.entity;

// Importar apenas as classes que estamos utilizando
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorSolicitado;

    private int prazoPagamento;// Definido como um inteiro,pois será em meses (Ex:12 meses)

    private Boolean aprovada;

    private boolean integrada;

    private String observacao;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_usuario") // Define o nome da FK e referencia qual usuário está ligado a proposta
    private Usuario usuario;


}
