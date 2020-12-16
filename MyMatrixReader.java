/**
 * Class to take input file of matrices and parse from string to matrices
 */


import java.io.*;

public class MyMatrixReader {
    private static int presentLine;  //current line
    private MyFileReader file;

    /**
     * Constructor of MyMatrixReader class
     * @param inputFile
     */
    MyMatrixReader (MyFileReader inputFile){
        presentLine = 0;
        file = inputFile;
    }


    /**
     * Reads adjacency matrix from input file and converts from string to matrix
     * @return- passes matrix to Path class
     * @return- passes outFile, matrix + path to MyMatrixWriter class
     */
    public boolean[][] readMyMatrix() throws IOException {
        int mSize = Integer.parseInt(file.getFileLines()[presentLine]);  //initiate matrix size- mSize- as integer value of length of lnes in file
        boolean[][] matrix = new boolean[mSize][mSize];  //initiate matrix as size n x n

        for (int i = presentLine+1; i <presentLine + mSize +1; i++){  //read through file as long as there is additional input
            for (int row = 0; row < matrix.length; row++) {  //iterate through matrix rows
                String[] newArray = file. getFileLines()[i+row].split("\\s+");  //split at end f line
                for (int col = 0; col < newArray.length; col++) { //iterate through matrix columns
                    matrix[row][col] = Integer.parseInt(newArray[col]) !=0;//assign values from file to matrix
                }
            } //end for
            i +=  mSize;  //add to matrixSize
        }  //end for
        presentLine  +=  mSize+1;  // add to present line
        return matrix;  //return matrix

    }  //end method readMatrix

} //end class MyMatrix Reader
