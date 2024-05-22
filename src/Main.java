import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("needchanged.txt"));
             FileWriter writer = new FileWriter("changed.txt")){
            StringBuilder stb = new StringBuilder();
            String text;
            Pattern pattern = Pattern.compile("(/\\*([\\S\\s]+?)\\*/)|(//.*)");
            while ((text = reader.readLine()) != null) {
                stb.append(text);
                stb.append("\n");
            }
            Matcher matcher = pattern.matcher(stb);
            text = matcher.replaceAll(" ");
            writer.write(text);
        } catch (Exception ex) {
            System.out.println("ОшибкА");
        }
    }
}
