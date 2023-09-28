package t14;
/**
 * Дан класс User, который содержит поля с именем и возрастом. Необходимо реализовать следующий метод:
 *
 * На входе коллекция — пользователей.
 * Необходимо удалить все дубли (одинаковое имя и возраст).
 * Отсортировать по возрасту и имени.
 * Вернуть самого старого пользователя.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Иван", 25);
        Student student2 = new Student("Марья", 45);
        Student student3 = new Student("Иван", 25);
        Student student4 = new Student("Марья", 25);
        Student student5 = new Student("Яковлева", 18);

        List<Student> list=new ArrayList<>(List.of(student,student2,student3,student4,student5));

        Comparator<Student> comparatorAge= Comparator.comparingInt(o -> o.age);
        Comparator<Student> comparatorName= Comparator.comparing(Student::getName);
        Comparator<Student> comparatorByAgeByName=comparatorAge.thenComparing(comparatorName);

        list=list.stream().distinct().sorted(comparatorByAgeByName).collect(Collectors.toList());
        System.out.println(list);
        // самый старый студент
        System.out.println(list.get(list.size()-1));
    }


    private static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
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

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
