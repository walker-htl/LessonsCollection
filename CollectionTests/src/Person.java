public class Person {
    private String lastname;
    private String prename;
    private int personalNr;

    public Person() {
        this("", "", 0);
    }

    public Person(String lastname, String prename, int personalNr) {
        this.lastname = lastname;
        this.prename = prename;
        this.personalNr = personalNr;
    }

    public int hashCode()
    {
        return lastname.hashCode() +
                prename.hashCode() +
                personalNr;
    }

    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != this.getClass()))
            return false;
        else {
            Person obj = (Person)o;
            return ((obj.lastname.equals(lastname)) &&
                    (obj.prename.equals(prename)) &&
                    (obj.personalNr == personalNr));
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastname='" + lastname + '\'' +
                ", prename='" + prename + '\'' +
                ", personalNr=" + personalNr +
                '}';
    }

    public String getLastname() {
        return lastname;
    }

    public String getPrename() {
        return prename;
    }

    public int getPersonalNr() {
        return personalNr;
    }
}