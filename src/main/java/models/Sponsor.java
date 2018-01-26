package models;

public class Sponsor {
    private int id;
    private String companyName;
    private String website;
    private String representativeName;

    public Sponsor(String companyName, String website, String representativeName){
        this.companyName = companyName;
        this.website = website;
        this.representativeName = representativeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        if (!companyName.equals(sponsor.companyName)) return false;
        if (!website.equals(sponsor.website)) return false;
        return representativeName != null ? representativeName.equals(sponsor.representativeName) : sponsor.representativeName == null;
    }

    @Override
    public int hashCode() {
        int result = companyName.hashCode();
        result = 31 * result + website.hashCode();
        result = 31 * result + representativeName.hashCode();
        return result;
    }
}
