package rpis81.tolkachev.oop.model;

public class Test {
    public static void main(String[] args) {
        Test.lab1test();
        Test.lab2test();
    }
    public static void lab1test () {
        Service internetXXL = new Service();
        System.out.println(internetXXL.getName());
        System.out.println(internetXXL.getCost());
        internetXXL.setCost(200);
        internetXXL.setName("Телевидение 239 каналов");
        System.out.println(internetXXL.getName());
        System.out.println(internetXXL.getCost());


        Service smartHouse = new Service("Умный дом", 20);
        System.out.println(smartHouse.getName());
        System.out.println(smartHouse.getCost());

        IndividualsTariff tariff0 = new IndividualsTariff();  //Тариф 1
        System.out.println(tariff0.services.length);
        tariff0.add(smartHouse);
        System.out.println(tariff0.size());
        tariff0.add(6, internetXXL);
        System.out.println(tariff0.size());
        System.out.println(tariff0.get("Умный дом").name);
        System.out.println(tariff0.get(6).name);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);
        tariff0.add(smartHouse);

        tariff0.add(tariff0.set(8, internetXXL));
        tariff0.add(tariff0.remove(8));
        tariff0.add(tariff0.remove("Умный дом"));
        System.out.println(tariff0.services.length);



        IndividualsTariff tariff1 = new IndividualsTariff(16); //Тариф 2
        System.out.println(tariff1.services.length);
        tariff1.add(3, smartHouse);
        tariff1.add(2, internetXXL);
        System.out.println(tariff1.cost());
        for (int i = 0; i < tariff1.sortedServicesByCost().length; i++ ) {
            System.out.println(tariff1.sortedServicesByCost()[i].name);
        }



        IndividualsTariff tariff2 = new IndividualsTariff(tariff1.services); //Тариф 3 (копия второго)
        System.out.println(tariff2.services.length);
        System.out.println(tariff2.get(2).name);
        tariff2.set(3, internetXXL);
        System.out.println(tariff2.get(3).name);
        System.out.println(tariff2.size());
        System.out.println((tariff2.hasService("Телевидение 239 каналов")));
        tariff2.remove(2);
        System.out.println(tariff2.size());
        tariff2.remove("Телевидение 239 каналов");
        System.out.println(tariff2.size());

        System.out.println((tariff2.hasService("Телевидение 239 каналов")));

        Person douche = new Person("Dan","Espinoza");
        System.out.println(douche.getFName());
        System.out.println((douche.getSName()));
        Person detectiveDouche = new Person("Detective","Douche");

        IndividualAccount doucheAccount = new IndividualAccount(0, douche);
        IndividualAccount detectiveAccount = new IndividualAccount(1, detectiveDouche, tariff0);

        System.out.println(doucheAccount.getNumber());
        System.out.println(detectiveAccount.getPerson().sName);

        System.out.println(doucheAccount.getTariff().get(0).name);

        doucheAccount.setPerson(detectiveDouche);
        doucheAccount.setTariff(tariff2);

        AccountsManager manager0 = new AccountsManager(8);
        manager0.add(doucheAccount);

        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        manager0.add(doucheAccount);
        System.out.println(manager0.size());
        AccountsManager manager1 = new AccountsManager(manager0.getAccounts());
        manager1.add(3, detectiveAccount);
        manager1.add(4, manager1.get(3));
        manager0.set(1, detectiveAccount);
        System.out.println(manager0.remove(9));
        System.out.println(manager0.set(1, detectiveAccount).getNumber());
        doucheAccount.setTariff(manager0.getTariff(0));

        System.out.println(manager1.setTariff(0, tariff0));



    }

    public static void lab2test (){
        Tariff firstTariff = new EntityTariff();
        Account firstEntity = new EntityAccount("First",0);
        System.out.println(firstTariff.size());
        Account secondEntity = new EntityAccount("Second",1, firstTariff);
        ((EntityAccount)firstEntity).setName("Zero");
        System.out.println(((EntityAccount)firstEntity).getName());
        firstTariff.add(new Service("Голова убийца", 50));
        System.out.println(firstTariff.size());
        firstTariff.add(new Service("Интернет 100мб/с", 50));
        System.out.println(firstTariff.size());
        firstTariff.get("Интернет 100мб/с");
        System.out.println(firstTariff.get(1).getName());
        firstTariff.hasService("Интернет 100мб/с");
        firstTariff.set(1, new Service("Голова убийца", 50));
        System.out.println(firstTariff.size());
        firstTariff.remove(1);
        System.out.println(firstTariff.size());
        System.out.println(firstTariff.get(0).getName());
        firstTariff.add(new Service("Интернет 100мб/с",50));
        System.out.println(firstTariff.get(1).getName());
        System.out.println(firstTariff.size());
        firstTariff.remove("Интернет 100мб/с");
        firstTariff.add(new Service("Интернет 100мб/с",50));
        System.out.println(firstTariff.get(1).getName());
        firstTariff.getServices();
        firstTariff.sortedServicesByCost();
        System.out.println(firstTariff.cost());
        Tariff secondTariff = new EntityTariff(firstTariff.sortedServicesByCost());
        System.out.println(secondTariff.cost());






    }
}

