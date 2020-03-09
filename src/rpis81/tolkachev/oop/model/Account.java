package rpis81.tolkachev.oop.model;

public interface Account {
    long getNumber();
    Tariff getTariff();
    void setTariff(Tariff tariff);
}
