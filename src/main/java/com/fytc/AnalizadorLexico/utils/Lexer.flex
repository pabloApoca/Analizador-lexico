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
int |
if |
else |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
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
"O"|"|" {return Disyuncion;}
"NO"|"∼" {return Negacion;}

"RC" {return RaizCuadrada;}
"ABS" {return ValorAbsoluto;}
"LN" {return LogaritmoNatural;}
"EXP" {return FuncionExponencial;}
"SEN" {return Seno;}
"COS" {return Coseno;}
"ATAN" {return Arcotangente;}
"TRUNC" {return ParteEntera;}
"REDON" {return EnteroMasCercano;}
"AZAR" {return EnteroAleatorio;}

"LEER"|"leer" {return EntradaLectura;}
"ESCRIBIR"|"escribir" {return  SalidaEscritura;}
"<-" {return Asignacion;}

"SI"|"si" {return InicioCondicionalSi;}
"ENTONCES"|"entonces" {return  EntoncesIntrucciones;}
"SINO"|"sino" {return CondicionalSi;}
"FINSI"|"finsi" {return FinCondicionalSi;}

"MIENTRAS"|"mientras" {return InicioRepeticionMientras;}
"HACER"|"hacer" {return  HacerIntrucciones;}
"FINMIENTRAS"|"finmientras" {return FinRepeticionMientras;}

"PARA"|"para" {return InicioPara;}
"DESDE"|"desde" {return  MarcarDesde;}
"CON PASO"|"con paso" {return MarcarConPaso;}
"FINPARA"|"finpara" {return FinPara;}

"DEFINIR"|"definir" {return DefinirVariable;}
"COMO"|"como" {return  DefinirComoTipo;}
"DIMENSION"|"dimension" {return DefinirDimension;}

"SUBPROCESO"|"subproceso" {return InicioSubProceso;}
"COMENZAR"|"comenzar" {return ComenzarSubProceso;}
"FINSUBPROCESO"|"finsubproceso" {return  FinSubProceso;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
