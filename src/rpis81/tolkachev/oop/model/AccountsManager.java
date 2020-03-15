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

    public Tariff getTariff (long accountNumber) {
        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                return account.getTariff();
            }
        }return new IndividualsTariff();
    }

    public Tariff setTariff (long accountNumber, IndividualsTariff tariff) {
        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                Tariff replacedTariff = account.getTariff();
                account.setTariff(tariff);
                return replacedTariff;
            }
        } return new IndividualsTariff();
    }

    public Account[] getAccounts (ServiceTypes serviceType){
        Account[] getAccountsArray = new Account[count];
        int index = 0;
        for (Account account : accounts){
            for (Service service: account.getTariff().getServices()){
                if (service.getType() == serviceType){
                    getAccountsArray[index] = account;
                    index++;
                }
            }
        }
        Account[] shortArray = new Account[index];
        System.arraycopy(getAccountsArray, 0, shortArray, 0, index);
        return shortArray;
    }

    public Account[] getIndividualAccounts(){
        Account[] getAccountsArray = new Account[count];
        int index = 0;
        for (Account account : accounts){
            if (account instanceof IndividualAccount){
                getAccountsArray[index] = account;
                index++;
            }
        }
        Account[] shortArray = new Account[index];
        System.arraycopy(getAccountsArray, 0, shortArray, 0, index);
        return shortArray;
    }

    public Account[] getEntityAccounts(){
        Account[] getAccountsArray = new Account[count];
        int index = 0;
        for (Account account : accounts){
            if (account instanceof EntityAccount){
                getAccountsArray[index] = account;
                index++;
            }
        }
        Account[] shortArray = new Account[index];
        System.arraycopy(getAccountsArray, 0, shortArray, 0, index);
        return shortArray;
    }
}
