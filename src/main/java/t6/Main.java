package t6;
/**
 * Напишите методы Equals and HashCode для класса Student, который состоит из полей String name и int age.
 */

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Main.Student student=new Student("Иван",25);
        Main.Student student2=new Student("Марья",25);
        Main.Student student3=new Student("Иван",25);
        System.out.println(student.equals(student2));
        System.out.println(student.equals(student3));

    }

    private static class Student{
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
