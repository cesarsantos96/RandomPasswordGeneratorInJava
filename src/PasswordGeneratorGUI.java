import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordGeneratorGUI {
    private JFrame frame;
    private JButton generateButton;
    private JTextArea passwordTextArea;

    private PasswordGenerator generator;

    public PasswordGeneratorGUI(PasswordGenerator generator) {
        this.generator = generator;

        frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        generateButton = new JButton("Gerar Senha");
        passwordTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(passwordTextArea);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwordGenerated = generator.generatePassword();
                passwordTextArea.setText(passwordGenerated);
                savePasswordToFile(passwordGenerated, "senhas.txt");
            }
        });

        frame.add(generateButton);
        frame.add(scrollPane);
    }

    public void showGUI() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    private void savePasswordToFile(String password, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(password);
            writer.newLine();
            System.out.println("Senha salva com sucesso no arquivo: " + filename);
        } catch (IOException e) {
            System.err.println("Erro ao salvar a senha no arquivo: " + e.getMessage());
        }
    }
}
