
package com.fytc.AnalizadorLexico.service_utils;


public enum Tokens {
    InicioAlgoritmo,
    FinAlgoritmo,

    Encadenar,
    PuntoYComa,
    DosPuntos,
    AbreParentesis,
    CierreParentesis,
    Comilla,
    AbreArreglo,
    CierreArreglo,

    TipoDeDatoCaracter,
    TipoDeDatoEntero,
    TipoDeDatoLogico,
    TipoDeDatoReal,

    Igual,
    Suma,
    Resta,
    Multiplicacion,
    Division,
    Potenciacion,
    Modulo,

    Mayor,
    Menor,
    MenorOIgual,
    MayorOIgual,
    Distinto,

    Conjuncion,
    Disyuncion,
    Negacion,

    RaizCuadrada,
    ValorAbsoluto,
    LogaritmoNatural,
    FuncionExponencial,
    Seno,
    Coseno,
    Tangente,
    Arcoseno,
    Arcocoseno,
    Arcotangente,
    ParteEntera,
    EnteroMasCercano,
    EnteroAleatorio,
    Longitud,
    ConcatenarCadenas,
    ConvertirVariableANumero,
    ConvertirVariableATexto,

    EntradaLectura,
    SalidaEscritura,
    Asignacion,

    InicioCondicionalSi,
    EntoncesIntrucciones,
    CondicionalSi,
    FinCondicionalSi,

    InicioRepeticionMientras,
    HacerIntrucciones,
    FinRepeticionMientras,

    InicioPara,
    MarcarDesde,
    MarcarConPaso,
    FinPara,

    DefinirVariable,
    DefinirComoTipo,
    DefinirDimension,

    InicioProceso,
    FinProceso,

    InicioSubProceso,
    ComenzarSubProceso,
    FinSubProceso,

    Identificador,
    Numero,
    ERROR,


}
