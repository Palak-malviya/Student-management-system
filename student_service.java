package studentManagement;

import java.util.ArrayList;
import java.util.List;

public class Studentservice {
    // In-memory storage using ArrayList
    private List<Student> studentList = new ArrayList<>();

    // Create
    public void addStudent(Student s) {
        studentList.add(s);
        System.out.println(">>> Student added successfully!");
    }

    // Read (All)
    public void displayAll() {
        if (studentList.isEmpty()) {
            System.out.println(">>> No records found.");
            return;
        }
        System.out.println("\n--- Current Student List ---");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    // Read (Specific)
    public Student findById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    // Update
    public boolean updateStudent(int id, String newName, int newAge, String newCourse) {
        Student s = findById(id);
        if (s != null) {
            s.setName(newName);
            s.setAge(newAge);
            s.setCourse(newCourse);
            return true;
        }
        return false;
    }

    // Delete
    public boolean deleteById(int id) {
        return studentList.removeIf(s -> s.getId() == id);
    }
}
