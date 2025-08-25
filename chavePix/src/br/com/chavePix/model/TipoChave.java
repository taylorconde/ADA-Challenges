package br.com.chavePix.model;

public enum TipoChave {
    CPF,
    CNPJ,
    TELEFONE,
    EMAIL;

    public static boolean isTipoValido(String tipo) {
        try {
            TipoChave.valueOf(tipo.toUpperCase());
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }
}
