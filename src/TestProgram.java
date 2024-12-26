//import java.util.Scanner;
//
//public class TicketScanningApp {
//    private static final String FILE_PATH = "codes.txt";
//
//    public static void main(String[] args) {
//        // Load data from codes.txt file
//        Table table = new Table(FILE_PATH);
//
//        // Create scanner to read input
//        Scanner scanner = new Scanner(System.in);
//
//        // Main loop to continuously scan tickets
//        while (true) {
//            // Prompt user to scan ticket
//            System.out.print("Scan ticket barcode: ");
//            String barcode = scanner.nextLine().trim();
//
//            // Check if ticket is valid
//            if (table.isTicketValid(barcode)) {
//                // If ticket is valid, check if it's already entered
//                if (table.isTicketEntered(barcode)) {
//                    System.out.println("Duplicate ticket! This ticket has already been scanned.");
//                } else {
//                    // If ticket is valid and not already entered, mark it as entered
//                    System.out.println("Valid ticket! Access granted.");
//                    table.markTicketEntered(barcode);
//                }
//            } else {
//                System.out.println("Invalid ticket! Please try again.");
//            }
//        }
//    }

//System.out.print("Enter the Primary key > ");
//target = in.nextLine();
//int rowNumSearch = t.lookup(target);
//                    if (rowNumSearch == -1)
//        System.out.println(target + " not Found. ");
//                    else {
//String[] str = t.getMatches(target);
//                        for (int s = 0; s < str.length; s++) {
//        System.out.printf("[%d] - %s\n", s, str[s]);
//                        }
//                                }
////                                break;
////}
//System.out.print("Enter Row Number: ");
//int rowForSave = in.nextInt();
//                    in.nextLine();
//                    System.out.print("Enter Column Number: ");
//int colForSave = in.nextInt();
//                    in.nextLine();
//                    System.out.print("Enter New Value: ");
//String valueForSave = in.nextLine();
//                    t.setSingleCellValue(rowForSave, colForSave, valueForSave); // Update the cell value
//                    System.out.println("Single cell value saved successfully!");