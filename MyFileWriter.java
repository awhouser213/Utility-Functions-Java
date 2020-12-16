/*
Class to construct an output file
 */

import java.io.*;

public class MyFileWriter {

    private String filePath;  //file path name as a string
    private FileWriter outFile;  //output file
    private PrintWriter printFile;  //File printer

    /**
     * Generic Getter for filePath
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Constructor for writing file to output file
     * @param s
     * @throws IOException
     */
    MyFileWriter(String s) throws IOException {
        filePath = s;  //set filePath to string s
        outFile = new FileWriter(filePath);
        printFile = new PrintWriter(outFile);
    }

    /**
     * Method to write output to file
     * @param s
     * @throws IOException
     */

    public void writeToFile(String s) throws IOException {
        printFile.printf(s);
    }

    /**
     * Close printFile object
     */

    public void closeFile() {
        printFile.close();
    }

}  //end classWriteFile
