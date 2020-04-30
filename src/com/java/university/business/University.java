package com.java.university.business;

import com.java.university.business.util.Input;
import com.java.university.persistence.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class University extends Common {
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();

    public University(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {

            System.out.println(getName());
    }

    public void displayTeachers() {
        System.out.println("List of teachers");
        for (Teacher teachers : teacherList) {
            teachers.displayInfo();
        }

    }
    public void displayCourses(){
        System.out.println("List");
        for (Course courses: courseList) {
            courses.displayInfo();

        }
    }

    public void displayCourses(String courseName){
        System.out.println("List");
        Course course = findCourse(courseName);
        if (course == null){
            System.out.println("There is no data to display");
            return;
        }
        course.displayInfo();
        Teacher teacher = course.getTeacher();
        if (teacher != null){
            teacher.displayInfo();
        }
        List <Student> students = course.getStudentList();
        for (Student studentCourse: students) {
            studentCourse.displayInfo();
        }
    }

    public void addStudent(){
        System.out.println("Please enter the Course Name");
        String courseName = Input.next();
        Course course = findCourse(courseName);
        if (course == null){
            System.out.println("The course does not exist");
            return;
        }
        System.out.println("Please enter the Student's ID");
        String id = Input.next();
        Student studentFound = findStudent(id);
        if (studentFound != null){
            System.out.println("the Student already exists");
            return;
        }
        System.out.println("Please enter the Student's name");
        String name = Input.next();
        Student student = new Student(name);
        System.out.println("Please enter the Student's age");
        int age = Input.nextInt();
        student.setAge(age);

        student.setId(id);
        student.addCourse(course);
        course.addStudent(student);
        studentList.add(student);
    }
    public void addStudent(Student student){
        studentList.add(student);
    }

    public void addTeacher(){
        System.out.println("Please enter the Teacher's name");
        String teacherName = Input.next();
        Teacher teacher =findTeacher(teacherName);
        if (teacher != null){
            System.out.println("The teacher already exists");
            return;
        }
        System.out.println("Please enter the Teacher's type: F (full time), P (part time)");
        String  type = Input.next();
        if (type.equalsIgnoreCase("F")){
            System.out.println("Please enter the Salary");
            double salary = Input.nextInt();
            TeacherFullTime teacherFull = new TeacherFullTime(teacherName,salary);
            System.out.println("Please enter experience years");
            int years = Input.nextInt();
            teacherFull.setYears(years);
            teacherFull.calculateSalary();
            teacherList.add(teacherFull);
        }else{
            System.out.println("Please enter the Base Salary");
            double salary = Input.nextInt();
            TeacherPartTime teacherPart = new TeacherPartTime(teacherName,salary);
            System.out.println("Please enter the active hours");
            int hours = Input.nextInt();
            teacherPart.setActiveHours(hours);
            teacherPart.calculateSalary();
            teacherList.add(teacherPart);
        }

    }

    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }

    public void addCourse(){
        System.out.println("Please enter the Course Name");
        String courseName = Input.next();
        Course course = findCourse(courseName);
        if (course != null){
            System.out.println("The course already exists");
            return;
        }
        course = new Course(courseName);
        System.out.println("Please enter the classroom");
        String classroom = Input.next();
        course.setClassroom(classroom);
        System.out.println("Please enter the Teacher's name");
        String teacherName = Input.next();
        Teacher teacher = findTeacher(teacherName);
        if (teacher == null){
            System.out.println("The teacher does not exist");
            return;
        }
        course.setTeacher(teacher);
        System.out.println("Please enter the Student's ID");
        String id = Input.next();
        Student studentFound = findStudent(id);
        if (studentFound == null){
            System.out.println("The Student does not exist");
            return;
        }
        course.addStudent(studentFound);
        courseList.add(course);
    }
    public void addCourse(Course course){
        courseList.add(course);
    }

    public Course findCourse(String courseName){
        for (Course courses: courseList) {
            if (Objects.equals(courseName.toLowerCase(),courses.getName().toLowerCase())) {
               return courses;
            }

        }
        return null;
    }
    public Student findStudent(String id){
        for (Student student: studentList) {
            if (id.equalsIgnoreCase(student.getId())){
                return student;
            }
        }
        return null;
    }

    public Teacher findTeacher(String name){
        for (Teacher teacher: teacherList) {
            if (name.equalsIgnoreCase(teacher.getName())){
                return teacher;
            }
        }
        return null;
    }
    public void displayStudent(){
        System.out.println("Please enter the Student's ID");
        String id = Input.next();
        Student studentFound = findStudent(id);
        if (studentFound == null){
            System.out.println("The Student does not exist");
            return;
        }
        studentFound.displayInfo();
        List <Course> listCourses = studentFound.getCourseList();
        for (Course course: listCourses) {
            course.displayInfo();
        }
    }
}
