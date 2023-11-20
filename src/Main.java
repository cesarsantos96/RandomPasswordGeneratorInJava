public class Main {
    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator(12);
        PasswordGeneratorGUI gui = new PasswordGeneratorGUI(generator);
        gui.showGUI();
    }
}
