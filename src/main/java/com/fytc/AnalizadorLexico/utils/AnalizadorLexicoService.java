package com.fytc.AnalizadorLexico.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class AnalizadorLexicoService {


    public void generarLexer(String rutaLexer){

        File archivo = new File(rutaLexer);
        JFlex.Main.generate(archivo);
    }


    public String analizarTexto(String texto) throws IOException {
        File archivo = new File("archivo.txt");
        PrintWriter escribir;

        try {
            escribir = new PrintWriter(archivo);
            escribir.print(texto);
            escribir.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Reader lector = new BufferedReader(new FileReader("archivo.txt"));
        Lexer lexer = new Lexer(lector);

        String resultado = "";
        String resultadoFinal = "";

        while (true){
            Tokens tokens = lexer.yylex();
            if (tokens==null){
                resultado += "FIN";
                resultadoFinal += resultado;
                return resultadoFinal;
            }
            switch (tokens) {
                case ERROR:
                    resultado += lexer.yytext() + " ERROR: Simbolo no definido.\n";
                    break;
                case Identificador: case Numero:
                    resultado += lexer.lexeme + " --> " + tokens + "\n";
                    break;
                default:
                    //resultado += "Token: " + tokens + "\n";
                    resultado += lexer.yytext() + " --> "+ tokens + "\n";
                    break;
            }
        }
    }


    public String analizarTxt(MultipartFile txt) throws IOException {
        File archivo = new File("archivo.txt");
        PrintWriter escribir;

        MultipartFile newTxt = null;

        newTxt.transferTo((File) txt);


        try {
            escribir = new PrintWriter(archivo);
            escribir.print(newTxt);
            escribir.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Reader lector = new BufferedReader(new FileReader("archivo.txt"));
        Lexer lexer = new Lexer(lector);

        String resultado = "";
        String resultadoFinal = "";

        while (true){
            Tokens tokens = lexer.yylex();
            if (tokens==null){
                resultado += "FIN";
                resultadoFinal += resultado;
                return resultadoFinal;
            }
            switch (tokens) {
                case ERROR:
                    resultado += lexer.yytext() + " ERROR: Simbolo no definido.\n";
                    break;
                case Identificador: case Numero:
                    resultado += lexer.lexeme + " --> " + tokens + "\n";
                    break;
                default:
                    //resultado += "Token: " + tokens + "\n";
                    resultado += lexer.yytext() + " --> "+ tokens + "\n";
                    break;
            }
        }
    }

}
