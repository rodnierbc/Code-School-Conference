package models;

public class Instructor extends Person{
    private String education;
    private String currentJob;

    public Instructor(String name, String email, String phone, String education, String currentJob){
        super(name, email, phone);
        this.education = education;
        this.currentJob = currentJob;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCurrentJob() {
        return currentJob;
    }

    public void setCurrentJob(String currentJob) {
        this.currentJob = currentJob;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor instructor = (Instructor) o;
        if (!super.equals(o)) return false;
        if (!education.equals(instructor.education)) return false;
        return currentJob != null ? currentJob.equals(instructor.currentJob) : instructor.currentJob == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + education.hashCode();
        result = 31 * result + currentJob.hashCode();
        return result;
    }

}
