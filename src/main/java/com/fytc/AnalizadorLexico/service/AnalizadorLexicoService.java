package com.fytc.AnalizadorLexico.service;

import jflex.anttask.JFlexTask;

import java.io.File;

public class AnalizadorLexicoService {

   /* public static void main(String[] args) {
        String ruta = "C:/ruta/pablo/OneDrive/Escritorio/AnalizadorLexico/src/codigo/Lexer.flex";

        generarLexer(ruta);
    }*/
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        //JFlex
        JFlex.Main.generate(archivo);
    }

}
