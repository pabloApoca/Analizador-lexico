package com.fytc.AnalizadorLexico.controller;

import com.fytc.AnalizadorLexico.service_utils.AnalizadorLexicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/analizadorlexico")
public class AnalizadorLexicoController {

    /**
     * Inyeccion de dependencias del Service AnalizadorLexicoService.
     */
    @Autowired
    AnalizadorLexicoService analizadorLexicoService;


    /**
     * Pasa la ruta de la ubicacion del Lexer.flex al metodo generarLexer de la capa de negocio.
     * @return String - Lexer generado correctamente.
     */
    @GetMapping("/generarlexer")
    public String generarlexer(){
        String rutaLexer = "src/main/java/com/fytc/AnalizadorLexico/service_utils/Lexer.flex";
        analizadorLexicoService.generarLexer(rutaLexer);

        return "Lexer generado correctamente.";
    }


    /**
     * Toma el String que hayamos pasado en el cuerpo de la Request y lo pasa al metodo analizarTexto de la capa de negocio.
     * @param texto
     * @return String -> Analisis en detalle del String .
     * @throws IOException
     */
    @PostMapping("/analizartexto")
    public String leerString (@RequestBody String texto) throws IOException {
        return analizadorLexicoService.analizarTexto(texto);
    }


    /**
     * Toma el archivo .txt que hayamos subido al cuerpo de la Request y lo pasa al metodo analizarTxt de la capa de negocio.
     * @param file
     * @return String -> Analisis en detalle del archivo.txt .
     * @throws IOException
     */
    @PostMapping("/analizartxt")
    public String abrirTxt(@RequestBody MultipartFile file) throws IOException {
        return analizadorLexicoService.analizarTxt(file);
    }
}
