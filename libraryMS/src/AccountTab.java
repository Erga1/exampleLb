import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountTab extends JPanel {
    public AccountTab() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1400, 300)); // set preferred size

        JPanel accountInfoPanel = new JPanel();
        accountInfoPanel.setLayout(new GridLayout(0, 2, 20, 20)); // adjusted gaps between components

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
        JTextField usernameField = new JTextField("Admin");
        usernameField.setEditable(false);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setPreferredSize(new Dimension(400, 40)); 

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18)); 
        JPasswordField passwordField = new JPasswordField("admin");
        passwordField.setEditable(false);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18)); 
        passwordField.setPreferredSize(new Dimension(400, 40)); 

        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(new Font("Arial", Font.PLAIN, 18)); 
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18)); // increased font size
        JTextField nameField = new JTextField("Admin User");
        nameField.setEditable(false);
        nameField.setFont(new Font("Arial", Font.PLAIN, 18)); 
        nameField.setPreferredSize(new Dimension(400, 40)); 
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField emailField = new JTextField("admin@gmail.com");
        emailField.setEditable(false);
        emailField.setFont(new Font("Arial", Font.PLAIN, 18)); 
        emailField.setPreferredSize(new Dimension(400, 40)); 

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField phoneNumberField = new JTextField("+251-9456-58980");
        phoneNumberField.setEditable(false);
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setPreferredSize(new Dimension(400, 40)); 

        accountInfoPanel.add(usernameLabel);
        accountInfoPanel.add(usernameField);
        accountInfoPanel.add(passwordLabel);
        accountInfoPanel.add(passwordField);
        accountInfoPanel.add(showPasswordCheckBox);
        accountInfoPanel.add(new JLabel()); // empty label to balance the grid
        accountInfoPanel.add(nameLabel);
        accountInfoPanel.add(nameField);
        accountInfoPanel.add(emailLabel);
        accountInfoPanel.add(emailField);
        accountInfoPanel.add(phoneNumberLabel);
        accountInfoPanel.add(phoneNumberField);

        add(accountInfoPanel, BorderLayout.CENTER);
    }
}