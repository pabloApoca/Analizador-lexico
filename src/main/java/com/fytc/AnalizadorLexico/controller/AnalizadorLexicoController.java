package com.fytc.AnalizadorLexico.controller;

import com.fytc.AnalizadorLexico.modelo.AnalizadorLexico;
import com.fytc.AnalizadorLexico.service.AnalizadorLexicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class AnalizadorLexicoController {

    @Autowired
    AnalizadorLexicoService analizadorLexicoService;

    @PostMapping("/analizar")
    public String devolverRespuesta (String analizar) throws IOException {
        return analizadorLexicoService.analizar(analizar);
    }
}
