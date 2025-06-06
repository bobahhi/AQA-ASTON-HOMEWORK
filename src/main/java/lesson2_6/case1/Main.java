package lesson2_6.case1;

public class Main {

    public static Student[] createStudents() {
        int[] grades1 = {4, 5};
        Student s1 = new Student("Иванов", "Группа 1", 1, grades1);

        int[] grades2 = {2, 3};
        Student s2 = new Student("Петров", "Группа 1", 1, grades2);

        int[] grades3 = {3, 3};
        Student s3 = new Student("Васильев", "Группа 2", 2, grades3);

        return new Student[]{s1, s2, s3};
    }

    public static Student[] removeLowPerformers(Student[] students) {
        int count = 0;
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int index = 0;
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                result[index] = student;
                index++;
            }
        }
        return result;
    }

    public static void promotionStudents(Student[] students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.promotion();
            }
        }
    }

    public static void printStudents(Student[] students, int course) {
        System.out.println("Студенты курса " + course + ":");
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
            }
        }
    }

    public static void main(String[] args) {
        Student[] students = createStudents();

        System.out.println("Студенты: ");
        for (Student student : students) {
            System.out.println(student.name + ", курс: " + student.course + " средний балл: " + student.getAverageGrade());
        }

        students = removeLowPerformers(students);

        System.out.println("\nПосле удаления студентов со средним баллом < 3:");
        for (Student student : students) {
            System.out.println(student.name + ", курс: " + student.course + " средний балл: " + student.getAverageGrade());
        }

        promotionStudents(students);

        System.out.println("\nПосле перевода на следующий курс (если средний балл >= 3):");
        for (Student student : students) {
            System.out.println(student.name + " курс: " + student.course);
        }

        System.out.println();
        printStudents(students, 2);
        printStudents(students, 3);
    }
}
