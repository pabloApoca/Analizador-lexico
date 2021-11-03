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
">" {return Mayor;}
"<" {return Menor;}
"=" {return Igual;}
"<=" {return MenorOIgual;}
">=" {return MayorOIgual;}
"><" {return Distinto;}
"Y"|"&" {return Conjuncion;}
"O"|"|" {return Disyuncion;}
"NO"|"∼" {return Negacion;}
"%"|"MOD" {return Modulo;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
 . {return ERROR;}
