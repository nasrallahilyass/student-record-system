import java.util.ArrayList;
import java.util.HashMap;

public class StudentManager {
    private ArrayList<Student> students;
    private HashMap<String, Student> studentMap;

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

    // Constructors:
    public StudentManager() {
        this.students = new ArrayList<>();
        this.studentMap = new HashMap<>();
    }

    public StudentManager(ArrayList<Student> students, HashMap<String, Student> studentMap) {
        this.students = new ArrayList<>();
        this.studentMap = new HashMap<>();
    }

    // Methods:

    public boolean checkIfStudentExistsById(String studentId) {
        if (studentMap.containsKey(studentId)) {
            System.out.println("Student with id " + studentId + " already exists");
            return true;
        }
        return false;
    }

    public boolean checkIfStudentExistsByEmail(String studentEmail) {
        for (Student student : students) {
            if (student.getEmail().equalsIgnoreCase(studentEmail)) {
                System.out.println("Student with email " + studentEmail + " already exists");
                return true;
            }
        }
        return false;
    }

    // CRUD:

    public void viewListOfStudents() {
        if (students.isEmpty()) {
            System.out.println("####################################################");
            System.out.println("#           No Students Available in the List      #");
            System.out.println("####################################################");
            return;
        }

        System.out.println("##########################################################");
        System.out.println("################### LIST OF STUDENTS #####################");
        System.out.println("##########################################################");
        System.out.printf("%-5s %-20s %-5s %-10s %-25s %-15s%n", "ID", "Name", "Age", "Grade", "Email", "Phone Number");
        System.out.println("----------------------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-5s %-20s %-5d %-10.2f %-25s %-15d%n",
                    student.getId().substring(0, 5), // Displaying the first 5 characters of ID for readability
                    student.getName(),
                    student.getAge(),
                    student.getGrade(),
                    student.getEmail(),
                    student.getPhone());
        }

        System.out.println("##########################################################");
    }

    public void viewStudentById(String studentId) {
        System.out.println("################################################");
        System.out.println("Student By Id:" + studentId + " :");
        if(studentMap.containsKey(studentId)) {
            System.out.println(studentMap.get(studentId));
        } else {
            System.out.println("Student with id " + studentId + " does not exist");
        }
        System.out.println("################################################");
    }

    public void addNewStudent(Student student) {
        if (checkIfStudentExistsById(student.getId())) {
            System.out.println("Student with ID " + student.getId() + " already exists");
            return;
        }

        if (checkIfStudentExistsByEmail(student.getEmail())) {
            System.out.println("Student with email " + student.getEmail() + " already exists");
            return;
        }

        students.add(student);
        studentMap.put(student.getId(), student);
        System.out.println("Student Created Successfully!");
    }

    public void updateStudent(String id, String newName, int newAge, double newGrade, String newEmail, long newPhone){
        if(!studentMap.containsKey(id)) {
            System.out.println("Student with id " + id + " does not exist");
        }

        if(newAge <= 5){
            System.out.println("Invalid age.");
        }

        if(newGrade < 0 && newGrade > 20){
            System.out.println("Please enter a valid grade. Should be between 0 and 20.");
        }

        Student student = studentMap.get(id);

        // Data:
        student.setName(newName);
        student.setAge(newAge);
        student.setGrade(newGrade);
        student.setEmail(newEmail);
        student.setPhone(newPhone);

        System.out.println("Student with ID " + id + " has been successfully updated.");
    }

    public void deleteStudent(String id) {
        if(!studentMap.containsKey(id)) {
            System.out.println("Student with id " + id + " does not exist");
        }
        studentMap.remove(id);
        System.out.println("Student with ID " + id + " has been successfully deleted.");
    }


}