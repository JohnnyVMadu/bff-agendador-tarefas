package com.johnny.bffagendadortarefas.infrastructure.client;

import com.johnny.bffagendadortarefas.business.dto.in.EmailDTORequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "email-service",
        url = "http://localhost:8082/email"
)
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody EmailDTORequest dto);
}
