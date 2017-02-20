import java.util.Objects;
import java.util.Scanner;

public class Main {
    /**
     * Main function to initiate the program
     * @param args
     */
    public static void main(String[] args) {

        boolean isWorking = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Grid Area Counter ");
        while (isWorking) {
            System.out.println("If you want to quit type: q");
            System.out.print("Enter the number of the Grid : ");
            if (sc.hasNextInt()) {
                readerFile rf = new readerFile(sc.nextInt());
                sc.nextLine();
                if (rf.getStr() != null) {
                    rf.showGrid();
                    findOInGrid(rf, 1);
                    rf.showArea();
                }
            } else if (sc.hasNext()){
                if (Objects.equals(sc.next(), "q"))
                    isWorking = false;
            }
        }
    }

    /**
     * Find all O inside the Grid
     * @param rf readFile to get the Grid
     * @param counterArea To know which area we are in
     */
    public static void findOInGrid(readerFile rf, int counterArea) {
        int x = 0;
        int y = 0;

        for (String aStr : rf.getStr()) {
            y = 0;
            for (char c : aStr.toCharArray()) {
                if (c == 'o') {
                    findOInGrid(findArea(rf, x, y, counterArea++), counterArea++);
                    return;
                }
                y++;
            }
            x++;
        }
    }

    /**
     * Find the O near the area
     * @param rf ReadFile to get the grid
     * @param x is the index of the grid
     * @param y is the index of the grid
     * @param counterArea is the area number
     * @return the readFile
     */
    public static readerFile findArea(readerFile rf, int x, int y, int counterArea) {
        if (x < 0 || x > 7 || y < 0 || y > 7)
            return rf;

        char[] str = rf.getStr()[x].toCharArray();

        if (str[y] == 'o') {
            if (rf.getarea().get(counterArea) == null)
                rf.getarea().put(counterArea, 1);
            else
                rf.getarea().put(counterArea, rf.getarea().get(counterArea) + 1);
        } else { return rf; }


        str[y] = '#';
        rf.getStr()[x] = String.valueOf(str);
        findArea(rf, x + 1, y, counterArea);
        findArea(rf, x - 1, y, counterArea);
        findArea(rf, x, y + 1, counterArea);
        findArea(rf, x, y - 1, counterArea);

        return rf;
    }
}
