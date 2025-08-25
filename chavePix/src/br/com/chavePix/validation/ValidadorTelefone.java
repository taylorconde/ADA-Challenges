package br.com.chavePix.validation;

import br.com.chavePix.model.DDD;

public class ValidadorTelefone implements ValidadorChave{

    @Override
    public boolean validar(String valor) {

        String telefone = valor.replaceAll("\\D", "");

        if(!telefone.matches("\\d{11}")){
            return false;
        };

        if(telefone.matches("(\\d)\\1{10}")) {
            return false;
        }

        if(!(telefone.substring(2,3).equals("9"))){
            return false;
        }

        String dddStr = telefone.substring(0, 2); // primeiros 2 dígitos

        int ddd = Integer.parseInt(dddStr);

        if (!DDD.isValido(ddd)) {
            System.out.println("DDD invalido");
            return false;
        }

        return true;
    }
}
