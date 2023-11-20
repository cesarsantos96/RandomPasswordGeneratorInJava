import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PasswordGeneratorGUI {
    private JFrame frame;
    private JButton generateButton;
    private JTextArea passwordTextArea;
    private JTextField utilityTextField; // Novo campo para a utilidade

    private PasswordGenerator generator;

    public PasswordGeneratorGUI(PasswordGenerator generator) {
        this.generator = generator;

        frame = new JFrame("Password Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        generateButton = new JButton("Gerar Senha");
        passwordTextArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(passwordTextArea);

        utilityTextField = new JTextField();
        utilityTextField.setPreferredSize(new Dimension(200, 30)); // Defina o tamanho desejado

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String utility = utilityTextField.getText();
                String passwordGenerated = generator.generatePassword();
                passwordTextArea.setText("Utilidade: " + utility + "\nSenha: " + passwordGenerated);
                savePasswordToFile(utility, passwordGenerated, "senhas.txt");
            }
        });

        frame.add(new JLabel("Utilidade:")); // Rótulo para o campo de texto
        frame.add(utilityTextField);
        frame.add(generateButton);
        frame.add(scrollPane);
    }

    private void savePasswordToFile(String utility, String password, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Utilidade: " + utility + "\nSenha: " + password);
            writer.newLine();
            writer.newLine(); // Adicione uma linha em branco entre as senhas
            System.out.println("Senha salva com sucesso no arquivo: " + filename);
        } catch (IOException e) {
            System.err.println("Erro ao salvar a senha no arquivo: " + e.getMessage());
        }
    }

    public void showGUI() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
}
