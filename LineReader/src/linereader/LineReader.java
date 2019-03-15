
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
        try (BufferedReader br = new BufferedReader(new FileReader("Test2.txt"))) {
            
            //Loop through each line in the file.
            while ((line = br.readLine()) != null) {
                //Trim out anything that is not required for each line in the file
                String trimmedLine = line.trim();

                if (!trimmedLine.startsWith("//") && !trimmedLine.startsWith("/*") && IsNullOrEmpty(trimmedLine) && !trimmedLine.startsWith("*")) {
                    //count the lines that meet the requirements
                    totalLines++;
                }
            }
            //show the total lines
            System.out.println("This file has contains " + totalLines + " lines of code");


        } catch (Exception ex) {
           
            System.out.println("readLine() failed.");
        }

    }
    public static boolean IsNullOrEmpty(String str) {
        return str != null && !str.isEmpty();
    }

}
