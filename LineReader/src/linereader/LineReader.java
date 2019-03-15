
package linereader;
import java.io.BufferedReader;
import java.io.FileReader;

public class LineReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int totalLines = 0;
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("foo.txt"))) {
    
  
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();

                if (!trimmedLine.startsWith("//") && !trimmedLine.startsWith("/*") && IsNullOrEmpty(trimmedLine) && !trimmedLine.startsWith("*")) {
                    //count the lines that meet the requirements
                    totalLines++;
                }
            }

            System.out.println("This file has contains " + totalLines + " lines of code");


        } catch (Exception ex) {
           
            System.out.println("readLine() failed.");
        }

    }
    public static boolean IsNullOrEmpty(String str) {
        return str != null && !str.isEmpty();
    }

}
