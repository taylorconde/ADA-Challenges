package br.com.chavePix;

import br.com.chavePix.controller.PixController;
import br.com.chavePix.service.impl.ChavePixArquivoService;
import br.com.chavePix.model.ChavePix;
import br.com.chavePix.model.TipoChave;

import java.io.IOException;


class Main{

    public static void main(String[] args) throws IllegalAccessException, IOException {

        if(args.length < 3){
            System.out.println("Uso: java Main <tipo> <valor> <codigoInstituicao>");
            System.out.println("Tipos válidos: CPF, CNPJ, TELEFONE, EMAIL");
            System.out.println("Exemplo: java Main CPF 12345678901 001");
            return;

        }

        String tipo = args[0];
        String valor = args[1];
        String codigoInstituicao = args[2];

        if (!TipoChave.isTipoValido(tipo)){
            System.out.println("Tipo de chave inválido! Tipos válidos: CPF, CNPJ, TELEFONE, EMAIL");
            return;
        }

        if (!codigoInstituicao.matches("\\d{3}")){
            System.out.println("Código da instituição inválido! Deve ter exatamente 3 dígitos.");
            return;

        }

        ChavePix chave = new ChavePix(tipo, valor, codigoInstituicao);
        String caminhoArquivo = "data/.chaves";
        PixController controller = new PixController(
                new ChavePixArquivoService(caminhoArquivo));
        controller.executarCadastro(chave);
    }
}