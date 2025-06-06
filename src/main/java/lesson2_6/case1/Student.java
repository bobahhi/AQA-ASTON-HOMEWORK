package lesson2_6.case1;

public class Student {
    String name;
    String group;
    int course;
    int[] grades;

    public Student(String name, String group, int course, int[] grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;

    }

    public double getAverageGrade() {
        if (grades.length == 0) return 0;
        int sum = 0;
        for (int index = 0; index < grades.length; index++) {
            sum += grades[index];
        }
        return (double) sum / grades.length;
    }

    public void promotion() {
        this.course++;
    }
}
