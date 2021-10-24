package com.fytc.AnalizadorLexico;

import com.fytc.AnalizadorLexico.modelo.AnalizadorLexico;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.fytc.AnalizadorLexico.service.AnalizadorLexicoService.generarLexer;

@SpringBootApplication
public class AnalizadorLexicoApplication {



	public static void main(String[] args) {
		SpringApplication.run(AnalizadorLexicoApplication.class, args);

		//String rutaLexer = "C:/Users/pablo/OneDrive/Escritorio/Analizador-lexico/src/main/java/com/fytc/AnalizadorLexico/utils/Lexer.flex";

		String rutaLexer2 = "C:/Users/sergi/OneDrive/Escritorio/Todo a archivos/Analizador-lexico/src/main/java/com/fytc/AnalizadorLexico/utils/Lexer.flex";

		generarLexer(rutaLexer2);
	}

}
