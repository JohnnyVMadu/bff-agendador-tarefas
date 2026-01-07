package com.johnny.bffagendadortarefas.business.dto.in;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDTORequest {

    private String id;
    private String nomeTarefa;
    private String descricao;
    private String dataCriacao;    // convertido para String no BFF
    private String dataEvento;     // convertido para String no BFF
    private String emailUsuario;
    private String dataAlteracao;  // convertido para String
    private String statusNotificacaoEnum;
}
