import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Table class manages ticket data from a file.
 */
class Table {

    private final List<String> purchasedTickets;  // List of all valid purchased tickets
    private final List<String> enteredTickets;    // List of scanned tickets

    /**
     * Constructor that initializes the table and loads tickets from a file.
     *
     * @param filePath the path of the file to load tickets from
     */
    public Table(String filePath) {
        purchasedTickets = new ArrayList<>();
        enteredTickets = new ArrayList<>();
        loadTickets(filePath);
    }

    /**
     * Load tickets from a file and validate them.
     *
     * @param filePath the path of the file to load tickets from
     */
    private void loadTickets(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String ticket = line.trim().toUpperCase();
                if (isTicketValid(ticket)) {
                    purchasedTickets.add(ticket); // Add only valid tickets
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load tickets: " + e.getMessage());
        }
    }

    /**
     * Check if a ticket is purchased.
     *
     * @param ticket the ticket number to check
     * @return true if the ticket is purchased, false otherwise
     */
    public boolean isTicketPurchased(String ticket) {
        return purchasedTickets.contains(ticket);
    }

    /**
     * Validate a ticket format.
     *
     * @param ticket the ticket number to validate
     * @return true if the ticket is valid, false otherwise
     */
    public boolean isTicketValid(String ticket) {
        return ticket.matches("[A-Z0-9]+"); // Validate ticket format
    }

    /**
     * Check if a ticket is already scanned.
     *
     * @param ticket the ticket number to check
     * @return true if the ticket is already scanned, false otherwise
     */
    public boolean isTicketEntered(String ticket) {
        return enteredTickets.contains(ticket);
    }

    /**
     * Mark a ticket as scanned.
     *
     * @param ticket the ticket number to mark as scanned
     */
    public void markTicketEntered(String ticket) {
        if (!isTicketEntered(ticket)) {
            enteredTickets.add(ticket);
        }
    }

    /**
     * Reset all scanned tickets.
     */
    public void resetTicketEntries() {
        enteredTickets.clear();
    }

    /**
     * Export scanned tickets that are valid.
     *
     * @param filePath the path of the file to export tickets to
     * @throws IOException if an I/O error occurs
     */
    public void exportEnteredTickets(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String ticket : enteredTickets) {
                if (isTicketValid(ticket)) {
                    writer.write(ticket);
                    writer.newLine();
                }
            }
        }
    }

    /**
     * Get all valid tickets from the purchased list.
     *
     * @return a list of all valid tickets
     */
    public List<String> getAllTickets() {
        return new ArrayList<>(purchasedTickets); // Return all valid purchased tickets
    }

    /**
     * Get all scanned tickets.
     *
     * @return a list of all scanned tickets
     */
    public List<String> getEnteredTickets() {
        return new ArrayList<>(enteredTickets);
    }
}
