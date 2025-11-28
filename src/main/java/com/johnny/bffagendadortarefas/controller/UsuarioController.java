package com.johnny.bffagendadortarefas.controller;

import com.johnny.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.johnny.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.johnny.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.johnny.bffagendadortarefas.business.dto.in.UsuarioDTORequest;

import com.johnny.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.johnny.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.johnny.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;

import com.johnny.bffagendadortarefas.business.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Tag(name = "Usuário", description = "Cadastro e login de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // =======================================================
    // LOGIN
    // =======================================================
    @PostMapping("/login")
    @Operation(summary = "Login Usuário")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(usuarioService.login(dto));
    }

    // =======================================================
    // CRIAR USUÁRIO
    // =======================================================
    @PostMapping
    @Operation(summary = "Criar Usuário")
    public ResponseEntity<UsuarioDTOResponse> salvarUsuario(@RequestBody UsuarioDTORequest dto) {
        return ResponseEntity.ok(usuarioService.salvar(dto));
    }

    // =======================================================
    // ENDEREÇO
    // =======================================================
    @PostMapping("/endereco")
    public ResponseEntity<EnderecoDTOResponse> cadastrarEndereco(
            @RequestHeader("Authorization") String token,
            @RequestBody EnderecoDTORequest dto
    ) {
        return ResponseEntity.ok(usuarioService.cadastrarEndereco(token, dto));
    }

    @PutMapping("/endereco")
    public ResponseEntity<EnderecoDTOResponse> atualizarEndereco(
            @RequestParam Long id,
            @RequestBody EnderecoDTORequest dto
    ) {
        return ResponseEntity.ok(usuarioService.atualizarEndereco(id, dto));
    }

    // =======================================================
    // TELEFONE
    // =======================================================
    @PostMapping("/telefone")
    public ResponseEntity<TelefoneDTOResponse> cadastrarTelefone(
            @RequestHeader("Authorization") String token,
            @RequestBody TelefoneDTORequest dto
    ) {
        return ResponseEntity.ok(usuarioService.cadastrarTelefone(token, dto));
    }

    @PutMapping("/telefone")
    public ResponseEntity<TelefoneDTOResponse> atualizarTelefone(
            @RequestParam Long id,
            @RequestBody TelefoneDTORequest dto
    ) {
        return ResponseEntity.ok(usuarioService.atualizarTelefone(id, dto));
    }

    // =======================================================
    // BUSCAR
    // =======================================================
    @GetMapping
    public ResponseEntity<UsuarioDTOResponse> buscarPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarPorEmail(email));
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioDTOResponse> buscarProprio(
            @RequestHeader("Authorization") String token
    ) {
        return ResponseEntity.ok(usuarioService.buscarProprio(token));
    }

    // =======================================================
    // ATUALIZAR DADOS
    // =======================================================
    @PutMapping
    public ResponseEntity<UsuarioDTOResponse> atualizarDados(
            @RequestHeader("Authorization") String token,
            @RequestBody UsuarioDTORequest dto
    ) {
        return ResponseEntity.ok(usuarioService.atualizar(token, dto));
    }

    @PatchMapping("/senha")
    public ResponseEntity<Void> atualizarSenha(
            @RequestHeader("Authorization") String token,
            @RequestBody UsuarioDTORequest dto
    ) {
        usuarioService.atualizarSenha(token, dto.getSenha());
        return ResponseEntity.ok().build();
    }

    // =======================================================
    // DELETE
    // =======================================================
    @DeleteMapping
    public ResponseEntity<Void> deletarConta(
            @RequestHeader("Authorization") String token
    ) {
        usuarioService.deletarConta(token);
        return ResponseEntity.noContent().build();
    }
}
