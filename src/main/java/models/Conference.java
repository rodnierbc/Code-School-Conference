package models;
import java.util.Date;

public class Conference {
    private int id;
    private Date confDate;
    private String topic;
    private String address;
    private int instructorId;
    private int sponsorId;
    private int attendeesAverageAge;
    private double attendeesAverageSalary;
    private int womenNumber;
    private int menNumber;

    public int getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(int sponsorId) {
        this.sponsorId = sponsorId;
    }

    public Conference(Date confDate, String topic, String address, int instructorId, int sponsorId){
        this.confDate = confDate;
        this.topic = topic;
        this.address = address;
        this.instructorId = instructorId;
        this.sponsorId = sponsorId;
        this.attendeesAverageAge = 0;
        this.attendeesAverageSalary = 0;
        this.womenNumber = 0;
        this.menNumber = 0;
    }
    public Conference(Date confDate, String topic, String address, int instructorId, int sponsorId, int attendeesAverageAge, double attendeesAverageSalary, int womenNumber, int menNumber){
        this.confDate = confDate;
        this.topic = topic;
        this.address = address;
        this.instructorId = instructorId;
        this.sponsorId = sponsorId;
        this.attendeesAverageAge = attendeesAverageAge;
        this.attendeesAverageSalary = attendeesAverageSalary;
        this.womenNumber = womenNumber;
        this.menNumber = menNumber;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Date getConfDate() {
        return confDate;
    }

    public void setConfDate(Date confDate) {
        this.confDate = confDate;
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
        if (!confDate.equals(conference.confDate)) return false;
        if (!topic.equals(conference.topic)) return false;
        if (instructorId != conference.instructorId) return false;
        if (sponsorId != conference.sponsorId) return false;
        return address != null ? address.equals(conference.address) : conference.address == null;
    }

    @Override
    public int hashCode() {
        int result = confDate.hashCode();
        result = 31 * result + topic.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + instructorId;
        result = 31 * result + sponsorId;
        return result;
    }
}
