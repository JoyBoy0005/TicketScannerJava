import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;

/**
 * The TicketScanningApp class is the main application for scanning tickets.
 */
public class TicketScanningApp extends Application {

    private TextField barcodeInput;
    private Label statusLabel;
    private Table table;

    @Override
    public void start(Stage stage) {

        // Create the table object to manage ticket data
        table = new Table("codes.txt");

        // Root layout
        VBox root = new VBox();
        root.setSpacing(20);
        root.setPadding(new Insets(15));

        // Title section
        Label title = new Label("Ticket Scanner App");
        title.setFont(new Font("Arial Bold", 24));

        // Barcode input section
        HBox inputPane = new HBox();
        inputPane.setSpacing(10);

        barcodeInput = new TextField();
        barcodeInput.setPromptText("Enter Ticket Number");
        barcodeInput.setPrefWidth(300);

        Button scanButton = new Button("Scan");
        scanButton.setOnAction(this::handleScanButton);

        inputPane.getChildren().addAll(barcodeInput, scanButton);

        // Buttons
        HBox buttonBox = new HBox();
        buttonBox.setSpacing(10);

        Button resetButton = new Button("Reset Tickets");
        resetButton.setOnAction(this::handleResetButton);

        Button exportButton = new Button("Export Tickets");
        exportButton.setOnAction(this::handleExportButton);

        buttonBox.getChildren().addAll(resetButton, exportButton);

        // Status Label
        statusLabel = new Label("Ready to scan.");
        statusLabel.setFont(new Font("Arial", 14));

        // Add everything to the root layout
        root.getChildren().addAll(title, inputPane, buttonBox, statusLabel);

        // Setup the scene and stage
        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Ticket Scanner App");
        stage.setScene(scene);
        stage.show();
    }

    private void handleScanButton(ActionEvent event) {
        String barcode = barcodeInput.getText().trim().toUpperCase();
        if (barcode.isEmpty()) {
            updateStatus("Please enter a ticket number.", Color.ORANGE);
            return;
        }

        if (table.isTicketPurchased(barcode)) {
            if (table.isTicketValid(barcode)) {
                if (!table.isTicketEntered(barcode)) {
                    table.markTicketEntered(barcode);
                    updateStatus("Welcome, access granted for ticket: " + barcode, Color.GREEN);
                } else {
                    updateStatus("Already Scanned ticket: " + barcode, Color.RED);
                }
            } else {
                updateStatus("Invalid ticket: " + barcode, Color.RED);
            }
        } else {
            updateStatus("Ticket not purchased: " + barcode, Color.RED);
        }

        barcodeInput.clear();
    }

    private void handleResetButton(ActionEvent event) {
        table.resetTicketEntries();
        updateStatus("All tickets have been reset.", Color.GRAY);
    }

    private void handleExportButton(ActionEvent event) {
        if (table.getEnteredTickets().isEmpty()) { // Check if there are no tickets to export
            updateStatus("No scanned tickets to export.", Color.ORANGE);
            return;
        }

        try {
            table.exportEnteredTickets("entered_tickets.txt");
            updateStatus("Entered tickets exported successfully.", Color.GREEN);
        } catch (IOException e) {
            updateStatus("Failed to export tickets: " + e.getMessage(), Color.RED);
        }
    }

    private void updateStatus(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setTextFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
