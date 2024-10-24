package com.tayluan.propostaapp.mapper;

import com.tayluan.propostaapp.dto.PropostaRequestDto;
import com.tayluan.propostaapp.dto.PropostaResponseDto;
import com.tayluan.propostaapp.entity.Proposta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.NumberFormat;
import java.util.List;

@Mapper
public interface PropostaMapper {

    PropostaMapper INSTANCE = Mappers.getMapper(PropostaMapper.class);

    @Mapping(target = "usuario.nome",source = "nome")
    @Mapping(target = "usuario.sobrenome",source = "sobrenome")
    @Mapping(target = "usuario.cpf",source = "cpf")
    @Mapping(target = "usuario.telefone",source = "telefone")
    @Mapping(target = "usuario.renda",source = "renda")
    @Mapping(target = "id",ignore = true) // Irá ignorar um atributo
    @Mapping(target = "aprovada",ignore = true) // Irá ignorar um atributo
    @Mapping(target = "integrada",ignore = true) // Irá ignorar um atributo
    @Mapping(target = "observacao",ignore = true) // Irá ignorar um atributo
    Proposta convertDtoToProposta(PropostaRequestDto propostaRequestDto);

    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "sobrenome", source = "usuario.sobrenome")
    @Mapping(target = "telefone", source = "usuario.telefone")
    @Mapping(target = "cpf", source = "usuario.cpf")
    @Mapping(target = "renda", source = "usuario.renda")
    @Mapping(target = "valorSolicitadoFmt" , expression = "java(setValorSolicitadoFmt(proposta))")
    PropostaResponseDto convertEntityToDto(Proposta proposta);

    List<PropostaResponseDto> convertListEntityToListDto(Iterable<Proposta> propostas);

    default String setValorSolicitadoFmt(Proposta proposta) {
        return NumberFormat.getCurrencyInstance().format(proposta.getValorSolicitado());
    }
}
