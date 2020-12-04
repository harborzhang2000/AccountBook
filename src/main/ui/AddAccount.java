package ui;

import model.Account;
import model.AccountList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import static ui.MusicPlayer.*;

//This class represents adding a new account to the AccountBook.
//A new window is expected to show up and the users can add the amount,
//year, month day, and descriptions of this account.
public class AddAccount implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private AccountList accountList;
    private JTable table;
    public  AccountBook accountBook;
    private JButton button;
    private JScrollPane scrollPane;
    private Object[] object = {"", "", "", "", ""};
    private final String[] columnNames = {"Amount", "Year", "Month", "Day", "Description"};
    private DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);



    //Constructor of Add Account
    public AddAccount(AccountList accountList, AccountBook accountBook) {
        frame = new JFrame();
        panel = new JPanel();
        this.accountList = accountList;
        this.accountBook = accountBook;
        setupButton();
        setupTable();
        setupPanel();
        setupFrame();
    }

    //EFFECTS: set up button for the AddAccount
    private void setupButton() {
        button = new JButton("Add");
        button.addActionListener(this);
    }

    //EFFECTS: set up frame for the AddAccount
    private void setupFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Add Account");
        frame.setSize(600, 300);
        frame.setVisible(true);

    }

    //EFFECTS: set up panel for the AddAccount
    private void setupPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(scrollPane);
        panel.add(button);
    }

    //EFFECTS: set up the table for AddAccount
    private void setupTable() {
        tableModel.addRow(object);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(20, 10));
    }

    //MODIFIES: this
    //EFFECTS: perform this method
    @Override
    public void actionPerformed(ActionEvent e) {
        new MusicPlayer(ROOSTER_FILE);
        double amount = Double.parseDouble(String.valueOf(table.getValueAt(0, 0)));
        int year = Integer.parseInt(String.valueOf(table.getValueAt(0, 1)));
        int month = Integer.parseInt(String.valueOf(table.getValueAt(0, 2)));
        int day = Integer.parseInt(String.valueOf(table.getValueAt(0, 3)));
        String description = String.valueOf(table.getValueAt(0, 4));
        Account account = new Account(amount, year, month, day, description);

        accountBook.removeTable();
        accountList.addAccount(account);
        accountBook.fillTableModel(accountList.getAccounts());
        JOptionPane popup = new JOptionPane();
        popup.showMessageDialog(frame, new JLabel(new ImageIcon("./data/Coins.jpg")));
        frame.dispose();

    }
}
