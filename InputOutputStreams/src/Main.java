import java.io.*;

public class Main {

    public static void main(String[] args) {
        //testFileWriter();
        //testFileWriterWithClosingResources();
        //testFileReader();
        testFileReaderWithClosingResources();
        //testBufferedWriter();
        //testBufferedReaer();
        //testInputStreamReader();
    }

    private static void testInputStreamReader() {
        System.out.println("\nSTART: testInputStreamReader");
        System.out.print("Gib einen Text ein: ");

        String s = null;
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
