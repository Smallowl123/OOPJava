package rpis81.tolkachev.oop.model;

import java.util.Objects;

public abstract class AbstractAccount implements Account {
    private Tariff tariff;
    private final long number;

    protected AbstractAccount (long number, Tariff tariff){
        this.number = number;
        this.tariff = tariff;
    }

    @Override
    public long getNumber() {
        return number;
    }

    @Override
    public Tariff getTariff() {
        return tariff;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("number: ");
        builder.append(number);
        builder.append("\n");
        builder.append(tariff.toString());
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return (int) (number*tariff.size());
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof AbstractAccount)) {
            return false;
        }
        AbstractAccount other = (AbstractAccount) obj;
        if(!Objects.equals(number, other.number)) {
            return false;
        }
        return Objects.equals(tariff.size(), other.tariff.size());
    }
}
