package com.test.hex.cinehexgateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/cine")
    public ResponseEntity<Map<String, String>> cineFallback() {
        // Respuesta JSON amigable en lugar de un error de conexión
        Map<String, String> response = new HashMap<>();
        response.put("code", "503");
        response.put("message", "El servicio de CineHex no está disponible temporalmente.");
        response.put("reason", "Estamos experimentando alta carga o mantenimiento. Por favor intenta en unos minutos.");

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
    }

}
