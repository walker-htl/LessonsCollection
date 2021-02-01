import java.io.Serializable;
import java.util.List;

public class ComplexObject implements Serializable {
    List<Person> persons;

    public ComplexObject(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();

        for(Person item: persons) {
            buffer.append(item);
            buffer.append("\n");
        }

        return buffer.toString();
    }
}
