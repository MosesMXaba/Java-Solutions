// Program to count code lines without comments
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
        String catchMultiComments = "";
        try (BufferedReader br = new BufferedReader(new FileReader("Test3.txt"))) {

            //Loop through each line in the file.
            while ((line = br.readLine()) != null) {
                String trimmedLine = line.trim();

                //Work with multiple or block comments
                if (trimmedLine.startsWith("/*") || catchMultiComments.startsWith("/*")) {

                    if (IsNullOrEmpty(catchMultiComments)) {
                        catchMultiComments = trimmedLine;
                    }

                    if (!catchMultiComments.endsWith("*/") && !catchMultiComments.startsWith("//") && !catchMultiComments.contains("*/")) {
                        if (!catchMultiComments.equals(trimmedLine)) {
                            catchMultiComments += trimmedLine;
                        }
                    } else {
                        //Make sure that the comment closes correctly
                        String validCommentClosure = catchMultiComments.substring(catchMultiComments.lastIndexOf("*/") + 1);
                        if (validCommentClosure.contains("/*") && !validCommentClosure.contains("*/")) {
                            catchMultiComments += trimmedLine;
                        } else {
                            catchMultiComments = "";
                        }
                    }
                }
                // Work with single line comments and count the code lines     
                if (IsNullOrEmpty(catchMultiComments)) {
                    if (!trimmedLine.startsWith("//")
                            && !trimmedLine.endsWith("*/")
                            && !IsNullOrEmpty(trimmedLine)
                            && (trimmedLine.contains(";") || trimmedLine.contains("{")
                            || trimmedLine.contains("}") || trimmedLine.contains(")"))) {

                        //count the lines that meet the requirements
                        totalLines++;
                    }
                }
            }

            // Display the message of the counted lines
            System.out.println("This file has contains " + totalLines + " lines of code");

        } catch (Exception ex) {
            System.out.println("readLine() failed. File does not exist.");
        }
    }

    // Function to check if string is Null or Empty
    public static boolean IsNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

}
