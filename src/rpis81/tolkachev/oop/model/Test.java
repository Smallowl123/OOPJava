package rpis81.tolkachev.oop.model;

public class Test {
    public static void main(String[] args) {
    lab3test();
    }
    public static void lab3test(){
        System.out.println("Создаем 3 сервиса: 2 интернета и один мобильный");
        Service XXLInternet = new Service();
        Service XLInternet = new Service("Интернет 75мб/с", 200, ServiceTypes.INTERNET);
        Service SMSMobile = new Service("500 SMS", 50, ServiceTypes.PHONE);

        System.out.println("Создаем 3 тарифа для разных типов пользователей с разным составом сервисов");

        Tariff entityTariffSMSInternet = new EntityTariff();
        entityTariffSMSInternet.add(XXLInternet);
        entityTariffSMSInternet.add(SMSMobile);

        Tariff entityTariffSMSweakInternet = new EntityTariff();
        entityTariffSMSweakInternet.add(XLInternet);
        entityTariffSMSweakInternet.add(SMSMobile);

        Tariff individualWithTwoInternets = new IndividualsTariff();
        individualWithTwoInternets.add(XLInternet);
        individualWithTwoInternets.add(XXLInternet);

        System.out.println("Получаем из тарифа с одним мобильным сервисом все мобильные сервисы");
        System.out.println(entityTariffSMSInternet.getServices(ServiceTypes.PHONE)[0].getName());

        System.out.println("Получаем из тарифа с двумя интернетами все интернет сервисы");
        System.out.println(individualWithTwoInternets.getServices(ServiceTypes.INTERNET)[0].getName());
        System.out.println(individualWithTwoInternets.getServices(ServiceTypes.INTERNET)[1].getName());

        System.out.println("Создаем 3 счета с разными типами и тарифами");
        Account firstIndividual = new IndividualAccount(0, new Person("fName0","sName0"), individualWithTwoInternets);
        Account firstEntity = new EntityAccount(1, "firstEntity", entityTariffSMSInternet);
        Account secondEntity = new EntityAccount(2, "secondEntity", entityTariffSMSweakInternet);

        System.out.println("Создаем аккаунт менеджера");
        AccountsManager Me = new AccountsManager(3);
        Me.add(firstIndividual);
        Me.add(firstEntity);
        Me.add(secondEntity);

        System.out.println("Выводим все номера счетов с мобильным сервисом в тарифе");
        System.out.println(Me.getAccounts(ServiceTypes.PHONE)[0].getNumber());
        System.out.println(Me.getAccounts(ServiceTypes.PHONE)[1].getNumber());

        System.out.println("Выводим все номера счетов физических лиц");
        System.out.println(Me.getIndividualAccounts()[0].getNumber());

        System.out.println("Выводим все номера счетов юридических лиц");
        System.out.println(Me.getEntityAccounts()[0].getNumber());
        System.out.println(Me.getEntityAccounts()[1].getNumber());







    }
}

