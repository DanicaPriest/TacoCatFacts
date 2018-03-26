package mybatis.model.nyt;

public class Byline {
    String original;
    String organization;
    Person[] person;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Person[] getPerson() {
        return person;
    }

    public void setPerson(Person[] person) {
        this.person = person;
    }
}
