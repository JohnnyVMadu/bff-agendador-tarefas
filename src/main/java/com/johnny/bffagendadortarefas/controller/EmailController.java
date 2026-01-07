package com.johnny.bffagendadortarefas.controller;

import com.johnny.bffagendadortarefas.business.dto.in.EmailDTORequest;
import com.johnny.bffagendadortarefas.business.service.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
@Tag(name = "Email", description = "Envio de emails de notificação")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> enviarEmail(@RequestBody EmailDTORequest dto) {
        emailService.enviarEmail(dto);
        return ResponseEntity.ok().build();
    }
}
