import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Directory {
    String name;
    List<Directory> subdirectories;

    public Directory(String name) {
        this.name = name;
        this.subdirectories = new ArrayList<>();
    }

    public void addSubdirectory(String name) {
        subdirectories.add(new Directory(name));
    }

    public void listSubdirectories() {
        if (subdirectories.isEmpty()) {
            System.out.println("No subdirectories found.");
        } else {
            for (int i = 0; i < subdirectories.size(); i++) {
                System.out.println((i + 1) + ". " + subdirectories.get(i).name);
            }
        }
    }

    public Directory getSubdirectory(int index) {
        return subdirectories.get(index);
    }
}

public class FileDirectoryTree {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Directory root = new Directory("Root");
        Directory currentDirectory = root;
        boolean running = true;

        System.out.println("Welcome to the File Directory Tree Application!");

        while (running) {
            System.out.println("\nCurrent Directory: " + currentDirectory.name);
            System.out.println("1. Create Subdirectory");
            System.out.println("2. List Subdirectories");
            System.out.println("3. Navigate to Subdirectory");
            System.out.println("4. Go Back");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter subdirectory name: ");
                    String name = scanner.nextLine();
                    currentDirectory.addSubdirectory(name);
                    System.out.println("Subdirectory created.");
                    break;

                case 2:
                    System.out.println("Subdirectories:");
                    currentDirectory.listSubdirectories();
                    break;

                case 3:
                    System.out.println("Subdirectories:");
                    currentDirectory.listSubdirectories();
                    System.out.print("Enter subdirectory number to navigate: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < currentDirectory.subdirectories.size()) {
                        currentDirectory = currentDirectory.getSubdirectory(index);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 4:
                    if (!currentDirectory.name.equals("Root")) {
                        currentDirectory = root; 
                        System.out.println("Moved back to Root.");
                    } else {
                        System.out.println("Already at Root.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
