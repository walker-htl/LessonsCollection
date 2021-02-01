import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        testFileWriter();
//        testFileWriterWithClosingResources();
//        testFileReader();
//        testFileReaderWithClosingResources();
//        testBufferedWriter();
//        testBufferedReaer();
//        testInputStreamReader();
//        testPrintWriter();
//        testFilterWriter();
//        testStringWriter();
//        testStringReader();
//        testSystemInOut();
//        testSerializeAndDeserialize();
//        testSerializeAndDeserializeLists();
        testSerializeAndDeserializeComplexObjects();
    }

    private static void testSerializeAndDeserializeComplexObjects() {
        System.out.println("\nSTART: testSerializeAndDeserializeComplexObjects");
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Max", "Mustermann", 12));
        personList.add(new Person("Maria", "Musterfrau", 21));
        personList.add(new Person("Hans", "Huber", 17));

        ComplexObject complexObject = new ComplexObject(personList);
        // schreiben
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("objekte.ser"));){
            oos.writeObject(complexObject);
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }

        //lesen
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("objekte.ser"));){
            ComplexObject o1 = (ComplexObject) ois.readObject();

            System.out.println(o1);
        }
        catch (IOException | ClassNotFoundException io) {
            System.out.println(io.getMessage());
        }
        System.out.println("END: testSerializeAndDeserializeComplexObjects");
    }

    private static void testSerializeAndDeserializeLists() {
        System.out.println("\nSTART: testSerializeAndDeserializeLists");
        // create an arbitrary list
        ArrayList<Person> persons = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            String firstName = "First" + (i + 1);
            String secondName = "Last" + (i + 1);
            int age = 20 + i;
            persons.add(new Person(firstName, secondName, age));
        }

        // write the whole list to the objectOutputStream
        try {
            FileOutputStream outputStream = new FileOutputStream("Output.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(persons);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // read the whole list from the objectInputStream
        try {
            FileInputStream fileInputStream=new FileInputStream("Output.ser");
            ObjectInputStream stream=new ObjectInputStream(fileInputStream);
            for(Person person : (ArrayList<Person>)stream.readObject())
            {
                System.out.println(person);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("END: testSerializeAndDeserializeLists");
    }

    private static void testSerializeAndDeserialize() {
        System.out.println("\nSTART: testSerializeAndDeserialize");
        // wir erzeugen 3 Personen - Objekte
        Person max = new Person("Max", "Mustermann", 20);
        Person maria = new Person("Maria", "Musterfrau", 21);
        Person hans = new Person("Hans", "Huber", 17);

        // schreiben
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("objekte.ser"));){
            oos.writeObject(max);
            oos.writeObject(maria);
            oos.writeObject(hans);
        }
        catch (IOException io) {
            System.out.println(io.getMessage());
        }

        //lesen
        List<Person> personList = new ArrayList<>(3);

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("objekte.ser"));){
            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            Person p3 = (Person) ois.readObject();

            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
        }
        catch (IOException | ClassNotFoundException io) {
            System.out.println(io.getMessage());
        }
        System.out.println("END: testSerializeAndDeserialize");
    }

    private static void testSystemInOut() {
        System.out.println("\nSTART: testSystemInOut");
        byte[] b = new byte[1]; // byte array der Größe 1

        try {
            System.out.print("Bitte geben Sie ein Zeichen ein: ");
            System.in.read(b);
            System.out.println((char)b[0] + " hat den ASCII-Code " + b[0]);
        } catch (IOException io){
            System.out.println(io.getMessage());
        }
        System.out.println("END: testSystemInOut");
    }

    private static void testStringReader() {
        System.out.println("\nSTART: testStringReader");
        String s = "Java macht Spass";
        StringReader sr = new StringReader(s);
        int z;

        try {
            while ((z = sr.read()) != -1)
                System.out.println((char)z);
        } catch (IOException io){
            System.out.println(io.getMessage());
        }
        System.out.println("END: testStringReader");
    }

    private static void testStringWriter() {
        System.out.println("\nSTART: testStringWriter");
        String s = "Java macht Spass";
        StringWriter sw = new StringWriter();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            s = s.substring(0, s.length() - 1);
            sw.write(s + "\n");
        }

        System.out.println(sw.toString());
        System.out.println("END: testStringWriter");
    }

    private static void testFilterWriter() {
        System.out.println("\nSTART: testFilterWriter");
        try {
            FileWriter fw = new FileWriter("testLowerWriter.txt");
            LowerCaseFilterWriter filterWriter = new LowerCaseFilterWriter(fw);
            filterWriter.write("I LOVE SEW!");
            filterWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("END: testFilterWriter");
    }

    private static void testPrintWriter() {
        System.out.println("\nSTART: testPrintWriter");
        try {
            PrintWriter pw = new PrintWriter("testCharPrint.dat"); //String schreiben
            pw.println("Ausgabe des Flächeninhalts für Kreise mit: ");
            for (int r = 1; r <= 10; r++) {
                pw.print("Radius r = " + r + ": "); //String schreiben
                pw.println(Math.PI * r * r); //double-Wert schreiben
            }
            pw.close();
        } catch (IOException io){
            System.out.println(io.getMessage());
        }
        System.out.println("END: testPrintWriter");
    }

    private static void testInputStreamReader() {
        System.out.println("\nSTART: testInputStreamReader");
        System.out.print("Gib einen Text ein: ");

        String s = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\nAusgabe: " + s);
        System.out.println("END: testInputStreamReader");
    }

    private static void testBufferedReaer() {
        System.out.println("\nSTART: testBufferedReaer");
        String s;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("testCharBuffer.dat"));
            try {
                while ((s = br.readLine()) != null)
                    System.out.println(s);
            } finally {
                if (br != null)
                    br.close();
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
        System.out.println("END: testBufferedReaer");
    }

    private static void testBufferedWriter() {
        System.out.println("\nSTART: testBufferedWriter");
        char[] ca = {'t', 'e', 's', 't', '1'};

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("testCharBuffer.dat"));
            for (int i = 0; i < 100; i++) {
                bw.write(ca);
                bw.newLine();
            }
            bw.close();
        } catch(IOException io){
            System.out.println(io.getMessage());
        }

        System.out.println("END: testBufferedWriter");
    }

    private static void testFileReader() {
        System.out.println("\nSTART: testFileReader");
        String text = "";
        int x = 0;

        try {
            FileReader fr = new FileReader("testCharFile.dat");
            while ((x = fr.read()) != -1) {
                text += (char) x;
            }
            fr.close();
        } catch (IOException io){
            System.out.println(io.getMessage());
        }

        System.out.println(text);
        System.out.println("END: testFileReader");
    }

    private static void testFileReaderWithClosingResources() {
        System.out.println("\nSTART: testFileReader");
        StringBuffer text = new StringBuffer();
        int x = 0;

        try (FileReader fr = new FileReader("testCharFile.dat")){
            while ((x = fr.read()) != -1) {
                text.append((char)x);
            }
        } catch (IOException io){
            System.out.println(io.getMessage());
        }

        System.out.println(text);
        System.out.println("END: testFileReader");
    }

    private static void testFileWriter() {
        System.out.println("\nSTART: testFileWriter");
        System.out.println("User-Directory: " + System.getProperty("user.dir"));
        System.out.println("Create file: testCharFile.dat");

        try {
            FileWriter fw = new FileWriter("testCharFile.dat", true);
            fw.write("1. Zeile: Test Ausgabe \r\n2. Zeile: in eine Datei");
            fw.close();
        } catch (IOException ioex){
            System.out.println(ioex.getMessage());
        }

        System.out.println("END: testFileWriter");
    }

    private static void testFileWriterWithClosingResources() {
        System.out.println("\nSTART: testFileWriter");
        System.out.println("User-Directory: " + System.getProperty("user.dir"));
        System.out.println("Create file: testCharFile.dat");

        try (FileWriter fw = new FileWriter("testCharFile.dat", true)){
            fw.write("\n1. Zeile: Test Ausgabe \r\n2. Zeile: in eine Datei");
        } catch (IOException ioex){
            System.out.println(ioex.getMessage());
        }

        System.out.println("END: testFileWriter");
    }
}
