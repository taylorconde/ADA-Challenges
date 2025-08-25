package br.com.chavePix.model;

public class ChavePix {
    private final String tipo;   // CPF, CNPJ, EMAIL, TELEFONE
    private final String valor;  // o valor da chave
    private final String agencia; // código da agência

    public ChavePix(String tipo, String valor, String agencia) {
        this.tipo = tipo;
        this.valor = valor;
        this.agencia = agencia;
    }

    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public String getAgencia() {
        return agencia;
    }

    @Override
    public String toString() {
        return tipo + ":" + valor + ":" + agencia;
    }
}
