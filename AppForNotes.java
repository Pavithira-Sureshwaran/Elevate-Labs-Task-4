import java.io.*;
import java.util.Scanner;

public class AppForNotes {
    private static String fileName= "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("--- Notes App ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addingNote(scanner);
                    System.out.println();
                    break;
                case 2:
                    viewTheNotes();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Exiting the app");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();

            }
        } while (choice != 3);

        scanner.close();
    }

  static void addingNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();

        try  {
            FileWriter fw=new FileWriter(fileName,true);
            fw.write(note + System.lineSeparator());
            System.out.println("Note added successfully.");
            System.out.println();
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the note: " + e.getMessage());
        }
    }

   static void viewTheNotes() {
    
        try  {
            FileReader fr=new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(" " + line);
            }
        fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Start by adding a note.");
        } 
        catch (IOException e) {
            System.out.println("An error occurred while reading the notes: " + e.getMessage());
        }
       
    }
}
