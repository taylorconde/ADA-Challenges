package passwordgenerator;
import java.security.SecureRandom;
import java.util.*;


public class PasswordGenerator {

    private static final String LETRAS_MAIUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITOS = "0123456789";
    private static final String ESPECIAIS = "!@#$%^&*()-_=+[]{};:,.<>?";

    private static final String TODOS = LETRAS_MAIUSCULAS + LETRAS_MINUSCULAS + DIGITOS + ESPECIAIS;

    private static final SecureRandom random = new SecureRandom();

    public static String gerarSenha(){
        int tamanho = 12;
        Random random = new Random();
        StringBuilder senha = new StringBuilder();

        // Garantir diversidade mínima
        senha.append(LETRAS_MAIUSCULAS.charAt(random.nextInt(LETRAS_MAIUSCULAS.length())));
        senha.append(LETRAS_MINUSCULAS.charAt(random.nextInt(LETRAS_MINUSCULAS.length())));
        senha.append(DIGITOS.charAt(random.nextInt(DIGITOS.length())));
        senha.append(ESPECIAIS.charAt(random.nextInt(ESPECIAIS.length())));

        // Completar o restante dos caracteres da senha
        for (int i = senha.length(); i < tamanho; i++) {
            senha.append(TODOS.charAt(random.nextInt(TODOS.length())));
        }

        // Embaralhar
        List<Character> chars = new ArrayList<>();
        for (char c: senha.toString().toCharArray()){
            chars.add(c);
        }
        Collections.shuffle(chars);

        // Transformar em String novamente para retornar
        StringBuilder senhaFinal = new StringBuilder();
        for (char c: chars){
            senhaFinal.append(c);
        }

        return senhaFinal.toString();
    }
}
