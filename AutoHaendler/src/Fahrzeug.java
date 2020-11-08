import sun.util.resources.LocaleData;

import java.util.Date;

class Fahrzeug
{
    private String name;
    private String erstzulassung;
    private int leistung;
    private double spritverbrauch;
    private double eurotaxEinkaufspreis;
    private double tatsaechlicherEinkaufspreis;
    private double eurotaxVerkaufspreis;

    public Fahrzeug(String name, String erstzulassung, int leistung, double spritverbrauch, double eurotaxEinkaufspreis, double tatsaechlicherEinkaufspreis, double eurotaxVerkaufspreis)
    {
        this.name = name;
        this.erstzulassung = erstzulassung;
        this.leistung = leistung;
        this.spritverbrauch = spritverbrauch;
        this.eurotaxEinkaufspreis = eurotaxEinkaufspreis;
        this.tatsaechlicherEinkaufspreis = tatsaechlicherEinkaufspreis;
        this.eurotaxVerkaufspreis = eurotaxVerkaufspreis;
    }

    public String getName()
    {
        return name;
    }

    public String getErstzulassung()
    {
        return erstzulassung;
    }

    public int getLeistung()
    {
        return leistung;
    }

    public double getSpritverbrauch()
    {
        return spritverbrauch;
    }

    public double getEurotaxEinkaufspreis()
    {
        return eurotaxEinkaufspreis;
    }

    public double getTatsaechlicherEinkaufspreis()
    {
        return tatsaechlicherEinkaufspreis;
    }

    public double getEurotaxVerkaufspreis()
    {
        return eurotaxVerkaufspreis;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", erstzulassung=" + erstzulassung +
                ", leistung=" + leistung +
                ", spritverbrauch=" + spritverbrauch +
                ", eurotaxEinkaufspreis=" + eurotaxEinkaufspreis +
                ", tatsaechlicherEinkaufspreis=" + tatsaechlicherEinkaufspreis +
                ", eurotaxVerkaufspreis=" + eurotaxVerkaufspreis +
                '}';
    }
}
