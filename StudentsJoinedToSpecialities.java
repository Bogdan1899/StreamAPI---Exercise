import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentsJoinedToSpecialities {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        List<StudentSpecialty> specialities = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        String input = bfr.readLine();

        while (!input.equals("Students:")){
            String[] inputArgs = input.trim().split("\\s+");
            StudentSpecialty studentSpecialty = new StudentSpecialty(inputArgs[0] + " " + inputArgs[1], inputArgs[2]);
            specialities.add(studentSpecialty);

            input = bfr.readLine();
        }

        input = bfr.readLine();

        while (!input.equals("END")){
            String[] inputArgs = input.trim().split("\\s+");
            Student student = new Student(inputArgs[1] + " " + inputArgs[2], inputArgs[0]);
            students.add(student);

            input = bfr.readLine();
        }

        students.sort(Comparator.comparing(Student::getName));

        for (Student student : students) {
            for (StudentSpecialty speciality : specialities) {
                if (student.getFacultyNumber().equals(speciality.getFacultyNumber())){
                    System.out.printf("%s %s %s\n", student.getName(), student.getFacultyNumber(), speciality.getSpecialtyName());
                }
            }
        }
    }
}
