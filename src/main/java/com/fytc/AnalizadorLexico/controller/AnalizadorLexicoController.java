package com.fytc.AnalizadorLexico.controller;

import com.fytc.AnalizadorLexico.modelo.AnalizadorLexico;
import com.fytc.AnalizadorLexico.service.AnalizadorLexicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;


@RestController
public class AnalizadorLexicoController {

    @Autowired
    AnalizadorLexicoService analizadorLexicoService;

    @GetMapping("/generarlexer")
    public String generarlexer(){
        //String rutaLexer = "C:/Users/pablo/OneDrive/Escritorio/Analizador-lexico/src/main/java/com/fytc/AnalizadorLexico/utils/Lexer.flex";

        String rutaLexer2 = "C:/Users/sergi/OneDrive/Escritorio/Todo a archivos/Analizador-lexico/src/main/java/com/fytc/AnalizadorLexico/utils/Lexer.flex";

        analizadorLexicoService.generarLexer(rutaLexer2);

        return "Lexer generado correctamente.";
    }

    /**/@PostMapping("/analizar")
    public String devolverRespuesta (String analizar) throws IOException {
        return analizadorLexicoService.analizar(analizar);
    }
}
