import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Adding some initial students
        studentManager.addStudent(new Student("10001", "John Doe", "johndoe@mail.com", "A", 20));
        studentManager.addStudent(new Student("10002", "Jane Doe", "janedoe@mail.com", "B", 21));
        studentManager.addStudent(new Student("10003", "Alex Smith", "alexsmith@mail.com", "C", 22));
        studentManager.addStudent(new Student("10004", "Alexa Smith", "alexasmith@mail.com", "D", 23));
        studentManager.addStudent(new Student("10005", "Max Holloway", "maxholloway@mail.com", "E", 24));

        System.out.println("Welcome to the Student Management System!");

        while (running) {
            printMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1 -> studentManager.viewListOfStudents();
                case 2 -> viewStudentById(scanner, studentManager);
                case 3 -> searchStudentByName(scanner, studentManager);
                case 4 -> addStudent(scanner, studentManager);
                case 5 -> updateStudent(scanner, studentManager);
                case 6 -> removeStudent(scanner, studentManager);
                case 7 -> {
                    System.out.println("Thank you for using the Student Management System. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println(); // Add space after each action
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("""
                -----------------------------
                Student Management Menu
                -----------------------------
                1. View all students
                2. View student by ID
                3. Search student by name
                4. Add a student
                5. Update a student by ID
                6. Remove a student by ID
                7. Exit
                -----------------------------
                """);
    }

    private static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter your choice: ");
        }
        return scanner.nextInt();
    }

    private static void viewStudentById(Scanner scanner, StudentManager studentManager) {
        scanner.nextLine(); // Clear newline
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        studentManager.viewStudentById(id);
    }

    private static void searchStudentByName(Scanner scanner, StudentManager studentManager) {
        scanner.nextLine(); // Clear newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        studentManager.searchStudentByName(name);
    }

    private static void addStudent(Scanner scanner, StudentManager studentManager) {
        scanner.nextLine(); // Clear newline
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Student Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        Student student = new Student(id, name, email, grade, age);
        studentManager.addStudent(student);
    }

    private static void updateStudent(Scanner scanner, StudentManager studentManager) {
        scanner.nextLine(); // Clear newline
        System.out.print("Enter Student ID to update: ");
        String id = scanner.nextLine();
        System.out.println("Enter updated details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Grade: ");
        String grade = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        Student updatedStudent = new Student("", name, email, grade, age);
        studentManager.updateStudentById(id, updatedStudent);
    }

    private static void removeStudent(Scanner scanner, StudentManager studentManager) {
        scanner.nextLine(); // Clear newline
        System.out.print("Enter Student ID to remove: ");
        String id = scanner.nextLine();
        studentManager.removeStudent(id);
    }
}
