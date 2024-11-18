public class Main {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();

        // Adding 10 Students to the StudentManager
        Student student1 = new Student(null, "Alex", 20, 18, "alex.periara@gmail.com", 1222333444);
        Student student2 = new Student(null, "Max", 24, 10, "max.holloway@gmail.com", 1222333555);
        Student student3 = new Student(null, "Ketty Perry", 26, 19, "ketty.perry@gmail.com", 1222333888);
        Student student4 = new Student(null, "Sam Smith", 21, 15, "sam.smith@gmail.com", 1222333999);
        Student student5 = new Student(null, "Lucy Green", 23, 12, "lucy.green@gmail.com", 1222334000);
        Student student6 = new Student(null, "Jake Ryan", 19, 17, "jake.ryan@gmail.com", 1222334111);
        Student student7 = new Student(null, "Olivia Brown", 25, 14, "olivia.brown@gmail.com", 1222334222);
        Student student8 = new Student(null, "Liam White", 22, 13, "liam.white@gmail.com", 1222334333);
        Student student9 = new Student(null, "Emma Stone", 24, 16, "emma.stone@gmail.com", 1222334444);
        Student student10 = new Student(null, "Mia Johnson", 20, 18, "mia.johnson@gmail.com", 1222334555);

        // Adding Students to StudentManager
        sm.addNewStudent(student1);
        sm.addNewStudent(student2);
        sm.addNewStudent(student3);
        sm.addNewStudent(student4);
        sm.addNewStudent(student5);
        sm.addNewStudent(student6);
        sm.addNewStudent(student7);
        sm.addNewStudent(student8);
        sm.addNewStudent(student9);
        sm.addNewStudent(student10);

        // Delete Students:
        sm.deleteStudent(student1.getId());
        sm.deleteStudent(student2.getId());
        sm.deleteStudent(student3.getId());

        // Updating a Student
        sm.updateStudent(student4.getId(), "Alex VIP!", 22, 16, "alex.looks.VIP!@gmail.com", 999999999);

        // Viewing the List of Students
        sm.viewListOfStudents();
    }
}
