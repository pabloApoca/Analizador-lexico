package com.fytc.AnalizadorLexico.controller;

import com.fytc.AnalizadorLexico.utils.AnalizadorLexicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class AnalizadorLexicoController {

    @Autowired
    AnalizadorLexicoService analizadorLexicoService;

    @GetMapping("/generarlexer")
    public String generarlexer(){

        String rutaLexer2 = "src/main/java/com/fytc/AnalizadorLexico/utils/Lexer.flex";

        analizadorLexicoService.generarLexer(rutaLexer2);

        return "Lexer generado correctamente.";
    }

    /**/@PostMapping("/analizar")
    public String devolverRespuesta (String analizar) throws IOException {
        return analizadorLexicoService.analizar(analizar);
    }

    /**/@PostMapping("/escribir")
    public List<String> escribir (@RequestBody String texto) throws IOException {
        return analizadorLexicoService.escribirArchivoTxt(texto);
    }
}
