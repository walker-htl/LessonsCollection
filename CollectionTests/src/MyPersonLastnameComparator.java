import java.util.Comparator;

public class MyPersonLastnameComparator implements Comparator<MyPerson> {
    @Override
    public int compare(MyPerson o1, MyPerson o2) {
        return o1.getLastname().compareTo(o2.getLastname());
    }
}
