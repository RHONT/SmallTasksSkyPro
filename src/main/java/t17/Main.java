package t17;
/**
 *  Создать метод, который преобразует массив объектов User (c полями name, age, phone) в карту Номер телефона -› Имя пользователя.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Иван", 25,"1");
        Student student2 = new Student("Марья", 45,"2");
        Student student3 = new Student("Иван", 25,"3");
        Student student4 = new Student("Марья", 25,"4");
        Student student5 = new Student("Яковлева", 18,"5");

        List<Student> list=new ArrayList<>(List.of(student,student2,student3,student4,student5));

        Map<String,String> result=list.stream().collect(Collectors.toMap(Student::getPhone, Student::getName));

        System.out.println(result);

    }


    private static class Student {
        private String name;
        private int age;
        private String phone;

        public Student(String name, int age, String phone) {
            this.name = name;
            this.age = age;
            this.phone = phone;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name) && Objects.equals(phone, student.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, phone);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }
}
