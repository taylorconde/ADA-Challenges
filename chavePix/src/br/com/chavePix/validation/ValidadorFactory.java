package br.com.chavePix.validation;

import br.com.chavePix.model.TipoChave;

public class ValidadorFactory {

    public static ValidadorChave getValidador(TipoChave tipo) throws IllegalAccessException {

        switch (tipo) {
            case CPF:
                return new ValidadorCPF();
            case CNPJ:
                return new ValidadorCNPJ();
            case TELEFONE:
                return new ValidadorTelefone();
            case EMAIL:
                return new ValidadorEmail();

            default:
                throw new IllegalAccessException("Tipo de chave nao suportado: " + tipo);
        }
    }

}
