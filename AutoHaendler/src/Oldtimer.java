class Oldtimer extends Auto implements ISammelerstueck
{
    private double sammlerWert;
    private int zustandsNote;
    private String[] zustandsNotenKategorie = {"makellos", "gut", "gebraucht", "starker Verschleiß", "restaurationsbedürftig"};

    public Oldtimer(String name, String erstzulassung, int leistung, double spritverbrauch, double eurotaxEinkaufspreis, double tatsaechlicherEinkaufspreis,
                    double eurotaxVerkaufspreis, int anzahlDerSitze, boolean isBenziner, double sammlerWert, int zustandsNote) {
        super(name, erstzulassung, leistung, spritverbrauch, eurotaxEinkaufspreis, tatsaechlicherEinkaufspreis, eurotaxVerkaufspreis, anzahlDerSitze, isBenziner);
        this.sammlerWert = sammlerWert;
        this.zustandsNote = zustandsNote;
    }

    @Override
    public double getSammlerwert() {
        return sammlerWert;
    }


    public int getZustandsnote() {
        return zustandsNote;
    }

    @Override
    public String toString() {
        return "Oldtimer {" +
                "Sammlerwert=" + sammlerWert +
                ", Zustandsnote=" + zustandsNote + "(" + zustandsNotenKategorie[zustandsNote-1] + ") :" +
                super.toString();
    }
}
