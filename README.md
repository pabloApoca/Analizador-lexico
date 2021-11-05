# Analizador-lexico
Trabajo final para la materia Fundamentos y teoría de la computación de mi carrera en UNLa. 



    * Lexer.flex : Archivo donde definimos todas nuestras reglas y/o lexemas.
    * Lexer :  Clase que se utiliza para analizar texto plano.
    * Tokens : Conjunto de palabras que va a reconocer nuestra clase Lexer.

Si necesitas saber como cree el scaffolding inicial de esta Api entra a aqui:

* [PROYECTO BASE](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.5&packaging=jar&jvmVersion=11&groupId=com.fytc&artifactId=AnalizadorLexico&name=AnalizadorLexico&description=Trabajo%20final%20para%20la%20materia%20Fundamentos%20y%20teor%C3%ADa%20de%20la%20computaci%C3%B3n%20de%20mi%20carrera%20en%20UNLa.%20&packageName=com.fytc.AnalizadorLexico&dependencies=devtools,lombok,web,data-jpa,validation,mysql): Spring Initialzr

Una vez levantado el contexto de Spring y nuestro servidor vamos a necesitar generar el Lexer que se va a crear en base a las reglas que tenga nuestro Lexer.flex y los Tokens que hayamos definido en nuestra clase Tokens.

# 1 - Generar lexer

***Al controlador se le va a pasar la ruta del Lexer.flex y siguiendo un poco la lógica del Patrón MVC le va a pasar la responsabilidad al Servicio generarLexer que lo que va a hacer es tomar esa ruta y crear una clase nueva llamada Lexer generada a través del método generate que nos proporciona la librería JFlex.***

### Endpoint
    GET http://localhost:8080/generarlexer


### Request
    Lexer generado correctamente.



-----------------------------------------------------------


# 2 - Analizar texto

***Una vez generada la clase Lexer se va a necesitar analizar el texto o el programa PSEINT, el controller va a tomar el texto plano que hayamos escrito en el Payload y va a pasar la responsabilidad al Service el cual va a contener el método analizarTexto que va hacer:***


* 1: Genera un archivo.txt .
* 2: Le escribe lo que nos paso el controller a través del Payload .
* 3: Creamos un Reader para poder leer esté archivo.txt .
* 4: Le pasamos esté Reader a una instancia de la clase Lexer.
* 5: Atrapamos todos los Tokens que hayamos leído en nuestra instancia del Lexer.
* 6: Sumamos todos los resultados a una cadena.
* 7: Una vez que se haya terminado de analizar el archivo.txt y se hayan sumado todos los Tokens y Errores se devuelve una Request con los resultados del análisis.

### Endpoint
    POST http://localhost:8080/analizartexto

### Ejemplo Payload

    Proceso
    Definir numAIngresar Como Real;
    Definir promedio Como Real;

    promedio = 0;

    Para contador=0 Con Paso 1 Hasta 9 Hacer
        Escribir “Ingrese número: “;
        Leer numAIngresar;

        promedio = promedio + numAIngresar;
    FinMientras

    Escribir “La división es: ", promedio / 10;
    FinProceso

### Request
    Proceso --> InicioProceso
    Definir --> DefinirVariable
    numAIngresar --> Identificador
    Como --> DefinirComoTipo
    Real --> TipoDeDatoReal
    ; --> PuntoYComa
    Definir --> DefinirVariable
    promedio --> Identificador
    Como --> DefinirComoTipo
    Real --> TipoDeDatoReal
    ; --> PuntoYComa
    promedio --> Identificador
    = --> Igual
    0 --> Numero
    ; --> PuntoYComa
    Para --> InicioPara
    contador --> Identificador
    = --> Igual
    0 --> Numero
    Con Paso --> MarcarConPaso
    1 --> Numero
    Hasta --> Identificador
    9 --> Numero
    Hacer --> HacerIntrucciones
    Escribir --> SalidaEscritura
    “ --> Comilla
    Ingrese --> Identificador
    n --> Identificador
    ú ERROR: Simbolo no definido.
    mero --> Identificador
    : --> DosPuntos
    “ --> Comilla
    ; --> PuntoYComa
    Leer --> EntradaLectura
    numAIngresar --> Identificador
    ; --> PuntoYComa
    promedio --> Identificador
    = --> Igual
    promedio --> Identificador
    + --> Suma
    numAIngresar --> Identificador
    ; --> PuntoYComa
    FinMientras --> FinRepeticionMientras
    Escribir --> SalidaEscritura
    “ --> Comilla
    La --> Identificador
    divisi --> Identificador
    ó ERROR: Simbolo no definido.
    n --> Identificador
    es --> Identificador
    : --> DosPuntos
    " --> Comilla
    promedio --> Identificador
    / --> Division
    10 --> Numero
    ; --> PuntoYComa
    FinProceso --> FinProceso
    FIN

----------------


# Author
* Lopez, Pablo Martin

# Materia 
* Fundamentos y teoría de la computación

#Universidad
* Universidad Nacional de Lanús (UNLa)
