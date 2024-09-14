
# BoraBill Language

**BoraBill** é uma linguagem de programação projetada para facilitar a criação de programas simples com uma sintaxe intuitiva e suporte para estruturas de controle comuns. A linguagem é inspirada em conceitos de programação imperativa e oferece um ambiente básico para desenvolvimento de software.


## Autores

 - Gabriel Braga de Souza, 11202021785
 - Lucas Santana Santos, 11202130726
 - Paulo Victor Dias, 11202111146
   
## Estrutura da Linguagem

### Definição do Programa

Um programa em BoraBill deve começar com a palavra-chave `🚀BoraBill`, seguida de um identificador que define o nome do programa. O programa é delimitado por `JaVaiComecar` e `JaVaiTermina`, e termina com `AcabouBill`.

```bora
🚀BoraBill NomeDoPrograma
    Apareca
        variavel1, variavel2: number
    JaVaiComecar
        // Comandos
    JaVaiTermina
    AcabouBill
```

### Declaração de Variáveis

Variáveis são declaradas usando a palavra-chave `Apareca`. O tipo da variável pode ser `number` ou `text`. Cada variável deve ser finalizada com um ponto e vírgula (`PV`).

```bora
Apareca
    variavel1, variavel2: number
    variavel3: text
PV
```

### Comandos

A linguagem suporta os seguintes tipos de comandos:

- **Atribuição** (`cmdAttrib`): Para atribuir valores às variáveis.
- **Leitura** (`cmdRead`): Para ler valores para variáveis.
- **Escrita** (`cmdWrite`): Para imprimir valores.
- **Estruturas de Controle**:
  - **Condicional** (`cmdIf`): Para executar comandos baseados em condições.
  - **Laço While** (`cmdWhile`): Para executar comandos enquanto uma condição é verdadeira.
  - **Laço Do-While** (`cmdDoWhile`): Para executar comandos pelo menos uma vez e continuar enquanto uma condição é verdadeira.

#### Exemplo de Comando `cmdIf`

```bora
Eclipse
    (variavel1 > 10)
    {
        Devolva "Variável é maior que 10"
    }
    Engana
    {
        Devolva "Variável não é maior que 10"
    }
```

### Expressões

As expressões podem incluir operadores aritméticos (`+`, `-`, `*`, `/`), operadores relacionais (`<`, `>`, `==`, `!=`) e podem ser compostas usando parênteses e operações binárias e unárias.

```bora
variavel1 = 5 + 10 * 2
```

## Componentes da Linguagem

- **Variáveis**: Representadas por identificadores (`ID`), podem ser do tipo `number` ou `text`.
- **Tipos**: `number` e `text`.
- **Expressões**: Suportam operadores aritméticos e relacionais.
- **Estruturas de Controle**: `if`, `while`, `do-while`.

## Exemplo de Programa

```bora
🚀BoraBill MeuPrograma
    Apareca
        x, y: number
        mensagem: text
    JaVaiComecar
        x = 10
        y = 20
        Eclipse
            (x < y)
            {
                Devolva "x é menor que y"
            }
            Engana
            {
                Devolva "x não é menor que y"
            }
    JaVaiTermina
    AcabouBill
```

## Uso

Para usar a linguagem BoraBill, você deve compilar e interpretar os arquivos de código-fonte com o compilador e runtime incluídos no projeto. O compilador converte o código BoraBill em código executável, e o runtime permite a execução do programa.
