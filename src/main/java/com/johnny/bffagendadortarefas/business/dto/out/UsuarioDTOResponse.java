package com.johnny.bffagendadortarefas.business.dto.out;

import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTOResponse {
    private Long id;
    private String nome;
    private String email;

    private EnderecoDTOResponse endereco;
    private List<TelefoneDTOResponse> telefones;
}
