package com.johnny.bffagendadortarefas.infrastructure.client;

import com.johnny.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.johnny.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.johnny.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.johnny.bffagendadortarefas.business.dto.in.LoginRequestDTO;

import com.johnny.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.johnny.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.johnny.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario-service", url = "http://localhost:8080/usuario")
public interface UsuarioClient {

    // ============================================================
    // LOGIN
    // ============================================================
    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO dto);

    // ============================================================
    // CRIAR USUÁRIO
    // ============================================================
    @PostMapping
    UsuarioDTOResponse salvarUsuario(@RequestBody UsuarioDTORequest dto);

    // ============================================================
    // GET ?email=
    // ============================================================
    @GetMapping
    UsuarioDTOResponse buscarPorEmailQuery(@RequestParam("email") String email);

    // ============================================================
    // GET /me
    // ============================================================
    @GetMapping("/me")
    UsuarioDTOResponse buscarProprio(@RequestHeader("Authorization") String token);

    // ============================================================
    // PUT atualizar nome/email
    // ============================================================
    @PutMapping
    UsuarioDTOResponse atualizarDados(
            @RequestHeader("Authorization") String token,
            @RequestBody UsuarioDTORequest dto
    );

    // ============================================================
    // PATCH senha
    // ============================================================
    @PatchMapping("/senha")
    void atualizarSenha(
            @RequestHeader("Authorization") String token,
            @RequestBody UsuarioDTORequest dto
    );

    // ============================================================
    // DELETE conta
    // ============================================================
    @DeleteMapping
    void deletarConta(@RequestHeader("Authorization") String token);

    // ============================================================
    // ENDEREÇO
    // ============================================================
    @PutMapping("/endereco")
    EnderecoDTOResponse atualizarEndereco(
            @RequestParam("id") Long id,
            @RequestBody EnderecoDTORequest dto
    );

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastrarEndereco(
            @RequestHeader("Authorization") String token,
            @RequestBody EnderecoDTORequest dto
    );

    // ============================================================
    // TELEFONE
    // ============================================================
    @PutMapping("/telefone")
    TelefoneDTOResponse atualizarTelefone(
            @RequestParam("id") Long id,
            @RequestBody TelefoneDTORequest dto
    );

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastrarTelefone(
            @RequestHeader("Authorization") String token,
            @RequestBody TelefoneDTORequest dto
    );
}
