package com.itau.api_inteligente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TranscricaoController {

    @GetMapping("/status")
    public String status() {
        return "API Inteligente com Reconhecimento de Fala está a funcionar!";
    }
}