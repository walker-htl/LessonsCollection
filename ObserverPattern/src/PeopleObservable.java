import java.util.Observable;

public class PeopleObservable extends Observable {

    private String name;

    public PeopleObservable() {
        super();
    }

    public PeopleObservable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void wink(int count) {
        setChanged();
        notifyObservers(count);
    }
}
