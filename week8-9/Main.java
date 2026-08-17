import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== ADD TASKS =====");

        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter Task " + i + ": ");
            tasks.add(scanner.nextLine());
        }

        System.out.println("\n===== TASK LIST =====");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }

        // Save tasks to a text file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("task.txt"))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
            System.out.println("\nTasks saved successfully.");
        } catch (IOException e) {
            System.out.println("Unable to save tasks: " + e.getMessage());
        }

        // Read tasks from the text file.
        System.out.println("\n===== TASKS LOADED FROM FILE =====");
        try (BufferedReader reader = new BufferedReader(new FileReader("task.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Unable to read tasks: " + e.getMessage());
        }

        scanner.close();
    }
}
