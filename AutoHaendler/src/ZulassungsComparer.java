import java.util.Comparator;

public class ZulassungsComparer implements Comparator<Fahrzeug> {
    @Override
    public int compare(Fahrzeug o1, Fahrzeug o2) {
        return o1.getErstzulassung().compareTo(o2.getErstzulassung());
    }
}
