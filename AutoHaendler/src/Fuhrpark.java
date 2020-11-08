import java.util.Arrays;

class Fuhrpark
{
    private Fahrzeug[] fahrzeuge;
    private int index;

    public Fuhrpark(int maxAnzahlVonFahrzeugen)
    {
        fahrzeuge = new Fahrzeug[maxAnzahlVonFahrzeugen];
        index = 0;
    }

    public void addFahrzeug(Fahrzeug fahrzeug)
    {
        if (index >= fahrzeuge.length)
        {
            System.out.println("Der Fuhrpark ist leider voll!");
            System.out.println();
            System.out.println();
        }
        else
        {
            this.fahrzeuge[index] = fahrzeug;
            index++;
        }
    }

    public void printPreisliste()
    {
        Arrays.sort(fahrzeuge);

        System.out.println("Fahrzeuge aufsteigend nach dem Preis sortiert");
        System.out.println("=============================================");
        for (int i = 0; i < index; i++)
        {
            System.out.println(fahrzeuge[i].toString());
        }
    }

    public void printZulassugsliste(boolean aufsteigend)
    {
        ZulassungsComparer compareObjecct = new ZulassungsComparer();

        if (aufsteigend) {
            System.out.println("Fahrzeuge aufsteigend nach der Erstzulassung sortiert");
            System.out.println("=====================================================");
            Arrays.sort(fahrzeuge, compareObjecct);
        }
        else
        {
            System.out.println("Fahrzeuge absteigend nach der Erstzulassung sortiert");
            System.out.println("====================================================");
            Arrays.sort(fahrzeuge, compareObjecct.reversed());
        }

        for (Fahrzeug fahrzeug: fahrzeuge)
        {
            System.out.println(fahrzeug.toString());
        }
    }
}