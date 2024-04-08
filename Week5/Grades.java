import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;

public class Grades {
    public static void main(String[] args) throws FileNotFoundException  {
        File file = new File("Week5\\file.txt");
        Scanner sc = new Scanner(file);
        
        int nStud = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[nStud];
        String[] input; 
        for(int i = 0; i < nStud; i++) {
            input = sc.nextLine().split(" ");
            students[i] = new Student(input[0],input[1]);
        }

        for(int i = 1; i < nStud; i++) {
            for (int j = i; j > 0; j--) {
                if(students[j-1].compareTo(students[j]) > 0) {
                    Student temp = students[j-1];
                    students[j-1] = students[j];
                    students[j] = temp;
                } else {
                    break;
                }
            }
        }

        for (Student student : students) {
            System.out.println(student);
        }


    }
    
}


class Student implements Comparable<Student> {
    private String name;
    private String grade; 

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student student) {
        if (grade.charAt(0) > student.getGrade().charAt(0)) return 1;
        if (grade.charAt(0) < student.getGrade().charAt(0)) return -1;
        else {
            if (grade.charAt(0) == 'F' && grade.contains("X") && student.getGrade().charAt(0) == 'F' && student.getGrade().contains("X")) {
                if (rankGrade(grade) < rankGrade(student.getGrade())) return 1;
                if (rankGrade(grade) > rankGrade(student.getGrade())) return -1;
                if (rankGrade(grade) == rankGrade(student.getGrade())) {
                    return name.compareTo(student.getName());
                }
     
            } else if (grade.charAt(0) == 'F' && grade.contains("X") && student.getGrade().charAt(0) == 'F' && !student.getGrade().contains("X")) return -1;
            else if (grade.charAt(0) == 'F' && !grade.contains("X") && student.getGrade().charAt(0) == 'F' && student.getGrade().contains("X")) return 1;
            if (rankGrade(grade) < rankGrade(student.getGrade())) return 1;
            if (rankGrade(grade) > rankGrade(student.getGrade())) return -1;
            else {
                return name.compareTo(student.getName());
            }
        }

    }

    private int rankGrade(String grade) {
        int score = 0;
        for (int i = 0; i < grade.length(); i++) {
            if (grade.charAt(i) == '-') score--;
            if (grade.charAt(i) == '+') score++;
            
        }
        return score;
    }

    private String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
    
}