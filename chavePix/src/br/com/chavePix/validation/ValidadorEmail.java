package br.com.chavePix.validation;

public class ValidadorEmail implements ValidadorChave{

    @Override
    public boolean validar(String valor){

        String email = valor.trim();
        String regexEmail = "^[a-zA-Z0-9à-úÀ-Ú._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        return email.matches(regexEmail);
    }
}
