import java.util.ArrayList;
import java.util.HashMap;

public class StudentManager {
    private ArrayList<Student> students;
    private HashMap<String, Student> studentMap;

    // Constructors:
    public StudentManager() {
        this.students = new ArrayList<>();
        this.studentMap = new HashMap<>();
    }

    public StudentManager(ArrayList<Student> students, HashMap<String, Student> studentMap) {
        this.students = students;
        this.studentMap = studentMap;
    }

    // Getters and Setters:

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public HashMap<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(HashMap<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    // Methods:

    public void viewListOfStudents() {
        if (students.isEmpty()) {
            System.out.println("🔍 No students found in the system. Please add students to view the list.");
        } else {
            System.out.println("==========================================");
            System.out.println("📋 Detailed List of Students");
            System.out.println("==========================================");

            int count = 1;
            for (Student student : students) {
                System.out.println("🔢 Student #" + count + ":");
                System.out.println(student);
                System.out.println("------------------------------------------");
                count++;
            }

            System.out.println("==========================================");
            System.out.println("✅ Total Students: " + students.size());
        }
    }

    public void viewStudentById(String studentId) {
        if (!studentMap.containsKey(studentId)) {
            System.out.println("Student with id " + studentId + " does not exist");
            return;
        }

        System.out.println("Student with id " + studentId + " is:");
        Student student = studentMap.get(studentId);
        System.out.println(student);
    }

    public void searchStudentByName(String studentName) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                System.out.println("Student with name " + studentName + " found:");
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student with name " + studentName + " not found");
        }
    }

    public void addStudent(Student student) {
        if (studentMap.containsKey(student.getId())) {
            System.out.println("Student with id " + student.getId() + " already exists");
            return;
        }

        for (Student existingStudent : students) {
            if (existingStudent.getEmail().equals(student.getEmail())) {
                System.out.println("Student with email " + student.getEmail() + " already exists");
                return;
            }
        }

        students.add(student);
        studentMap.put(student.getId(), student);
        System.out.println("Student added successfully with id: " + student.getId() + "✅");
    }

    public void updateStudentById(String studentId, Student student) {
        if (!studentMap.containsKey(studentId)) {
            System.out.println("Student with id " + studentId + " does not exist");
        }

        Student existingStudent = studentMap.get(studentId);
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setGrade(student.getGrade());
        existingStudent.setAge(student.getAge());

        System.out.println("Student with id " + studentId + " updated successfully ✅");

    }

    public void removeStudent(String studentId) {
        if (!studentMap.containsKey(studentId)) {
            System.out.println("Student with id " + studentId + " does not exist");
            return;
        }

        Student student = studentMap.get(studentId);
        students.remove(student);
        studentMap.remove(studentId);
        System.out.println("Student with id " + studentId + " removed successfully ✅");
    }
}
