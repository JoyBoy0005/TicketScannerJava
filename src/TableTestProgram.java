//import java.io.File;
//import java.io.IOException;
//import java.util.Scanner;
//import java.io.FileInputStream;
//import java.util.Scanner;
//
//
///**
// * Write a description of class Preferences here.
// *
// * @author Princekumar Patel
// * @version (a version number or a date)
// */
//public class TableTestProgram
//{
//
//    /**
//     *
//     * Main
//     *
//     * @param args  the args.
//     * @throws   Exception
//     */
//    public static void main(String[] args ) throws Exception {
//
//
//
//        Scanner in = new Scanner(System.in);
//        String tablename = "";
//        String choice = "";
//        int row = -1;
//        int colNum=1;
//        String key = "";
//        String s_colNum = "";
//        String newValue = "";
//        String target = "";
//
//        System.out.print("Enter the name of the tab delimited text file you wish to manage (e.g. codes.txt) > ");
//        tablename = in.nextLine();
//        Table t = new Table(tablename);
//        System.out.println("Successfully loaded: " + t);
//
//
//        while (1==1) {
//            System.out.println("\n\nTable Testing Menu\n");
//
//            System.out.println("1. Display all data");
//            System.out.println("2. Lookup");
//            System.out.println("3. Search");
//            System.out.println("4. Change");
//            System.out.println("5. Save data to " + tablename);
//            System.out.println("6. Get Single Cell Value");
//            System.out.println("7. Save Single Cell Value");
//            System.out.println("9. Quit");
//            System.out.print("Select > ");
//            choice = in.nextLine();
//
//            if (choice.equals("9")) break;
//
//            else if(choice.equals("1"))t.display();
//
//
//
//            else if(choice.equals("6")){
//                System.out.print("Enter row : ");
//                int r = in.nextInt();
//                in.nextLine();
//                System.out.print("Enter column: ");
//                int c = in.nextInt();
//                in.nextLine();
//                target = t.getSingleCellValue(r,c);
//                System.out.println("your cell value: " + target  );
//            }
//
//
//
//
//            else if (choice.equals("2")) {
//                System.out.print("Enter the primary key> ");
//                target = in.nextLine();
//                int rowNum = t.lookup(target);
//                if (rowNum == -1)
//                    System.out.println(target + " not found.");
//                else
//                    System.out.println(target + " found at row number " + String.format("%d",rowNum));
//            }
//
//
//
//
//
//            else if (choice.equals("3")) {
//
//                System.out.print("Enter the Primary key > ");
//                target = in.nextLine();
//                int rowNumSearch = t.lookup(target);
//                if (rowNumSearch == -1)
//                    System.out.println(target + " not Found. ");
//                else {
//                    String[] str = t.getMatches(target);
//                    for (int s = 0; s < str.length; s++) {
//                        System.out.printf("[%d] - %s\n", s, str[s]);
//                    }
//                }
//            }
//
//
//
//
//
//            else if(choice.equals("4")){
//                System.out.print("Enter row : ");
//                int r = in.nextInt();
//                in.nextLine();
//                System.out.print("Enter column: ");
//                int c = in.nextInt();
//                in.nextLine();
//                target = t.getSingleCellValue(r,c);
//                System.out.println("your cell value: " + target  );
//
//                System.out.print("What value you would like to enter: ");
//                String str = in.nextLine();
//                target = str;
//                System.out.println(target);
//                t.saveCell(r,c,target);
//            }
//
//
//
//
//
//            else if(choice.equals("5")){
//                t.updateTxtFile();
//                System.out.println("Data successfully saved to " + tablename);
//            }
//
//
//
//
//
//            else if (choice.equals("7")) {
//                System.out.print("Enter row : ");
//                int r = in.nextInt();
//                in.nextLine();
//                System.out.print("Enter column: ");
//                int c = in.nextInt();
//                in.nextLine();
//                System.out.print("Enter new Value: ");
//                String value = in.nextLine();
//                t.setSingleCellValue(r,c,value);
//                System.out.println("your cell value: " );
//            }
//
//
//
//
//
//        }
//        System.out.println("Thank-you, good bye!");
//
//    }
//}
//
//
//
