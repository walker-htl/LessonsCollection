public class MyPerson extends Person implements Comparable<MyPerson> {
    public MyPerson() {
        super();
    }

    public MyPerson ( String lastname, String prename, int personalNr) {
        super(lastname, prename, personalNr);
    }

    public int compareTo(MyPerson o) {
        if ((o == null) ||
                (o.getClass() != getClass()))
            return -1;
        int i = getLastname().compareTo(o.getLastname());
        if (i != 0)
            return i;
        else {
            i = getPrename().compareTo(o.getPrename());
            if (i != 0)
                return i;
            else {
                i = getPersonalNr() - o.getPersonalNr();
                return i;
            }
        }
    }
}
