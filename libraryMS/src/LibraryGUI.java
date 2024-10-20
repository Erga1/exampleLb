import javax.swing.*;
import java.awt.*;

public class LibraryGUI {
    private JFrame frame;
    private JTabbedPane mainTabbedPane;

    public LibraryGUI() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        mainTabbedPane = new JTabbedPane();
        mainTabbedPane.addTab("Book", new BookTab());
        mainTabbedPane.addTab("Account", new AccountTab());
        mainTabbedPane.addTab("About", new AboutTab());

        frame.add(mainTabbedPane, BorderLayout.CENTER);
        frame.setSize(1400, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}