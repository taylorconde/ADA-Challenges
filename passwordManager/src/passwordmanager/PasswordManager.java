package passwordmanager;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static passwordgenerator.PasswordGenerator.gerarSenha;

public class PasswordManager {

    private static final String ARQUIVO = ".passwords";

    // Procurar arquivo .password;
    public static boolean checkFile() {
        File arquivo = new File(ARQUIVO);

        try {
            if(!arquivo.exists()){
                boolean criado = arquivo.createNewFile();
                if (criado){
                    System.out.println("Arquivo .passwords criado com sucesso;");
                    return true;
                } else {
                    System.out.println("Nao foi possivel criar o arquivo.");
                    return false;
                }
            } else {
                return true;
            }
        } catch (IOException e){
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
            return false;
        }
    }

    // Verificar se parametro informado ja existe na lista de senhas
    public static String getPassword(String parametro) throws IOException {

        File arquivo = new File(ARQUIVO);
        Map<String, String> mapa = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(":", 2);
                if (partes.length == 2) {
                    mapa.put(partes[0], partes[1]);
                }
            }
        }

        // Se o parametro ja existir, retorna a senha vinculada
        if (mapa.containsKey(parametro)) {
            return mapa.get(parametro);
        }

        // Se o parametro nao existe ainda, gera uma senha e salva
        String newPassword = gerarSenha();
        mapa.put(parametro, newPassword);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Map.Entry<String, String> entry : mapa.entrySet()) {
                bw.write(entry.getKey() + ":" + entry.getValue());
                bw.newLine();
            }
        }
        return newPassword;
    }

}
