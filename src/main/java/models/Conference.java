package models;
import java.util.Date;

public class Conference {
    private int id;
    private Date date;
    private String topic;
    private String address;
    private int instructorId;
    private int attendeesAverageAge;
    private double attendeesAverageSalary;
    private int womenNumber;
    private int menNumber;

    public Conference(Date date, String topic, String address, int instructorId){
        this.date = date;
        this.topic = topic;
        this.address = address;
        this.instructorId = instructorId;
        this.attendeesAverageAge = 0;
        this.attendeesAverageSalary = 0;
        this.womenNumber = 0;
        this.menNumber = 0;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public int getAttendeesAverageAge() {
        return attendeesAverageAge;
    }

    public void setAttendeesAverageAge(int attendeesAverageAge) {
        this.attendeesAverageAge = attendeesAverageAge;
    }

    public int getMenNumber() {
        return menNumber;
    }

    public void setMenNumber(int menNumber) {
        this.menNumber = menNumber;
    }

    public int getWomenNumber() {
        return womenNumber;
    }

    public void setWomenNumber(int womenNumber) {
        this.womenNumber = womenNumber;
    }

    public double getAttendeesAverageSalary() {
        return attendeesAverageSalary;
    }

    public void setAttendeesAverageSalary(double attendeesAverageSalary) {
        this.attendeesAverageSalary = attendeesAverageSalary;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conference conference = (Conference) o;
        if (!date.equals(conference.date)) return false;
        if (!topic.equals(conference.topic)) return false;
        if (instructorId != conference.instructorId) return false;
        return address != null ? address.equals(conference.address) : conference.address == null;
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + topic.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + instructorId;
        return result;
    }
}
