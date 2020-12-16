package com.company;

/**
 * Class to take an input file and return
 *      readFromFile- Read file line by line, store values in an array
 *      calcNumberOfMatrices- Calculate number of Matrices within the file
 *      countLines- Calculate number of lines in input file
 */


import java.io.*;

public class MyFileReader {

    private File f;
    public String[] fileLines;
    private static int presentLine;
    int fileLinesCount;

    public File getF() {
        return f;
    }


    /**
     * Generic Constructor of filepath as argument
     */

    public MyFileReader(String fileName) throws IOException {
        f = new File(fileName);
        presentLine = 0;
        fileLines = new String[countLines() + 1];
        fileLinesCount = countLines()+1;
        readFromFile();
    }

    /**Read file line by line
     * Store each item in an index of fileLines array
     * @throws IOException
     */

    private void readFromFile() throws IOException {
        FileReader fr = new FileReader(f);  //initiate FileReader
        BufferedReader br = new BufferedReader(fr);  //buffered reader
        for (int i = 0; i < fileLines.length; i++) {  //for length of each line of file
            fileLines[i] = br.readLine();// read the line, store to fileLines array
        }
        br.close();  //close reader
    }  //end readFromFile


    /**
     * Count number of lines in data source file
     */
    private int countLines() throws IOException {
        InputStream inputFile = new BufferedInputStream(new FileInputStream(f.getAbsolutePath()));  //get input file

        try {
            byte[] c = new byte[1024];  //max size of the array
            int counter = 0;  //counter- number of lines
            int readChar;

            // Loop until end of stream
            while ((readChar = inputFile.read(c)) != -1) {// Read characters until return sequence is read ( and equals -1)
                for (int i = 0; i < readChar; i++) {// Search for number of line returns "\n"
                    if (c[i] == '\n') {
                        counter++;// Increment count for every line return read
                    }  //end if
                }  //end for
            }  //end while
            return counter;  //return counter
        } finally {
            inputFile.close();// Close out InputStream
        }  //end finally
    }//end countLines method

    /**
     * Read file into an array
     * @return
     * @throws IOException
     */
    public int[] readFileToArray() throws IOException {
        int arrSize = fileLinesCount;
        int[] a = new int[arrSize];

        for (int i = 0; i < fileLinesCount; i++) {
            if (fileLines !=null) {  //if the file values are not null
                a[i] = Integer.parseInt(fileLines[i]);//read in String values, convert to Integer
            } //end if
        } //end for loop
        return a;  //return array
    }  //end method readFileToArray();

    /**
     * Read file into a linked list
     * @return
     * @throws IOException
     */

    public List readFileToList ()throws IOException{
        List list = new List<Integer>(); //initiate new list of type Integer

        for (int i =0; i < fileLinesCount; i++){  //for all values in the file
            int content = Integer.parseInt(fileLines[i]);  //and integer in file line to content value
            list.append(content);  //add file to list
        }  //end for loop
        return list;
    }//end readFileToList(); method


}  //end class ReadFile
