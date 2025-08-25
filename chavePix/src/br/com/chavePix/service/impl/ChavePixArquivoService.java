package br.com.chavePix.service.impl;

import br.com.chavePix.model.ChavePix;
import br.com.chavePix.service.ChavePixService;
import br.com.chavePix.util.PersistenciaChave;

import java.io.IOException;
import java.util.List;


public class ChavePixArquivoService implements ChavePixService{

    private final PersistenciaChave persistencia;

    public ChavePixArquivoService(String caminho){
        this.persistencia = new PersistenciaChave(caminho);
    }

    @Override
    public void cadastrar(ChavePix chavePix) throws IOException{
        persistencia.salvar(chavePix);
    }

    @Override
    public boolean existe(ChavePix chavePix) throws IOException{
        return listarTodos().stream()
                .anyMatch(c -> c.getTipo().equalsIgnoreCase(chavePix.getTipo())
                && c.getValor().equals(chavePix.getValor())
                && c.getAgencia().equals(chavePix.getAgencia()));
    }

    @Override
    public List<ChavePix> listarTodos() throws IOException {
        return persistencia.carregarTodas();
    }
}
