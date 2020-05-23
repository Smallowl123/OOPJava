package rpis81.tolkachev.oop.model;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountsManager implements java.lang.Iterable<Account> {
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

    public boolean add (Account account) throws DublicateAccountNumberException {
        if(isExists(account))
            throw new DublicateAccountNumberException("Аккаунт с таким номером уже существует");
        increase();
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = Objects.requireNonNull(account,"Значение account не должно быть Null");;
                count++;
                break;
            }
        }
        return(true);
    }

    public boolean add (int index, Account account) throws DublicateAccountNumberException {
        if (index < 0 && index >= accounts.length){
            throw new IllegalAccountNumberException("Недопустимый индекс элемента");
        }
        if(isExists(account))
            throw new DublicateAccountNumberException("Аккаунт с таким номером уже существует");
        increase();
        if (accounts[index] == null) {
            accounts[index] = Objects.requireNonNull(account,"Значение account не должно быть Null");
            count++;
        }
        return(true);
    }

    public Account get (int index){
        if (index < 0 && index >= accounts.length){
            throw new IllegalAccountNumberException("Недопустимый индекс элемента");
        }
        return (accounts[index]);
    }

    public Account set (int index, Account account) throws DublicateAccountNumberException {
        if (index < 0 && index >= accounts.length){
            throw new IllegalAccountNumberException("Недопустимый индекс элемента");
        }
        if(isExists(account))
            throw new DublicateAccountNumberException("Аккаунт с таким номером уже существует");
        Account replacedAccount = accounts[index];
        accounts[index] = Objects.requireNonNull(account,"Значение account не должно быть Null");
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
        if (index < 0 && index >= accounts.length){
            throw new IllegalAccountNumberException("Недопустимый индекс элемента");
        }
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
        if (!isProperNumber(accountNumber)){
            throw new IllegalAccountNumberException("Неверный формат номера");
        }
        else
        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                return account.getTariff();
            }
        }return new IndividualsTariff();
    }

    public Tariff setTariff (long accountNumber, IndividualsTariff tariff) {
        if (!isProperNumber(accountNumber)){
            throw new IllegalAccountNumberException("Неверный формат номера");
        }
        for (Account account : accounts) {
            if (account.getNumber() == accountNumber) {
                Tariff replacedTariff = account.getTariff();
                account.setTariff(Objects.requireNonNull(tariff,"Значение tariff не должно быть Null"));
                return replacedTariff;
            }
        } return new IndividualsTariff();
    }

    public Account[] getAccounts (ServiceTypes serviceType){
        Account[] getAccountsArray = new Account[count];
        int index = 0;
        for (Account account : accounts){
            for (Service service: account.getTariff().getServices()){
                if (service.getType() == Objects.requireNonNull(serviceType,"Значение serviceType не должно быть Null")){
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
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        iterator().forEachRemaining(account ->
        {
            builder.append(account.toString());
            builder.append("\n");
        });
        return builder.toString();
    }


    public boolean remove (Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].equals(Objects.requireNonNull(account,"Значение account не должно быть Null"))) {
                accounts[i] = null;
                count--;
                makeArrayContinuityAgain();
                return true;
            }
        }
        return false;
    }


    public int indexOf (Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null){
                if (accounts[i].equals(Objects.requireNonNull(account,"Значение account не должно быть Null"))) {
                    return i;
                }
            }
        }
        return accounts.length * 10;
    }


    public int lastIndexOf (Account account) {
        int last = accounts.length * 10;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null){
                if (accounts[i].equals(Objects.requireNonNull(account,"Значение account не должно быть Null"))) {
                    last = i;
                }
            }
        }
        return last;
    }

    private boolean isProperNumber (long number){
        Pattern pattern = Pattern.compile("^\\d{1,15}$");
        String strNumber = Long.toString(number);
        Matcher matcher = pattern.matcher(strNumber);
        return matcher.find();
    }
    public boolean isExists (Account account){
        for(Account accountFromArray: accounts){
            if (accountFromArray!=null){
                if(accountFromArray.getNumber() == account.getNumber()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<Account> iterator() {
        return new AccountIterator(getAccounts());
    }

    private static class AccountIterator implements java.util.Iterator<Account> {

        private int index;
        private final Account[] accounts;
        private final int defaultIndex = 0;


        public AccountIterator (Account[] arrayOfAccounts) {
            accounts = arrayOfAccounts;
            index = defaultIndex;
        }

        public boolean hasNext() {
            return index < accounts.length;
        }

        @Override
        public Account next() {
            if(hasNext()) {
                return accounts[index++];
            }
            throw new NoSuchElementException("Элементов больше не осталось");
        }
    }
}
