public class Main {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator(12);
        String passwordGenerated = generator.generatePassword();
        System.out.println("Senha Gerada: " + passwordGenerated);
    }
}