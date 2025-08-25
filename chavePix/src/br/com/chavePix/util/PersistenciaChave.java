package br.com.chavePix.util;

import br.com.chavePix.model.ChavePix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersistenciaChave {

    private final File arquivo;

    public PersistenciaChave(String caminho) {
        this.arquivo = new File(caminho);
    }

    public void salvar(ChavePix chave) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
            bw.write(chave.toString());
            bw.newLine();
        }
    }

    public List<ChavePix> carregarTodas() throws IOException {
        List<ChavePix> chaves = new ArrayList<>();
        if(!arquivo.exists()) return chaves;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while((linha = br.readLine()) != null) {
                String[] partes = linha.split(":");
                if (partes.length == 3) {
                    chaves.add(new ChavePix(partes[0], partes[1], partes[2]));
                }
            }
        }
        return chaves;
    }
}
