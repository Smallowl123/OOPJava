package rpis81.tolkachev.oop.model;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
    lab4test();
    }
    public static void lab4test() throws CloneNotSupportedException {
        System.out.println("Создаем 3 сервиса: 2 интернета и один мобильный");
        Service XXLInternet = new Service();
        Service XLInternet = new Service("Интернет 75мб/с", 200, ServiceTypes.INTERNET);
        Service SMSMobile = new Service("500 SMS", 50, ServiceTypes.PHONE);

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
        Account firstIndividual = new IndividualAccount(0, new Person("fName0","sName0"), individualWithTwoInternets);
        Account firstEntity = new EntityAccount(1, "firstEntity", entityTariffSMSInternet);
        Account secondEntity = new EntityAccount(2, "secondEntity", entityTariffSMSWeakInternet);

        System.out.println("Создаем аккаунт менеджера");
        AccountsManager Me = new AccountsManager(3);
        Me.add(firstIndividual);
        Me.add(firstEntity);
        Me.add(secondEntity);

        System.out.println("Тестируем toString'и");
        System.out.println(Me.toString());

        System.out.println("Тестируем hashCode'ы");
        System.out.println(individualWithTwoInternets.hashCode());
        System.out.println(entityTariffSMSWeakInternet.hashCode());
        System.out.println(Me.hashCode());

        System.out.println("Тестируем clone и equals");
        System.out.println(SMSMobile.equals(SMSMobile.clone()));

        System.out.println("Тестируем новый remove, indexOf и lastIndexOf");
        System.out.println(Me.remove(firstIndividual));
        System.out.println(Me.indexOf(firstEntity));
        System.out.println(entityTariffSMSWeakInternet.lastIndexOf(XLInternet));





    }
}

