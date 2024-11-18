import java.util.UUID;

public class Student {
    private String id;
    private String name;
    private int age;
    private double grade;
    private String email;
    private long phone;

    // Constructors:
    public Student() {

    }

    public Student(String id, String name, int age, double grade, String email, long phone) {
        this.id = generateUniqueId();
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
        this.phone = phone;
    }

    // Methods:
    private String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    // Getters and Setters:
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}