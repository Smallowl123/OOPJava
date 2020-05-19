package rpis81.tolkachev.oop.model;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException, DublicateAccountNumberException {
    lab5test();
    }
    public static void lab5test() throws CloneNotSupportedException, DublicateAccountNumberException {
        System.out.println("Создаем 3 сервиса: 2 интернета и один мобильный");
        Service XXLInternet = new Service();
        Service XLInternet = new Service("Интернет 75мб/с", 200, ServiceTypes.INTERNET, LocalDate.of(2009,12,3));
        Service SMSMobile = new Service("500 SMS", 50, ServiceTypes.PHONE, LocalDate.of(2019,11,29));

        System.out.println("Создаем 3 тарифа для разных типов пользователей с разным составом сервисов");

        Tariff entityTariffSMSInternet = new EntityTariff();
        entityTariffSMSInternet.add(XXLInternet);
        entityTariffSMSInternet.add(SMSMobile);

        Tariff entityTariffSMSWeakInternet = new EntityTariff();
        entityTariffSMSWeakInternet.add(XLInternet);
        entityTariffSMSWeakInternet.add(SMSMobile);

        Tariff individualWithTwoInternets = new IndividualsTariff();
        individualWithTwoInternets.add(XLInternet);
        individualWithTwoInternets.add(XXLInternet);

        System.out.println("Создаем 3 счета с разными типами и тарифами");
        Account firstIndividual = new IndividualAccount(0, new Person("fName0","sName0"), individualWithTwoInternets, LocalDate.now());
        Account firstEntity = new EntityAccount(1, "firstEntity", entityTariffSMSInternet, LocalDate.now());
        Account secondEntity = new EntityAccount(2, "secondEntity", entityTariffSMSWeakInternet, LocalDate.now());

        System.out.println("Создаем аккаунт менеджера");
        AccountsManager Me = new AccountsManager(3);
        Me.add(firstIndividual);
        Me.add(firstEntity);
        Me.add(secondEntity);
        System.out.println(Me.toString());

        System.out.println(individualWithTwoInternets.hashCode());
        System.out.println(entityTariffSMSWeakInternet.hashCode());
        System.out.println(Me.hashCode());

        System.out.println("Проверяем исключения");
        //Service rrrInternet = new Service(null,500,ServiceTypes.INTERNET,LocalDate.of(1999,12,12));
        //Service rInternet = new Service("Название",-500,ServiceTypes.INTERNET,LocalDate.of(1999,12,12));
        //Service rrInternet = new Service("Название",500,null,LocalDate.of(1999,12,12));
        //Service rRrInternet = new Service("Название",500,ServiceTypes.INTERNET,null);
        //EntityAccount rAcc  = new EntityAccount(4444444,"Ракк",entityTariffSMSInternet,LocalDate.of(2035,12,12));
        //Account sixIndividual = new IndividualAccount(999999*999999*9999999, new Person("fName0","sName0"), individualWithTwoInternets, LocalDate.now());





    }
}

