import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class BookTab extends JPanel {
    private JPanel availableBookPanel;
    private JPanel borrowedBookPanel;
    private JPanel borrowBookPanel;
    private JTabbedPane bookTabbedPane;

    // Available Book Panel
    private JTable availableBookTable;
    private DefaultTableModel availableBookTableModel;

    public BookTab() {
        setLayout(new BorderLayout());

        // Create main tabbed pane
        bookTabbedPane =new JTabbedPane();
        bookTabbedPane.addTab("Available Book", createAvailableBookPanel());
        bookTabbedPane.addTab("Borrowed Book", createBorrowedBookPanel());
        bookTabbedPane.addTab("Borrow Book", createBorrowBookPanel());

        // Set default tab to Book
        bookTabbedPane.setSelectedIndex(0);

        // Add main tabbed pane to frame
        add(bookTabbedPane, BorderLayout.CENTER);
    }

    // Create Available Book Panel
    private JPanel createAvailableBookPanel() {
        availableBookPanel =new JPanel();
        availableBookPanel.setLayout(new BorderLayout());
    
        // Create table model
        availableBookTableModel =new DefaultTableModel();
        availableBookTableModel.addColumn("Name");
        availableBookTableModel.addColumn("ISBN");
        availableBookTableModel.addColumn("Quantity");
    
        // Read from avbk.txt file
        try (BufferedReader reader =new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\libraryMS\\src\\avbk.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                availableBookTableModel.addRow(new Object[] {bookData[0], bookData[1], bookData[2]});
            }
        } catch (FileNotFoundException a) {
            System.err.println("Error: File not found");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    
        // Create table
        availableBookTable =new JTable(availableBookTableModel);
        availableBookPanel.add(new JScrollPane(availableBookTable), BorderLayout.CENTER);
        // Create Refresh Button
        JButton refreshButton =new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAvailableBookTable();
            }
        });
    
        // Add Refresh Button to Panel
        JPanel buttonPanel =new JPanel();
        buttonPanel.add(refreshButton);
        availableBookPanel.add(buttonPanel, BorderLayout.SOUTH);
    
        return availableBookPanel;
    }
    
    // Method to Update Available Book Table
    private void updateAvailableBookTable() {
        // Clear Table Model
        availableBookTableModel.setRowCount(0);
    
        // Read from avbk.txt file
        try (BufferedReader reader =new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\libraryMS\\src\\avbk.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                availableBookTableModel.addRow(new Object[] {bookData[0], bookData[1], bookData[2]});
            }
        } catch (IOException ex) {
            System.err.println("Error reading from file: " + ex.getMessage());
        }
    }

    // Create Borrowed Book Panel
    private JPanel createBorrowedBookPanel() {
        borrowedBookPanel =new JPanel();
        borrowedBookPanel.setLayout(new BorderLayout());
    
        // Create table model
        DefaultTableModel borrowedBookTableModel =new DefaultTableModel();
        borrowedBookTableModel.addColumn("Name");
        borrowedBookTableModel.addColumn("ID");
        borrowedBookTableModel.addColumn("Phone Number");
        borrowedBookTableModel.addColumn("Book Name");
        borrowedBookTableModel.addColumn("Book ISBN");
        borrowedBookTableModel.addColumn("Return Date");
    
        // Read from brw.txt file
        try (BufferedReader reader =new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\libraryMS\\src\\brw.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] borrowedBookData = line.split(",");
                borrowedBookTableModel.addRow(new Object[] {borrowedBookData[0], borrowedBookData[1], borrowedBookData[2], borrowedBookData[3], borrowedBookData[4], borrowedBookData[5]});
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    
        // Create table
        JTable borrowedBookTable =new JTable(borrowedBookTableModel);
    
        // Add table to panel
        borrowedBookPanel.add(new JScrollPane(borrowedBookTable), BorderLayout.CENTER);
    
        // Create Refresh Button
        JButton refreshButton =new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBorrowedBookTable(borrowedBookTableModel, borrowedBookTable);
            }
        });
    
        // Add Refresh Button to Panel
        JPanel buttonPanel =new JPanel();
        buttonPanel.add(refreshButton);
        borrowedBookPanel.add(buttonPanel, BorderLayout.SOUTH);
    
        // Create return book subtab
        JTabbedPane borrowedBookSubTabbedPane =new JTabbedPane();
        borrowedBookSubTabbedPane.addTab("Borrowed Books", borrowedBookPanel);
        borrowedBookSubTabbedPane.addTab("Return Book", createReturnBookPanel());
    
        // Add subtab to panel
        borrowedBookPanel =new JPanel();
        borrowedBookPanel.setLayout(new BorderLayout());
        borrowedBookPanel.add(borrowedBookSubTabbedPane, BorderLayout.CENTER);
    
        return borrowedBookPanel;
    }
    
    // Method to Update Borrowed Book Table
    private void updateBorrowedBookTable(DefaultTableModel borrowedBookTableModel, JTable borrowedBookTable) {
        // Clear Table Model
        borrowedBookTableModel.setRowCount(0);
    
        // Read from brw.txt file
        try (BufferedReader reader =new BufferedReader(new FileReader("C:\\Users\\HP\\Downloads\\libraryMS\\src\\brw.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] borrowedBookData = line.split(",");
                borrowedBookTableModel.addRow(new Object[] {borrowedBookData[0], borrowedBookData[1], borrowedBookData[2], borrowedBookData[3], borrowedBookData[4], borrowedBookData[5]});
            }
        } catch (IOException ex) {
            System.err.println("Error reading from file: " + ex.getMessage());
        }
    }

    // Create Return Book Panel
    private JPanel createReturnBookPanel() {
        JPanel returnBookPanel =new JPanel();
        returnBookPanel.setLayout(new BorderLayout());

        // Create search panel
        JPanel searchPanel =new JPanel();
        searchPanel.setLayout(new FlowLayout());

        JLabel nameLabel =new JLabel("Borrower Name:");
        JTextField nameTextField =new JTextField(20);

        JLabel idLabel =new JLabel("Borrower ID:");
        JTextField idTextField =new JTextField(20);

        JButton searchButton =new JButton("Search");
        searchButton.addActionListener(new ReturnBookButtonListener(nameTextField, idTextField));

        searchPanel.add(nameLabel);
        searchPanel .add(nameTextField);
        searchPanel.add(idLabel);
        searchPanel.add(idTextField);
        searchPanel.add(searchButton);

        returnBookPanel.add(searchPanel, BorderLayout.NORTH);

        return returnBookPanel;
    }

    // Create Borrow Book Panel
    private JPanel createBorrowBookPanel() {
        borrowBookPanel =new JPanel();
        borrowBookPanel.setLayout(new BorderLayout());
    
    
        // Create search panel
    
        JPanel searchPanel =new JPanel();
    
        searchPanel.setLayout(new FlowLayout());
    
        JLabel nameLabel =new JLabel("Borrower Name:");
        JTextField nameTextField =new JTextField(20);
        JLabel idLabel =new JLabel("Borrower ID:");
        JTextField idTextField =new JTextField(20);
        JLabel phoneLabel =new JLabel("Phone Number:");
        JTextField phoneTextField =new JTextField(20);
        JLabel bookLabel =new JLabel("Book Name:");
        JTextField bookTextField =new JTextField(20);
        JButton borrowButton =new JButton("Borrow");
        borrowButton.addActionListener(new BorrowBookButtonListener(nameTextField, idTextField, phoneTextField, bookTextField));
    
        searchPanel.add(nameLabel);
        searchPanel.add(nameTextField);
        searchPanel.add(idLabel);
        searchPanel.add(idTextField);
        searchPanel.add(phoneLabel);
        searchPanel.add(phoneTextField);
        searchPanel.add(bookLabel);
        searchPanel.add(bookTextField);
        searchPanel.add(borrowButton);
    
    
        borrowBookPanel.add(searchPanel, BorderLayout.NORTH);
    
    
        return borrowBookPanel;
    
    }

    // ActionListener for Return Book Button
private class ReturnBookButtonListener implements ActionListener {

    private JTextField nameTextField;
    private JTextField idTextField;

    public ReturnBookButtonListener(JTextField nameTextField, JTextField idTextField) {
        this.nameTextField = nameTextField;
        this.idTextField = idTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String borrowerName = nameTextField.getText();
        String borrowerID = idTextField.getText();

        // Search for borrower in brw.txt file
        try {
            File brwFile =new File("C:\\Users\\HP\\Downloads\\libraryMS\\src\\brw.txt");
            File tempBrwFile =new File("C:\\Users\\HP\\Downloads\\libraryMS\\src\\tempBrw.txt");

            BufferedReader reader =new BufferedReader(new FileReader(brwFile));
            BufferedWriter writer =new BufferedWriter(new FileWriter(tempBrwFile));

            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] borrowedBookData = line.split(",");
                if (borrowedBookData[0].equals(borrowerName) && borrowedBookData[1].equals(borrowerID)) {
                    found = true;

                    // Ask for confirmation
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to return the book?");
                    if (response == JOptionPane.YES_OPTION) {
                        // Add book to avbk.txt file
                        addBookToAvbk(borrowedBookData);
                    } else {
                        writer.write(line + "\n");
                    }
                } else {
                    writer.write(line + "\n");
                }
            }
            reader.close();
            writer.close();

            // Replace brw.txt with tempBrw.txt
            brwFile.delete();
            tempBrwFile.renameTo(brwFile);

            if (!found) {
                // Display error message if borrower not found
                JOptionPane.showMessageDialog(null, "Borrower not found.");
            }
        } catch (IOException ex) {
            System.err.println("Error reading from file: " + ex.getMessage());
        }
    }

    private void addBookToAvbk(String[] borrowedBookData) {
        try {
            File avbkFile =new File("C:\\Users\\HP\\Downloads\\libraryMS\\src\\avbk.txt");
            File tempAvbkFile =new File("C:\\Users\\HP\\Downloads\\libraryMS\\src\\tempAvbk.txt");

            BufferedReader reader =new BufferedReader(new FileReader(avbkFile));
            BufferedWriter writer =new BufferedWriter(new FileWriter(tempAvbkFile));

            String line;
            boolean bookFound = false;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData[0].equals(borrowedBookData[3])) {
                    bookFound = true;
                    int quantity = Integer.parseInt(bookData[2]) + 1;
                    writer.write(bookData[0] + "," + bookData[1] + "," + quantity + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }
            if (!bookFound) {
                writer.write(borrowedBookData[3] + "," + borrowedBookData[4] + ",1\n");
            }
            reader.close();
            writer.close();

            // Replace avbk.txt with tempAvbk.txt
            avbkFile.delete();
            tempAvbkFile.renameTo(avbkFile);
        } catch (IOException ex) {
            System.err.println("Error reading from file: " + ex.getMessage());
        }
    }
}

    // ActionListener for Borrow Book Button
