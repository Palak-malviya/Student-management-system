package studentManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Studentservice service = new Studentservice();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student (by ID)");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: "); int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Age: "); int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Course: "); String course = sc.nextLine();
                    service.addStudent(new Student(id, name, age, course));
                    break;
                case 2:
                    service.displayAll();
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Student found = service.findById(searchId);
                    System.out.println(found != null ? found : ">>> Student not found.");
                    break;
                case 4:
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: "); String upName = sc.nextLine();
                    System.out.print("New Age: "); int upAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: "); String upCourse = sc.nextLine();
                    if(service.updateStudent(upId, upName, upAge, upCourse)) 
                        System.out.println(">>> Updated successfully.");
                    else System.out.println(">>> ID not found.");
                    break;
                case 5:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    if(service.deleteById(delId)) System.out.println(">>> Deleted successfully.");
                    else System.out.println(">>> ID not found.");
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
