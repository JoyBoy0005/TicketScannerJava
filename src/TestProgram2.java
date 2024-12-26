//import java.io.*;
//import java.util.*;
//
//public class Table {
//    private String tablename;
//    private int numRows;
//    private int numCols;
//    private String[][] grid;
//
//    public Table(String filename) {
//        tablename = filename;
//        loadFromFile();
//    }
//
//    private void loadFromFile() {
//        try {
//            Scanner theFile = new Scanner(new FileInputStream(new File(tablename)));
//            while (theFile.hasNextLine()) {
//                numRows++;
//                String[] item = theFile.nextLine().split("\t", -1);
//                if (item.length > numCols)
//                    numCols = item.length;
//            }
//            theFile.close();
//
//            grid = new String[numRows][numCols];
//
//            Scanner scanner = new Scanner(new FileInputStream(new File(tablename)));
//            int r = 0;
//            while (scanner.hasNextLine()) {
//                String[] items = scanner.nextLine().split("\t", -1);
//                for (int c = 0; c < numCols; c++) {
//                    if (c < items.length)
//                        grid[r][c] = items[c];
//                    else
//                        grid[r][c] = "";
//                }
//                r++;
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("Table class Error: file not found.");
//        }
//    }
//
//    public boolean isTicketValid(String barcode) {
//        for (int r = 0; r < numRows; r++) {
//            if (grid[r][0].equals(barcode))
//                return true;
//        }
//        return false;
//    }
//
//    public boolean isTicketEntered(String barcode) {
//        for (int r = 0; r < numRows; r++) {
//            if (grid[r][0].equals(barcode))
//                return grid[r][2].equals("Y");
//        }
//        return false;
//    }
//
//    public void markTicketEntered(String barcode) {
//        for (int r = 0; r < numRows; r++) {
//            if (grid[r][0].equals(barcode)) {
//                grid[r][2] = "Y";
//                break;
//            }
//        }
//        updateFile(); // Call the updateFile() method after marking the ticket as entered
//    }
//
//    public void updateFile() {
//        try (FileWriter writer = new FileWriter(new File(tablename))) {
//            for (int r = 0; r < numRows; r++) {
//                for (int c = 0; c < numCols; c++) {
//                    writer.write(grid[r][c]);
//                    if (c < numCols - 1)
//                        writer.write("\t");
//                }
//                writer.write("\n");
//            }
//        } catch (IOException e) {
//            System.out.println("Error updating file.");
//        }
//    }
//}
