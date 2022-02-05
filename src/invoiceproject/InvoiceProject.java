//Student name: Olame Akim Muliri
//Lab Section:001
package invoiceproject;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author olamemuliri
 */
public class InvoiceProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        Random rand = new Random();
        char additionalItemValidation = 'y';
        int receiptNumber = rand.nextInt(900)+100;
        double total = 0;
        PrintWriter outFile = new PrintWriter("receipt_"+receiptNumber+".txt");
        outFile.println("========================================");
        outFile.println("\tWelcome to Walmart");        
        outFile.println("========================================");
        outFile.printf("%-10s%5s%10s%10s\n","name","quantity","price","Total");
        outFile.println("----------------------------------------");
        while(additionalItemValidation == 'y' || additionalItemValidation == 'Y')
        { 
            Scanner in = new Scanner(System.in);
            System.out.print("Item: ");
            String itemName = in.next();
            System.out.print("Quantity: ");
            int itemQuantity = in.nextInt();
            System.out.print("Price: ");
            double itemPrice = in.nextDouble();
            outFile.printf("%-13s%-10d$%-9.2f$%-10.2f\n",itemName,itemQuantity,itemPrice,itemQuantity*itemPrice);
            total+=itemQuantity*itemPrice;
            System.out.println("\nPress 'y' to enter a new item. Press anyother key to quit.");
            additionalItemValidation = in.next().charAt(0);
        }
        outFile.println("----------------------------------------");
        outFile.printf("%33s$%-10.2f\n","Your total is ",total);
        outFile.printf("%33s$%-10.2f\n","Tax: ",total*1.09);
        outFile.println("========================================");
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy MM dd - hh:mm:ss a");
        String currentDateTimeFormatted = currentDateTime.format(formatter);
        System.out.printf("receipt_%d has been issued on %s.\n", receiptNumber, currentDateTimeFormatted);
        outFile.close();
        
    }
    
}
