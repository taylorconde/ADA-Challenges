package br.com.chavePix.service;

import br.com.chavePix.model.ChavePix;
import java.io.IOException;
import java.util.List;

public interface ChavePixService {
        void cadastrar(ChavePix chavePix) throws IOException;
        boolean existe(ChavePix chavePix) throws IOException;
        List<ChavePix> listarTodos() throws IOException;
}