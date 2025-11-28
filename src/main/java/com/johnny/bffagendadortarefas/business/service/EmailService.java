package com.johnny.bffagendadortarefas.business.service;

import com.johnny.bffagendadortarefas.business.dto.in.EmailDTORequest;
import com.johnny.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviarEmail(EmailDTORequest dto) {
        emailClient.enviarEmail(dto);
    }
}
