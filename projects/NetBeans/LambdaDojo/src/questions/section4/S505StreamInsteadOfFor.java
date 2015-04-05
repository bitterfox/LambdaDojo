package questions.section4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class S505StreamInsteadOfFor {

    public S505StreamInsteadOfFor() {
        fileRead("src/questions/section4/S505StreamInsteadOfFor.java");
    }

    private void fileRead(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int wordCount = 0;

            for (;;) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                String[] words = line.split("[\\.,\\?; ]");
                wordCount += words.length;
            }
            System.out.println(wordCount);
        } catch (IOException ex) {
            // 例外処理
        }
        
        try(Stream<String> lines = new BufferedReader(new FileReader(filename)).lines())
        {
            System.out.println(lines
                    .mapToInt(l -> l.split("[\\.,\\?; ]").length)
                    .sum());
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(S505StreamInsteadOfFor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new S505StreamInsteadOfFor();
    }
}
