package com.johnny.bffagendadortarefas.business.service;

import com.johnny.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.johnny.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.johnny.bffagendadortarefas.infrastructure.client.TarefasClient;
import com.johnny.bffagendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;

    public TarefasDTOResponse criarTarefa(String token, TarefasDTORequest dto) {
        return tarefasClient.criarTarefa(token, dto);
    }

    public List<TarefasDTOResponse> buscarPorEmail(String token) {
        return tarefasClient.buscarTarefasPorEmail(token);
    }

    public List<TarefasDTOResponse> buscarPorPeriodo(String token, String dataInicio, String dataFim) {
        return tarefasClient.buscarTarefasPorPeriodo(token, dataInicio, dataFim);
    }

    public void deletarTarefa(String token, String id) {
        tarefasClient.deletarTarefa(token, id);
    }

    public TarefasDTOResponse atualizarStatus(String token, String id, StatusNotificacaoEnum status) {
        return tarefasClient.atualizarStatus(token, id, status);
    }

    public TarefasDTOResponse atualizarTarefa(String token, String id, TarefasDTORequest dto) {
        return tarefasClient.atualizarTarefa(token, id, dto);
    }
}
