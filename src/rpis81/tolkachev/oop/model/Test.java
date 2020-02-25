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

    }
    public static void main(String[] args) {
        Test.lab1test();
    }
}

