public class Smurf {
    private int smurfId;
    private String name;
    private int mushroomNumber;

    public Smurf(int smurfId, String name, int mushroomNumber) {
        this.smurfId = smurfId;
        this.name = name;
        this.mushroomNumber = mushroomNumber;
    }

    @Override
    public String toString() {
        return "Smurf{" +
                "smurfId=" + smurfId +
                ", name='" + name + '\'' +
                ", mushroomNumber=" + mushroomNumber +
                '}';
    }

    public String getName() {
        return name;
    }
}
