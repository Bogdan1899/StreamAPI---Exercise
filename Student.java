
public class Student implements Comparable<Student>{

    private String name;

    private String facultyNumber;

    public Student(String name, String facultyNumber) {
        this.setName(name);
        this.setFacultyNumber(facultyNumber);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}
