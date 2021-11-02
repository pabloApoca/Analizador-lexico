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

        String rutaLexer = "src/main/java/com/fytc/AnalizadorLexico/utils/Lexer.flex";
        analizadorLexicoService.generarLexer(rutaLexer);

        return "Lexer generado correctamente.";
    }



    /**/@PostMapping("/escribir")
    public String escribir (@RequestBody String texto) throws IOException {
        return analizadorLexicoService.escribirArchivoTxt(texto);
    }
}
