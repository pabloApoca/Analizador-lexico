package com.fytc.AnalizadorLexico.service;

import java.io.File;

public class AnalizadorLexicoService {

   /* public static void main(String[] args) {
        String ruta = "C:/ruta/pablo/OneDrive/Escritorio/AnalizadorLexico/src/codigo/Lexer.flex";

        generarLexer(ruta);
    }*/

    public static void generarLexer(String rutaLexer){


        File archivo = new File(rutaLexer);

        JFlex.Main.generate(archivo);
    }

}
