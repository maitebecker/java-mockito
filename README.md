# Exemplos utilizando o Mockito Framework

Exemplos desenvolvidos durante o bootcamp de java da plataforma [DIO](https://web.dio.me/)

- Ao escrever testes precisamos simular partes do nosso sistema. A utilização de mocks elimina a necessidade de utilizar alternativas mais lentas, por exemplo banco de dados.
- Mocks são imitações ou unidades falsas que simulam o comportamento de unidades reais
- Mockito é um framework utilizado em testes para simular instância de classes e métodos

## Configuração - Maven
Adicionar no arquivo ```pom.xml``` as dependências abaixo:
```xml
<!-- https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.12.0</version>
    <scope>test</scope>
</dependency>
```
Fonte: https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter/5.12.0

```xml
<!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.12.0</version>
    <scope>test</scope>
</dependency>
```
Fonte: https://mvnrepository.com/artifact/org.mockito/mockito-core/5.12.0

## Exemplos realizados:
[Exemplos Mockito](mockito_exemplos)
