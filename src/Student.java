public class Student {
    private String id, name, email, grade;
    private int age;


    public Student() {
    }

    public Student(String id, String name, String email, String grade, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.age = age;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "👩‍🎓 Student { %n" +
                        "    🆔 ID: '%s', %n" +
                        "    📛 Name: '%s', %n" +
                        "    📧 Email: '%s', %n" +
                        "    🏅 Grade: '%s', %n" +
                        "    🎂 Age: %d %n" +
                        "}",
                id, name, email, grade, age
        );
    }

}
