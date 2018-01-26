package models;
import java.util.Date;
import java.util.Objects;

public class Attende extends Person {
    private double salary;
    private Date birthdate;
    private String gender;

    public Attende(String name, String email, String phone, double salary, Date birthdate, String gender){
        super(name, email, phone);
        this.salary = salary;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attende attende = (Attende) o;
        if (!super.equals(o)) return false;
        if ( salary != attende.salary) return false;
        if (!birthdate.equals(attende.birthdate)) return false;
        return gender != null ? gender.equals(attende.gender) : attende.gender == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + birthdate.hashCode();
        result = 31 * result + new Double(salary).hashCode();
        result = 31 * result + gender.hashCode();
        return result;

    }
}
