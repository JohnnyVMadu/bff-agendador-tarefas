package com.johnny.bffagendadortarefas.business.service;

import com.johnny.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.johnny.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.johnny.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.johnny.bffagendadortarefas.business.dto.in.UsuarioDTORequest;

import com.johnny.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.johnny.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.johnny.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;

import com.johnny.bffagendadortarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient usuarioClient;

    // ============================================================
    // LOGIN
    // ============================================================
    public String login(LoginRequestDTO dto) {
        return usuarioClient.login(dto);
    }

    // ============================================================
    // CRIAR USUÁRIO
    // ============================================================
    public UsuarioDTOResponse salvar(UsuarioDTORequest dto) {
        return usuarioClient.salvarUsuario(dto);
    }

    // ============================================================
    // GET ?email=
    // ============================================================
    public UsuarioDTOResponse buscarPorEmail(String email) {
        return usuarioClient.buscarPorEmailQuery(email);
    }

    // ============================================================
    // GET /me
    // ============================================================
    public UsuarioDTOResponse buscarProprio(String token) {
        return usuarioClient.buscarProprio(token);
    }

    // ============================================================
    // PUT - atualizar nome / email
    // ============================================================
    public UsuarioDTOResponse atualizar(String token, UsuarioDTORequest dto) {
        return usuarioClient.atualizarDados(token, dto);
    }

    // ============================================================
    // PATCH - atualizar senha
    // ============================================================
    public void atualizarSenha(String token, String senha) {
        UsuarioDTORequest dto = UsuarioDTORequest.builder()
                .senha(senha)
                .build();

        usuarioClient.atualizarSenha(token, dto);
    }

    // ============================================================
    // DELETE conta
    // ============================================================
    public void deletarConta(String token) {
        usuarioClient.deletarConta(token);
    }

    // ============================================================
    // ENDEREÇO
    // ============================================================
    public EnderecoDTOResponse atualizarEndereco(Long id, EnderecoDTORequest dto) {
        return usuarioClient.atualizarEndereco(id, dto);
    }

    public EnderecoDTOResponse cadastrarEndereco(String token, EnderecoDTORequest dto) {
        return usuarioClient.cadastrarEndereco(token, dto);
    }

    // ============================================================
    // TELEFONE
    // ============================================================
    public TelefoneDTOResponse atualizarTelefone(Long id, TelefoneDTORequest dto) {
        return usuarioClient.atualizarTelefone(id, dto);
    }

    public TelefoneDTOResponse cadastrarTelefone(String token, TelefoneDTORequest dto) {
        return usuarioClient.cadastrarTelefone(token, dto);
    }
}
