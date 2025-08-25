import java.io.IOException;

import static passwordmanager.PasswordManager.checkFile;
import static passwordmanager.PasswordManager.getPassword;

public class Main {
    public static void main(String[] args) throws IOException {

        // Validar se foi inserido parametro;
        if(!(args.length > 0)){
            System.out.println("Por favor, insira o nome da rede social.");
            return;
        }
        String redeSocial = args[0];

        if(checkFile()) { // Verificando se o arquivo de senhas existe
            // Verificando se o parametro ja existe no arquivo
            String password = getPassword(redeSocial);
            System.out.println(password);
        }

    }
}