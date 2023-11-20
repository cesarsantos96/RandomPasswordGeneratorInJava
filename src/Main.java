import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crie uma instância do PasswordGenerator
            PasswordGenerator generator = new PasswordGenerator(12);

            // Crie uma instância do PasswordGeneratorGUI, passando o gerador como parâmetro
            PasswordGeneratorGUI gui = new PasswordGeneratorGUI(generator);

            // Mostre a interface gráfica
            gui.showGUI();
        });
    }
}
