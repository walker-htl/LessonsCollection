class Auto extends Fahrzeug implements IFortbewegungsmittel
{
    private int anzahlDerSitze;
    private boolean isBenziner;

    public Auto(String name, String erstzulassung, int leistung, double spritverbrauch, double eurotaxEinkaufspreis,
                double tatsaechlicherEinkaufspreis, double eurotaxVerkaufspreis, int AnzahlDerSitze, boolean isBenziner) {
        super(name, erstzulassung, leistung, spritverbrauch, eurotaxEinkaufspreis, tatsaechlicherEinkaufspreis, eurotaxVerkaufspreis);
        this.anzahlDerSitze = AnzahlDerSitze;
        this.isBenziner = isBenziner;
    }

    @Override
    public int GetPassagierkapazitaet() {
        // die Passagierkapazitaet ist die Anzahl der Sitze ohne Fahrer!
        return anzahlDerSitze - 1;
    }

    @Override
    public double GetKilomenterpreisFuerBenzin() {
        if (isBenziner)
        {
            return getSpritverbrauch();
        }

        // Spritverbrauch soll nicht ausgegeben werden.
        return -1;
    }

    @Override
    public int compareTo(Fahrzeug o) {
        return (int) (this.getEurotaxVerkaufspreis() - o.getEurotaxEinkaufspreis());
    }

    @Override
    public String toString() {
        return "Auto {" +
                "AnzahlDerSitze=" + anzahlDerSitze +
                ", isBenziner=" + isBenziner +
                " " +
                super.toString();
    }
}
