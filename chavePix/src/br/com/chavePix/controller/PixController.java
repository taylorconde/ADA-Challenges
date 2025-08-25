package br.com.chavePix.controller;

import br.com.chavePix.model.ChavePix;
import br.com.chavePix.model.TipoChave;
import br.com.chavePix.service.ChavePixService;
import br.com.chavePix.validation.ValidadorChave;
import br.com.chavePix.validation.ValidadorFactory;

import java.io.IOException;

public class PixController {

    private final ChavePixService service;

    public PixController(ChavePixService service){
        this.service = service;
    }

    public void executarCadastro(ChavePix chave) throws IllegalAccessException, IOException {

        TipoChave tipoEnum = TipoChave.valueOf(chave.getTipo().toUpperCase());
        ValidadorChave validador = ValidadorFactory.getValidador(tipoEnum);

        if (!validador.validar(chave.getValor())) {
            System.out.println("Valor da chave invalido para o tipo " + tipoEnum);
            return;
        }

        if(!service.existe(chave)){
            service.cadastrar(chave);
            System.out.println("Chave: " + chave + ", cadastrada com sucesso!" );
        }else{
            System.out.println("Chave ja existe.");
        }
    }

}
