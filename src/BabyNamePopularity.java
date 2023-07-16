/**
 * Objective: Create a program that will search for popular baby names from 2001-2010 and tell you the ranking of that year.
 *Input and Output:Input birth year, M or F, and name. Output will show you the ranking of that year.
 * Created by: Lacy Castolenia
 * Date:7/15/2023
 * Version: 1
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNamePopularity {

    public static void main(String[] args) {
        // Prompt the user for input
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Enter the year (2001-2010): ");
            int year = in.nextInt();
            System.out.print("Enter the gender (M/F): ");
            String gender = in.next();
            System.out.print("Enter the name: ");
            String name = in.next();

            // Build the filename based on the input year
            String filename = "names/babynameranking" + year + ".txt";

            // Open the file
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            // Search for the name and gender in the file
            int rank = 0;
            boolean found = false; // Flag to track if a match is found
            while (fileScanner.hasNextLine()) {
                rank++;
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String currentName = parts[0];
                String currentGender = parts[1];
                if (currentName.equalsIgnoreCase(name) && currentGender.equalsIgnoreCase(gender)) {
                    System.out.println("The name " + name + " is ranked #" + rank + " in " + year);
                    found = true;
                    break;
                }
            }

            // If no match is found, display the message
            if (!found) {
                System.out.println("The name " + name + " is not ranked in year " + year);
            }

            // Close the file
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } finally {
            // Close the scanner
            in.close();
        }
    }
}
