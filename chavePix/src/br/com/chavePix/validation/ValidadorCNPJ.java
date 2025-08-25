package br.com.chavePix.validation;



public class ValidadorCNPJ implements ValidadorChave{


    @Override
    public boolean validar(String valor) {

        String cnpj = valor.replaceAll("\\D", "");

        if(!cnpj.matches("\\d{14}")){
            return false;
        }
        if(cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        int[] pesosPrimeiroDV = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesosSegundoDV  = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int somaTrezePrimeirosDigitos = 0;

        for(int i = 0; i < pesosPrimeiroDV.length; i++){
            int digito = cnpj.charAt(i) - '0';
            somaTrezePrimeirosDigitos += digito * pesosPrimeiroDV[i];
        }
        int restoV1 = somaTrezePrimeirosDigitos % 11;
        int v1 = (restoV1 < 2) ? 0 : 11 - restoV1;

        int somaQuatorzePrimeirosDigitos = 0;

        for(int i = 0; i < pesosSegundoDV.length; i++){
            int digito = cnpj.charAt(i) - '0';
            somaQuatorzePrimeirosDigitos += digito * pesosSegundoDV[i];
        }
        int restoV2 = somaQuatorzePrimeirosDigitos % 11;
        int v2 = (restoV2 < 2) ? 0 : 11 - restoV2;

        int dv1Original = cnpj.charAt(12) - '0';
        int dv2Original = cnpj.charAt(13) - '0';

        return dv1Original == v1 && dv2Original == v2;
    }
}
