```markdown
# ChavePix

O **ChavePix** é um projeto em Java para gerenciamento de chaves PIX, com validação de dados e persistência em arquivo local.
Suporta CPF, CNPJ, telefone e e-mail.

---

## Funcionalidades atuais

- Cadastro de chaves PIX.
- Validação de chaves antes do cadastro:
  - CPF
  - CNPJ
  - Telefone (somente números móveis com DDD válido)
  - E-mail
- Persistência das chaves no arquivo `data/.chaves` no formato:
  TIPO\:VALOR\:CODIGO\_AGENCIA
```
```

Exemplo:

CPF:50340304011:022
TELEFONE:85984331133:002
EMAIL\:teste\@email.com:001
```
```

- Verificação de chaves duplicadas antes do cadastro.

---

## Funcionalidades futuras

As seguintes funcionalidades serão implementadas posteriormente:

- Remoção de chaves PIX.
- Listagem de todas as chaves cadastradas.
- Busca de chaves específicas por valor ou tipo.
- Suporte a tags ou categorias de chaves para organização.

---

## Estrutura do Projeto

```
```
chavePix/
├── README.md
├── data/
│   └── .chaves
├── src/
│   └── br/com/chavePix/
│       ├── Main.java
│       ├── controller/
│       │   └── PixController.java
│       ├── model/
│       │   ├── ChavePix.java
│       │   ├── DDD.java
│       │   └── TipoChave.java
│       ├── service/
│       │   ├── ChavePixService.java
│       │   └── impl/ChavePixArquivoService.java
│       ├── util/
│       │   └── PersistenciaChave.java
│       └── validation/
│           ├── ValidadorCNPJ.java
│           ├── ValidadorCPF.java
│           ├── ValidadorChave.java
│           ├── ValidadorEmail.java
│           ├── ValidadorFactory.java
│           └── ValidadorTelefone.java

````

---

## Como usar

O programa é executado no terminal e recebe três parâmetros na linha de comando:  

1. Tipo da chave (`CPF`, `CNPJ`, `TELEFONE`, `EMAIL`)  
2. Valor da chave  
3. Código da agência/instituição  

Exemplo de cadastro de chave:

```bash
java -cp out br.com.chavePix.Main CPF 50340304011 022
java -cp out br.com.chavePix.Main TELEFONE 859984331133 002
java -cp out br.com.chavePix.Main EMAIL teste@email.com 001
````

> Certifique-se de que o arquivo `.chaves` exista no diretório `data/` e esteja protegido, pois contém dados sensíveis.

---

## Regras de Validação

* **CPF**: 11 dígitos, sem sequências repetidas, com dígitos verificadores válidos.
* **CNPJ**: 14 dígitos, sem sequências repetidas, com dígitos verificadores válidos.
* **Telefone**: 11 dígitos, DDD válido, começa com 9 (somente número móvel).
* **E-mail**: Deve conter `@` e domínio válido.

---

## Compilação

Para compilar:

```bash
javac -d out $(find src -name "*.java")
```

Para executar:

```bash
java -cp out br.com.chavePix.Main CPF 50340304011 022
```

---

## Autor

* John Taylor

