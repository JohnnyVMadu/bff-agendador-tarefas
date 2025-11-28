package com.johnny.bffagendadortarefas.infrastructure.client;

import com.johnny.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.johnny.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.johnny.bffagendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "agendador-tarefas",
        url = "http://localhost:8081"
)
public interface TarefasClient {

    @PostMapping("/tarefas")
    TarefasDTOResponse criarTarefa(
            @RequestHeader("Authorization") String token,
            @RequestBody TarefasDTORequest dto
    );

    @GetMapping("/tarefas")
    List<TarefasDTOResponse> buscarTarefasPorEmail(
            @RequestHeader("Authorization") String token
    );

    @GetMapping("/tarefas/eventos")
    List<TarefasDTOResponse> buscarTarefasPorPeriodo(
            @RequestHeader("Authorization") String token,
            @RequestParam String dataInicial,
            @RequestParam String dataFinal
    );

    @DeleteMapping("/tarefas")
    void deletarTarefa(
            @RequestHeader("Authorization") String token,
            @RequestParam String id
    );

    @PatchMapping("/tarefas")
    TarefasDTOResponse atualizarStatus(
            @RequestHeader("Authorization") String token,
            @RequestParam String id,
            @RequestParam StatusNotificacaoEnum status
    );

    @PutMapping("/tarefas")
    TarefasDTOResponse atualizarTarefa(
            @RequestHeader("Authorization") String token,
            @RequestParam String id,
            @RequestBody TarefasDTORequest dto
    );
}
