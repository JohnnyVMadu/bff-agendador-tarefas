package com.johnny.bffagendadortarefas.controller;

import com.johnny.bffagendadortarefas.business.dto.in.TarefasDTORequest;
import com.johnny.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.johnny.bffagendadortarefas.business.service.TarefasService;
import com.johnny.bffagendadortarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.johnny.bffagendadortarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "Tarefas", description = "Gerenciamento de tarefas agendadas")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasDTOResponse> criarTarefa(
            @RequestHeader("Authorization") String token,
            @RequestBody TarefasDTORequest dto) {

        return ResponseEntity.ok(tarefasService.criarTarefa(token, dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDTOResponse>> buscarPorEmail(
            @RequestHeader("Authorization") String token) {

        return ResponseEntity.ok(tarefasService.buscarPorEmail(token));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDTOResponse>> buscarPorPeriodo(
            @RequestHeader("Authorization") String token,
            @RequestParam String dataInicial,
            @RequestParam String dataFinal) {

        return ResponseEntity.ok(tarefasService.buscarPorPeriodo(token, dataInicial, dataFinal));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(
            @RequestHeader("Authorization") String token,
            @RequestParam String id) {

        tarefasService.deletarTarefa(token, id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TarefasDTOResponse> atualizarStatus(
            @RequestHeader("Authorization") String token,
            @RequestParam String id,
            @RequestParam StatusNotificacaoEnum status) {

        return ResponseEntity.ok(tarefasService.atualizarStatus(token, id, status));
    }

    @PutMapping
    public ResponseEntity<TarefasDTOResponse> atualizar(
            @RequestHeader("Authorization") String token,
            @RequestParam String id,
            @RequestBody TarefasDTORequest dto) {

        return ResponseEntity.ok(tarefasService.atualizarTarefa(token, id, dto));
    }
}
