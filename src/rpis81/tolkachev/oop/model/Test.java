package rpis81.tolkachev.oop.model;

public class Test {
    public static void lab1test () {
        Service InternetXXL = new Service();
        System.out.println(InternetXXL.getName());
        System.out.println(InternetXXL.getCost());
        InternetXXL.setCost(200);
        InternetXXL.setName("Телевидение 239 каналов");
        System.out.println(InternetXXL.getName());
        System.out.println(InternetXXL.getCost());


        Service SmartHouse = new Service("Умный дом", 20);
        System.out.println(SmartHouse.getName());
        System.out.println(SmartHouse.getCost());

        IndividualsTariff Tariff0 = new IndividualsTariff();  //Тариф 1
        System.out.println(Tariff0.services.length);
        Tariff0.add(SmartHouse);
        System.out.println(Tariff0.size());
        Tariff0.add(6, InternetXXL);
        System.out.println(Tariff0.size());
        System.out.println(Tariff0.get("Умный дом").name);
        System.out.println(Tariff0.get(6).name);


        IndividualsTariff Tariff1 = new IndividualsTariff(16); //Тариф 2
        System.out.println(Tariff1.services.length);
        Tariff1.add(3, SmartHouse);
        Tariff1.add(2, InternetXXL);
        System.out.println(Tariff1.cost());
        for (int i = 0; i < Tariff1.sortedServicesByCost().length; i++ ) {
            System.out.println(Tariff1.sortedServicesByCost()[i].name);
        }



        IndividualsTariff Tariff2 = new IndividualsTariff(Tariff1.services); //Тариф 3 (копия второго)
        System.out.println(Tariff2.services.length);
        System.out.println(Tariff2.get(2).name);
        Tariff2.set(3, InternetXXL);
        System.out.println(Tariff2.get(3).name);
        System.out.println(Tariff2.size());
        Tariff2.remove(2);
        System.out.println(Tariff2.size());
        Tariff2.remove("Телевидение 239 каналов");
        System.out.println(Tariff2.size());

        System.out.println((Tariff2.hasService("Телевидение 239 каналов")));


    }
    public static void main(String[] args) {
        Test.lab1test();
    }
}

