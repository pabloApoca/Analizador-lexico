package com.fytc.AnalizadorLexico.controller;

import com.fytc.AnalizadorLexico.utils.AnalizadorLexicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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



    @PostMapping("/analizartexto")
    public String escribir (@RequestBody String texto) throws IOException {
        return analizadorLexicoService.analizarTexto(texto);
    }

    //@PostMapping("/analizartxt")
    @PutMapping ( value = "/analizartxt", consumes = { "multipart/form-data" })
    public String abrirtxt(@RequestPart ( "imageFile") MultipartFile imageFile ) throws IOException {

        return analizadorLexicoService.analizarTxt(imageFile);
    }
}
