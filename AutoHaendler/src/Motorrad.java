class Motorrad extends Fahrzeug implements IFortbewegungsmittel
{
    // sollte eigentlich ein enum sein!
    private String motorTyp;

    public Motorrad(String name, String erstzulassung, int leistung, double spritverbrauch, double eurotaxEinkaufspreis, double tatsaechlicherEinkaufspreis, double eurotaxVerkaufspreis, String motorTyp) {
        super(name, erstzulassung, leistung, spritverbrauch, eurotaxEinkaufspreis, tatsaechlicherEinkaufspreis, eurotaxVerkaufspreis);
        this.motorTyp = motorTyp;
    }

    @Override
    public int GetPassagierkapazitaet() {
        return 0;
    }

    @Override
    public double GetKilomenterpreisFuerBenzin() {
        return 0;
    }

    // hier wäre eine abstrakte Klasse besser
    @Override
    public int compareTo(Fahrzeug o) {
        return (int) (this.getEurotaxVerkaufspreis() - o.getEurotaxEinkaufspreis());
    }

    @Override
    public String toString() {
        return "Motorrad {" +
                "Motortyp=" + motorTyp +
                ", " +
                super.toString();
    }
}
