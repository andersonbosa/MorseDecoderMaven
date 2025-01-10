# MorseDecoderMaven

Este é um projeto de estudo da linguagem Java realizado no Bootcamp MELI (Mercado Livre). O projeto consiste em um decodificador de código Morse, que pode codificar e decodificar mensagens em código Morse.

## Dependências

O projeto utiliza as seguintes dependências:

- Spring Boot Starter Web
- Spring Boot DevTools
- Lombok

Essas dependências estão definidas no arquivo [pom.xml](pom.xml).

## Classes Principais

### MorseEngine

A classe [`MorseEngine`](src/main/java/com/br/morsedecodermaven/service/MorseEngine.java) é responsável por codificar e decodificar mensagens em código Morse. Ela contém um mapa estático que mapeia caracteres para seus respectivos códigos Morse e métodos para codificação e decodificação.

### MorseCodeController

A classe [`MorseCodeController`](src/main/java/com/br/morsedecodermaven/controller/MorseCodeController.java) é um controlador REST que expõe endpoints para codificação e decodificação de mensagens. Ela utiliza a classe `MorseEngine` para realizar essas operações.

## Endpoints

O projeto expõe os seguintes endpoints:

- `GET /api/encode?input={mensagem}`: Codifica a mensagem fornecida em código Morse.
- `GET /api/decode?input={codigoMorse}`: Decodifica o código Morse fornecido em uma mensagem.
