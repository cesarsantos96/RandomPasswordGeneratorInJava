import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator(12);
        String passwordGenerated = generator.generatePassword();
        System.out.println("Senha Gerada: " + passwordGenerated);

        savePasswordToFile(passwordGenerated, "senhas.txt");
    }

    private static void savePasswordToFile(String password, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(password);
            writer.newLine();
            System.out.println("Senha salva com sucesso no arquivo: " + filename);
        } catch (IOException e ){
            System.err.println("Erro ao salvar a senha no arquivo: " + e.getMessage());
        }
    }
}