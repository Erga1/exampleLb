import javax.swing.*;
import java.awt.*;

public class AboutTab extends JPanel {
    public AboutTab() {
        setLayout(new BorderLayout());

        JTextArea aboutTextArea = new JTextArea();
        aboutTextArea.setEditable(false);
        aboutTextArea.setLineWrap(true);
        aboutTextArea.setWrapStyleWord(true);

        String aboutText = "Library Management System\n\n" +
                "This system is designed to manage books and borrowers in a library. It has three main tabs: Available Books,  Account, and about.\n" +
                "The Available Books tab displays a list of available books, and the Account tab displays account information, and about tab displays about the system and the developer.\n" +
                "The system also has a Return Book feature that allows users to return borrowed books.\n\n" +
                "Developed by:\n" +
                "Abdisa Gebi, ugr/30019/15, Section 1\n" +
                "Bekam Birhanu, ugr/30252/15, Section 1\n" +
                "Ergabus Hirpha, ugr/30475/15, Section 1\n" +
                "Mahfuz Redwan, ugr/30846/15, Section 1\n" +
                "Negasa Reta, ugr/31072/15, Section 1\n" +
                "Segni Merga, ugr/31202/15, Section 1";
        aboutTextArea.setText(aboutText);
        add(new JScrollPane(aboutTextArea), BorderLayout.CENTER);
    }
}