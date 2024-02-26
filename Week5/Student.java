
// class Student implements Comparable<Student> {
//     private String name;
//     private String grade; 

//     public Student(String name, String grade) {
//         this.name = name;
//         this.grade = grade;
//     }

//     @Override
//     public int compareTo(Student student) {
//         if (grade.charAt(0) > student.getGrade().charAt(0)) return 1;
//         if (grade.charAt(0) < student.getGrade().charAt(0)) return -1;
//         else {
//             if (grade.charAt(0) == 'F' && grade.contains("X") && student.getGrade().charAt(0) == 'F' && student.getGrade().contains("X")) {
//                 if (rankGrade(grade) < rankGrade(student.getGrade())) return 1;
//                 if (rankGrade(grade) > rankGrade(student.getGrade())) return -1;
//                 if (rankGrade(grade) == rankGrade(student.getGrade())) {
//                     return grade.compareTo(student.getName());
//                 }
     
//             } else if (grade.charAt(0) == 'F' && grade.contains("X") && student.getGrade().charAt(0) == 'F' && !student.getGrade().contains("X")) return -1;
//             else if (grade.charAt(0) == 'F' && !grade.contains("X") && student.getGrade().charAt(0) == 'F' && student.getGrade().contains("X")) return 1;
//             if (rankGrade(grade) < rankGrade(student.getGrade())) return 1;
//             if (rankGrade(grade) > rankGrade(student.getGrade())) return -1;
//             else {
//                 return grade.compareTo(student.getName());
//             }
//         }

//     }

//     private int rankGrade(String grade) {
//         int score = 0;
//         for (int i = 0; i < grade.length(); i++) {
//             if (grade.charAt(i) == '-') score--;
//             if (grade.charAt(i) == '+') score++;
            
//         }
//         return score;
//     }

//     private String getGrade() {
//         return grade;
//     }

//     @Override
//     public String toString() {
//         return name + " " + grade;
//     }

//     public String getName() {
//         return name;
//     }
    
// }