private class BorrowBookButtonListener implements ActionListener {

    private JTextField nameTextField;
    private JTextField idTextField;
    private JTextField phoneTextField;
    private JTextField bookTextField;

    public BorrowBookButtonListener(JTextField nameTextField, JTextField idTextField, JTextField phoneTextField, JTextField bookTextField) {
        this.nameTextField = nameTextField;
        this.idTextField = idTextField;
        this.phoneTextField = phoneTextField;
        this.bookTextField = bookTextField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String borrowerName = nameTextField.getText();
        String borrowerID = idTextField.getText();
        String phoneNumber = phoneTextField.getText();
        String bookName = bookTextField.getText();

        // Search for book in avbk.txt file
        try {
            File avbkFile =new File("C:\\Users\\HP\\Downloads\\libraryMS\\src\\avbk.txt");
            File tempAvbkFile =new File("C:\\Users\\HP\\Downloads\\libraryMS\\src\\tempAvbk.txt");

            BufferedReader reader =new BufferedReader(new FileReader(avbkFile));
            BufferedWriter writer =new BufferedWriter(new FileWriter(tempAvbkFile));

            String line;
            boolean found = false;
            String[] bookData = null;
            while ((line = reader.readLine()) != null) {
                bookData = line.split(",");
                if (bookData[0].equals(bookName)) {
                    found = true;

                    // Ask for return date
                    String returnDate = JOptionPane.showInputDialog("Enter return date (yyyy-mm-dd):");

                    // Ask for confirmation
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to borrow the book?");
                    if (response == JOptionPane.YES_OPTION) {
                        int quantity = Integer.parseInt(bookData[2]);
                        if (quantity > 1) {
                            // Decrease quantity by 1
                            writer.write(bookData[0] + "," + bookData[1] + "," + (quantity - 1) + "\n");
                        } else {
                            // Remove book from avbk.txt file
                            continue;
                        }
                    } else {
                        writer.write(line + "\n");
                    }
                } else {
                    writer.write(line + "\n");
                }
            }
            reader.close();
            writer.close();

            // Replace avbk.txt with tempAvbk.txt
            avbkFile.delete();
            tempAvbkFile.renameTo(avbkFile);

            if (found) {
                // Add borrower to brw.txt file
                try (BufferedWriter brwWriter =new BufferedWriter(new FileWriter("C:\\Users\\HP\\Downloads\\libraryMS\\src\\brw.txt", true))) {
                    brwWriter.write(borrowerName + "," + borrowerID + "," + phoneNumber + "," + bookName + "," + bookData[1] + "," + JOptionPane.showInputDialog("Enter return date (yyyy-mm-dd):") + "\n");
                } catch (IOException ex) {
                    System.err.println("Error writing to file: " + ex.getMessage());
                }
            }

            if (!found) {
                // Display error message if book not found
                JOptionPane.showMessageDialog(null, "Book not found.");
            }
        } catch (IOException ex) {
            System.err.println("Error reading from file: " + ex.getMessage());
        }
    }
}
}