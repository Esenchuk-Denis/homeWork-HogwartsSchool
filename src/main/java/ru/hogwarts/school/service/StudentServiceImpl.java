package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

//    private final HashMap<Long, Student> students = new HashMap<>();
//    private long studId = 0l;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    //CRUD

    //POST-create
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    //GET-read
    public Student findStudent(Long id) {
        return studentRepository.getById(id);
    }



    //PUT-update
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    //DELETE-delete
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> getAllStudent() {
        return studentRepository.findAll();
    }


    //    public Collection<Student> getStudentByAge(int age) {
//        return students.values().stream().filter(s->s.getAge() == age).collect(Collectors.toList());
//    }
    public List<Student> findByAge(int age) {
        return studentRepository.findByAge(age);
    }


}
