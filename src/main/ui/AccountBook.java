package ui;

import model.Account;
import model.AccountList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static ui.MusicPlayer.*;

//This class represents the AccountBook where users can operate the AccountBook application
//click buttons to add accounts to the AccountBook, to delete selected accounts, to save and
//load the accounts, to view the accounts and to calculate the balance of the accounts.
public class AccountBook implements ActionListener {
    public JFrame frame;

    private JTable table;

    private JOptionPane popup = new JOptionPane();

    private JScrollPane scrollPane;
    private static final String JSON_STORE = "./data/accounts.json";
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JPanel panelButton;
    private JPanel panelTable;

    private JButton load;
    private JButton add;
    private JButton delete;
    private JButton save;
    private JButton quit;
    private JButton view;
    private JButton balance;

    private AccountList accountList;

    String[] columnNames = {"Number", "Amount", "Year", "Month", "Day", "Description"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

    // Constructor of Account Book
    public AccountBook() {
        super();
        accountList = new AccountList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        input = new Scanner(System.in);
        setupObjects();
        setupActionToButtons();
        setupPanels();
        setupFrame();
    }

    //EFFECTS: save accounts to JSON
    private void saveAccount() {
        try {
            jsonWriter.open();
            jsonWriter.write(accountList);
            jsonWriter.close();
            System.out.println("Saved " + accountList.getAccounts() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }


    //EFFECTS: load accounts from JSON
    private void loadAccount() {
        try {
            accountList = jsonReader.read();
            System.out.println("Loaded " + accountList.getAccounts() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    //EFFECTS: set up the frame for Account Book
    public void setupFrame() {
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelButton, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Account Book");
        frame.setVisible(true);
        frame.setSize(800, 800);
    }

    //EFFECTS: set up panels for Account Book
    public void setupPanels() {
        panelButton.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
        panelButton.setLayout(new GridLayout(1, 0));
        panelButton.add(load);
        panelButton.add(add);
        panelButton.add(delete);
        panelButton.add(view);
        panelButton.add(save);
        panelButton.add(quit);
        panelButton.add(balance);

        panelTable.setBorder(BorderFactory.createEmptyBorder(80, 80, 80, 80));
        panelTable.setLayout(new GridLayout(1, 0));
    }

    //EFFECTS: set up action to the buttons
    public void setupActionToButtons() {
        load.addActionListener(this);
        load.setActionCommand("Load");
        add.addActionListener(this);
        add.setActionCommand("Add");
        delete.addActionListener(this);
        delete.setActionCommand("Delete");
        save.addActionListener(this);
        save.setActionCommand("Save");
        quit.addActionListener(this);
        quit.setActionCommand("Quit");
        view.addActionListener(this);
        view.setActionCommand("View");
        balance.addActionListener(this);
        balance.setActionCommand("Balance");
    }

    //EFFECTS: set up objects
    public void setupObjects() {
        frame = new JFrame();
        table = new JTable(tableModel);
        panelButton = new JPanel();
        panelTable = new JPanel();
        scrollPane = new JScrollPane(table);
        add = new JButton("Add");
        load = new JButton("Load");
        delete = new JButton("Delete");
        save = new JButton("Save");
        quit = new JButton("Quit");
        view = new JButton("View");
        balance = new JButton("Balance");
    }


    //MODIFIES: this
    //EFFECTS: perform add, load, delete, save, quit, view, balance
    // when its button is clicked.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            addMoneyAction();
        } else if (e.getActionCommand().equals("Load")) {
            loadAction();
        } else if (e.getActionCommand().equals("Delete")) {
            deleteAction();
        } else if (e.getActionCommand().equals("Save")) {
            saveAction();
        } else if (e.getActionCommand().equals("Quit")) {
            quitAction();
        } else if (e.getActionCommand().equals("View")) {
            viewAction();
        } else if (e.getActionCommand().equals("Balance")) {
            balanceAction();
        }
    }

    //MODIFIES: this
    //EFFECTS: show a new window to compute the overall balance of the accounts
    private void balanceAction() {
        new MusicPlayer(LION_FILE);
        new BalanceAccount(this);
    }

    //MODIFIES: this
    //EFFECTS: show a new window to give user the account view
    private void viewAction() {
        new MusicPlayer(MOSQUITO_FILE);
        new AccountView(this);
    }

    //MODIFIES: this
    //EFFECTS: quit from the Account Book
    public void quitAction() {
        new MusicPlayer(ELEPHANT_FILE);
        JOptionPane popup = new JOptionPane();
        popup.showMessageDialog(frame, new JLabel(new ImageIcon("./data/have a nice day.jpg")));
        frame.dispose();

    }

    //MODIFIES: this
    //EFFECTS: save the accounts by far
    public void saveAction() {
        new MusicPlayer(HORSE_FILE);
        saveAccount();
    }

    // MODIFIES: this
    // EFFECTS: delete the selected account from the account book
    public void deleteAction() {
        new MusicPlayer(LAMBSOUND_FILE);
        boolean isSelected = false;
        for (int i = 0; i < table.getRowCount(); i++) {
            boolean isSingleSelected = table.isRowSelected(i);
            isSelected = isSingleSelected || isSelected;

        }
        if (!isSelected) {
            popup.showMessageDialog(frame, "please select one account to delete!");
        } else {
            int number = table.getSelectedRow();
            Account accountDeleted = accountList.getAccounts().get(number);
            removeTable();
            accountList.removeAccount(accountDeleted);
            fillTableModel(accountList.getAccounts());
        }
    }


    //MODIFIES: this
    //EFFECTS: print the accounts on the Account Book
    public void fillTableModel(List<Account> accounts) {
        int number = 1;

        for (int i = 0; i < accounts.size(); i++) {
            double amount = accounts.get(i).getAmount();
            int year = accounts.get(i).getYear();
            int month = accounts.get(i).getMonth();
            int day = accounts.get(i).getDay();
            String description = accounts.get(i).getDescription();
            Object[] data = {number, amount, year, month, day, description};
            tableModel.addRow(data);
            number += 1;
        }

    }


    //MODIFIES: this
    //EFFECTS: remove the account from the table
    public void removeTable() {
        for (int i = 0; i < accountList.getAccounts().size(); i++) {
            tableModel.removeRow(0);
        }
    }

    //MODIFIES: this
    //EFFECTS: load the accounts to the account book
    public void loadAction() {
        new MusicPlayer(DOGBARK_FILE);
        loadAccount();
        fillTableModel(accountList.getAccounts());
    }

    //MODIFIES: this
    //EFFECTS: add account to the account book
    public void addMoneyAction() {
        new AddAccount(accountList, this);
    }

    //getters
    public AccountList getAccountList() {
        return accountList;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getQuit() {
        return quit;
    }

    public JButton getSave() {
        return save;
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getLoad() {
        return load;
    }

    public JButton getView() {
        return view;
    }

    public JButton getBalance() {
        return balance;
    }
}
