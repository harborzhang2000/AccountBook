package ui;

import model.AccountList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.MusicPlayer.NIGHTINGALE_FILE;

//This class represents calculating the overall balance of the accounts.
//A new window is expected to show up and there is a button allows users to
//compute the balance.
public class BalanceAccount implements ActionListener {

    JFrame frame;
    JButton button;
    AccountBook accountBook;
    AccountList accountList;
    JPanel panel;
    JLabel balance;

    // Constructor of Balance Account
    public BalanceAccount(AccountBook accountBook) {
        frame = new JFrame();
        panel = new JPanel();
        this.accountBook = accountBook;
        this.accountList = accountBook.getAccountList();
        setupObjects();
        setupPanels();
        addToPanel();
        setupFrame();
    }

    // EFFECTS: set up objects
    public void setupObjects() {
        button = new JButton("Balance!");
        button.addActionListener(this);
        balance = new JLabel("The Balance: $0.0 ");

    }

    // EFFECTS: add Jlabel and Jbutton to the panel
    public void addToPanel() {
        panel.add(balance, BorderLayout.NORTH);
        panel.add(button, BorderLayout.SOUTH);
    }

    // EFFECTS: set up panels
    public void setupPanels() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0,1));
    }

    // EFFECTS: set up frame
    public void setupFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(500, 250);
        frame.setTitle("Balance of Account");
    }


    //MODIFIES: this
    //EFFECTS: compute the total balance of all the accounts
    @Override
    public void actionPerformed(ActionEvent e) {
        new MusicPlayer(NIGHTINGALE_FILE);
        balance.setText("The Balance: $" + accountList.balanceAccount());
    }
}
