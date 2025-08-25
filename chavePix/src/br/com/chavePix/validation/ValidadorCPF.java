package br.com.chavePix.validation;

public class ValidadorCPF implements ValidadorChave{

    @Override
    public boolean validar(String valor){
        String cpf = valor.replaceAll("\\D", "");

        if (!cpf.matches("\\d{11}")){
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        //  primeiro digito validador
        int somarNovePrimeirosDigitos = 0;

        for(int i = 0; i < 9; i++){
            int digito = cpf.charAt(i) - '0';
            int peso = 10 - i;
            somarNovePrimeirosDigitos += peso * digito;
        }
        int restoV1 = somarNovePrimeirosDigitos % 11;
        int v1 = (restoV1 < 2) ? 0: 11 - restoV1;

        // segundo digito validador
        int somarDezPrimeirosDigitos = 0;

        for(int i=0; i<10; i++){
            int digito = cpf.charAt(i) - '0';
            int peso = 11 - i;
            somarDezPrimeirosDigitos += peso * digito;
        }
        int restoV2 = somarDezPrimeirosDigitos % 11;
        int v2 = (restoV2 < 2)? 0 : 11 - restoV2;

        int dv1Original = cpf.charAt(9) - '0';
        int dv2Original = cpf.charAt(10) - '0';

        return dv1Original == v1 && dv2Original == v2;
    }
}
