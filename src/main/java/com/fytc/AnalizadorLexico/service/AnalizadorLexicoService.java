package com.fytc.AnalizadorLexico.service;

import com.fytc.AnalizadorLexico.utils.Lexer;
import com.fytc.AnalizadorLexico.utils.Tokens;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AnalizadorLexicoService {


    public void generarLexer(String rutaLexer){

        File archivo = new File(rutaLexer);
        JFlex.Main.generate(archivo);
    }

    /**/public String analizar (String texto) throws IOException {
        String resultado = "";

        String resultadoFinal = "";
        //Reader lector = new BufferedReader(new FileReader("archivo.txt"));

        StringReader lector = new StringReader(texto);
        Lexer lexer = new Lexer(lector);



        while (true){
            Tokens tokens = lexer.yylex();
            if (tokens==null){
                resultado += "FIN";
                return resultado;
            }
            switch (tokens) {
                case ERROR:
                    resultado += "Simbolo no definido\n";
                    break;
                case Identificador: case Numero: case Reservadas:
                    resultado += lexer.lexeme + ": Es un " + tokens + "\n";
                    break;
                default:
                    resultado += "Token: " + tokens + "\n";
                    break;
            }
        }
    }

}
