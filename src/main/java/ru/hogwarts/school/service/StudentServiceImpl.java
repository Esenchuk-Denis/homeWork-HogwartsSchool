package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final HashMap<Long, Student> students = new HashMap<>();
    private long studId = 0l;


    //CRUD

    //POST-create
    public Student createStudent(Student student) {
        student.setId(++studId);
        students.put(studId, student);
        return student;
    }

    //GET-read
    public Student findStudent(long id) {
        return students.get(id);
    }



    //PUT-update
    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    //DELETE-delete
    public Student deleteStudent(long id) {
      //  students.remove(id);
        return students.remove(id);
    }

    public Collection<Student> getAllStudent() {
        return students.values();
    }



    public Collection<Student> getStudentByAge(int age) {
        return students.values().stream().filter(s->s.getAge() == age).collect(Collectors.toList());

    }



}
