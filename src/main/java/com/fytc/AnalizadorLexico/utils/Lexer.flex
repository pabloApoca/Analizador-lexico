package com.fytc.AnalizadorLexico.utils;
import static com.fytc.AnalizadorLexico.utils.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}
"ALGORITMO"|"Algoritmo"|"algoritmo" {return InicioAlgoritmo;}
"FINALGORITMO"|"FinAlgoritmo"|"finalgoritmo" {return FinAlgoritmo;}

"," {return Encadenar;}
";" {return PuntoYComa;}

"CARACTER"|"Caracter"|"caracter" {return TipoDeDatoCaracter;}
"ENTERO"|"Entero"|"entero" {return TipoDeDatoEntero;}
"LOGICO"|"Logico"|"logico" {return TipoDeDatoLogico;}
"REAL"|"Real"|"real" {return TipoDeDatoReal;}

"//".* {/*Ignore*/}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
"^" {return Potenciacion;}
"%"|"MOD" {return Modulo;}

">" {return Mayor;}
"<" {return Menor;}
"=" {return Igual;}
"<=" {return MenorOIgual;}
">=" {return MayorOIgual;}
"><" {return Distinto;}

"Y"|"&" {return Conjuncion;}
"O"|"||" {return Disyuncion;}
"NO"|"∼" {return Negacion;}

"RC"|"RAIZ" {return RaizCuadrada;}
"ABS" {return ValorAbsoluto;}
"LN" {return LogaritmoNatural;}
"EXP" {return FuncionExponencial;}
"SEN" {return Seno;}
"COS" {return Coseno;}
"TAN" {return Tangente;}
"ASEN" {return Arcoseno;}
"ACOS" {return Arcocoseno;}
"ATAN" {return Arcotangente;}
"TRUNC" {return ParteEntera;}
"REDON" {return EnteroMasCercano;}
"AZAR" {return EnteroAleatorio;}
"LONGITUD" {return Longitud;}
"CONCATENAR" {return ConcatenarCadenas;}
"CONVERTIRANUMERO" {return ConvertirVariableANumero;}
"CONVERTIRATEXTO" {return ConvertirVariableATexto;}

"LEER"|"Leer"|"leer" {return EntradaLectura;}
"ESCRIBIR"|"Escribir"|"escribir" {return SalidaEscritura;}
"<-" {return Asignacion;}

"SI"|"Si"|"si" {return InicioCondicionalSi;}
"ENTONCES"|"Entonces"|"entonces" {return  EntoncesIntrucciones;}
"SINO"|"Sino"|"sino" {return CondicionalSi;}
"FINSI"|"FinSi"|"finsi" {return FinCondicionalSi;}

"MIENTRAS"|"Mientras"|"mientras" {return InicioRepeticionMientras;}
"HACER"|"Hacer"|"hacer" {return HacerIntrucciones;}
"FINMIENTRAS"|"FinMientras"|"finmientras" {return FinRepeticionMientras;}

"PARA"|"Para"|"para" {return InicioPara;}
"DESDE"|"Desde"|"desde" {return MarcarDesde;}
"CON PASO"|"Con paso"|"Con Paso"|"con paso" {return MarcarConPaso;}
"FINPARA"|"FinPara"|"finpara" {return FinPara;}

"DEFINIR"|"Definir"|"definir" {return DefinirVariable;}
"COMO"|"Como"|"como" {return DefinirComoTipo;}
"DIMENSION"|"Dimension"|"dimension" {return DefinirDimension;}

"PROCESO"|"Proceso"|"proceso" {return InicioProceso;}
"FINPROCESO"|"FinProceso"|"finproceso" {return FinProceso;}

"SUBPROCESO"|"SubProceso"|"subproceso" {return InicioSubProceso;}
"COMENZAR"|"Comenzar"|"comenzar" {return ComenzarSubProceso;}
"FINSUBPROCESO"|"FinSubProceso"|"finsubproceso" {return  FinSubProceso;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
