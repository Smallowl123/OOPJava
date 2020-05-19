package rpis81.tolkachev.oop.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractAccount implements Account {
    private Tariff tariff;
    private final long number;
    private final LocalDate registrationDate;

    protected AbstractAccount (long number, Tariff tariff, LocalDate registrationDate){
        if (!isProperNumber(number)){
            throw new IllegalAccountNumberException("Неверный формат номера");
        }
        else this.number = number;
        this.tariff = Objects.requireNonNull(tariff,"Значение tariff не должно быть Null");
        if (registrationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Значение registrationDate не должно быть из будущего");
        }
        else this.registrationDate = registrationDate;
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
    public LocalDate getRegistrationDate(){
        return registrationDate;
    }

    @Override
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    private boolean isProperNumber (long number){
        Pattern pattern = Pattern.compile("^\\d{1,15}$");
        String strNumber = Long.toString(number);
        Matcher matcher = pattern.matcher(strNumber);
        return matcher.find();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("number: ");
        builder.append(number);
        builder.append("\n");
        builder.append(tariff.toString());
        builder.append("Registration date: ");
        builder.append(registrationDate);
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return (int) (number*tariff.size()/registrationDate.getDayOfYear());
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
        if(!Objects.equals(registrationDate, other.registrationDate)) {
            return false;
        }
        return Objects.equals(tariff.size(), other.tariff.size());
    }
}
