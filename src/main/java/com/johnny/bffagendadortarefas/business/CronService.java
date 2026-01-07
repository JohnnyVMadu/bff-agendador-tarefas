package com.johnny.bffagendadortarefas.business;

import com.johnny.bffagendadortarefas.business.dto.in.EmailDTORequest;
import com.johnny.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.johnny.bffagendadortarefas.business.service.EmailService;
import com.johnny.bffagendadortarefas.business.service.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;

    // Executa a cada 5 minutos
    @Scheduled(cron = "0 */5 * * * *")
    public void buscarTarefasProximaHora() {

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime daquiUmaHora = agora.plusHours(1);

        // Seus clients recebem String, então convertemos:
        String dataInicio = agora.toString();
        String dataFim = daquiUmaHora.toString();

        // TODO: Substituir token fixo por um token real (se necessário)
        String token = "Bearer TOKEN_FIXO_SE_PRECISAR";

        // Busca tarefas para o período
        var tarefas = tarefasService.buscarPorPeriodo(token, dataInicio, dataFim);

        tarefas.forEach(tarefa -> enviarEmailDaTarefa(tarefa));
    }

    private void enviarEmailDaTarefa(TarefasDTOResponse tarefa) {

        EmailDTORequest dto = EmailDTORequest.builder()
                .id(tarefa.getId())
                .nomeTarefa(tarefa.getNomeTarefa())
                .descricao(tarefa.getDescricao())
                .dataCriacao(tarefa.getDataCriacao())
                .dataEvento(tarefa.getDataEvento())
                .emailUsuario(tarefa.getEmailUsuario())
                .dataAlteracao(tarefa.getDataAlteracao())
                .statusNotificacaoEnum("ENVIADO")
                .build();

        emailService.enviarEmail(dto);
    }
}
