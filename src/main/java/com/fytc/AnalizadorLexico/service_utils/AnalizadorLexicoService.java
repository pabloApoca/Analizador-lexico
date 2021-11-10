package com.fytc.AnalizadorLexico.service_utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class AnalizadorLexicoService {


    /**
     * Toma la ruta que le paso el Controller para generar la clase Lexer con la libreria JFlex.
     * @param rutaLexer
     */
    public void generarLexer(String rutaLexer){
        File archivo = new File(rutaLexer);
        JFlex.Main.generate(archivo);
    }


    /**
     * Toma el texto que le paso el Controller, crea un nuevo archivo .txt para escribirle el texto y lo analiza con el Lexer.
     * @param texto
     * @return String -> Analisis en detalle del String .
     * @throws IOException
     */
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


    /**
     * Toma el archivo .txt que le paso el Controller, lo convierte MultipartFile a un File, lo almacena en el scafolding lo busca y lo analiza con el Lexer.
     * @param file
     * @return String -> Analisis en detalle del archivo.txt .
     * @throws IOException
     */
    public String analizarTxt(MultipartFile file) throws IOException {

        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();

        Reader lector = new BufferedReader(new FileReader(convFile.getName()));
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
