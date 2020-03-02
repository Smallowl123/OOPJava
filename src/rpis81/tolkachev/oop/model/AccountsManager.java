package rpis81.tolkachev.oop.model;

public class AccountsManager {
    private int count = 0;
    Account[] accounts;
    //Конструкторы
    public AccountsManager (int size){
        accounts = new Account[size];
    }
    public AccountsManager (Account[] array){
        accounts = array;
        for (Account account : accounts) {
            if (account != null) {
                count++;
            }
        }
    }
    //Методы
    public void increase () {               //Увеличить массив
        if (count == accounts.length) {
            Account[] increasedAccounts = new Account[accounts.length * 2];
            System.arraycopy(accounts, 0, increasedAccounts, 0, accounts.length);
            accounts = increasedAccounts;
        }
    }

    public boolean add (Account account) {
        increase();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                count++;
                break;
            }
        }
        return(true);
    }

    public boolean add (int index, Account account) {
        increase();
        if (accounts[index] == null) {
            accounts[index] = account;
            count++;
        }
        return(true);
    }

    public Account get (int index){
        return (accounts[index]);
    }

    public Account set (int index, Account account) {
        Account replacedAccount = accounts[index];
        accounts[index] = account;
        return (replacedAccount);
    }

    public void makeArrayContinuityAgain () {               //Дефрагментатор
        Account[] newArray = new Account[accounts.length];
        int index = 0;
        for (Account account : accounts) {
            if (account != null) {
                newArray[index] = account;
                index++;
            }
        }
        accounts = newArray;
    }

    public Account remove (int index) {
        Account removedAccount = accounts[index];
        accounts[index] = null;
        makeArrayContinuityAgain();
        count--;
        return (removedAccount);
    }

    public int size() {
        return (count);
    }

    public Account[] getAccounts() {
        Account[] getAccountsArray = new Account[count];
        int index = 0;
        for (Account account : accounts) {
            if (account != null) {
                getAccountsArray[index] = account;
                index++;
            }
        }
        return (getAccountsArray);
    }

    public IndividualsTariff getTariff (long accountNumber) {
        for (Account account : accounts) {
            if (account.number == accountNumber) {
                return account.tariff;
            }
        }
        return (new IndividualsTariff());
    }

    public IndividualsTariff setTariff (long accountNumber, IndividualsTariff tariff) {
        for (Account account : accounts) {
            if (account.number == accountNumber) {
                IndividualsTariff replacedTariff = account.tariff;
                account.tariff = tariff;
                tariff = replacedTariff;
            }
        }
        return (tariff);
    }
}
