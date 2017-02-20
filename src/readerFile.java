import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by thieg on 15/02/2017.
 */
class readerFile {

    private char[][] str = new char[8][8];
    private Map<Integer, Integer> area = new HashMap<Integer, Integer>();

    /**
     * Initiate the grid from a file
     * @param nbr is the number of the file
     */
    readerFile(int nbr){
        File file = new File("grid" + nbr + ".txt");
        int i = 0;

        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
              str[i++] = sc.nextLine().toCharArray();
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("We didnt find your file");
            this.str = null;
        }
    }

    /**
     * Show the grid
     */
    void showGrid() {
        for (char[] aStr : str) {
            for (char c : aStr)
                System.out.print(c);
            System.out.println();
        }
    }

    /**
     * Show each area and how many O has been found
     */
    void showArea() {

        for (int i = 1; i <= area.size(); i++){
            System.out.println("Area " + i + " : " + area.get(i));
        }
    }

    /**
     * Get the Area
     * @return Map of integer for the area
     */
    Map<Integer, Integer> getarea(){
        return this.area;
    }

    /**
     * Return the grid inside a String[]
     * @return the grid
     */
    char[][] getStr() {
        return this.str;
    }
}