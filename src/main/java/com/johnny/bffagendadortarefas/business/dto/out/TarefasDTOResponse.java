package com.johnny.bffagendadortarefas.business.dto.out;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarefasDTOResponse {

    private String id;
    private String nomeTarefa;
    private String descricao;

    private String dataCriacao;   // formatado como String no BFF
    private String dataEvento;
    private String dataAlteracao;

    private String emailUsuario;
    private String statusNotificacaoEnum;
}

