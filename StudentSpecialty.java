
public class StudentSpecialty {

    private String specialtyName;

    private String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.setSpecialtyName(specialtyName);
        this.setFacultyNumber(facultyNumber);
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    private void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    private void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }
}
