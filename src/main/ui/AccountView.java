package ui;

import model.AccountList;

//This class represents the view of the account, where the users can not operate the account
//but view the overall account and quit the application. It is a subclass of the AccountBook.
public class AccountView extends AccountBook {


    //Constructor
    public AccountView(AccountBook accountBook) {
        super();
        AccountList accountList = accountBook.getAccountList();
        fillTableModel(accountList.getAccounts());
        accountBook.getDelete().setVisible(false);
        accountBook.getSave().setVisible(false);
        accountBook.getAdd().setVisible(false);
        accountBook.getLoad().setVisible(false);
        accountBook.getView().setVisible(false);
        accountBook.getBalance().setVisible(false);
        accountBook.getQuit().setVisible(true);
        frame.dispose();
    }
}

