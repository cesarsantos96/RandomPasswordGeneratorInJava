import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-=_+";
    private static final SecureRandom random = new SecureRandom();

    private int lengthPassword;

    public PasswordGenerator(int lengthPassword) {
        this.lengthPassword = lengthPassword;
    }

    public String generatePassword() {
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < lengthPassword; ++i) {
            int indice = random.nextInt(CHARACTERS.length());
            senha.append(CHARACTERS.charAt(indice));
        }
        return senha.toString();
    }
}