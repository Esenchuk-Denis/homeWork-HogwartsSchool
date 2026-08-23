package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
  //  private HashMap<Long, Faculty> faculties = new HashMap<>();
  //  private Long count = 0l;
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    //CRUD

    //POST-create
    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    //GET-read
    public Faculty findFaculty(Long id) {
        return facultyRepository.getById(id);
    }

    //PUT-update
    public Faculty editFaculty(Long id, Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    //DELETE-delete
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

//    @Override
//    public Collection<Faculty> getFacultiesByColor(String color) {
//        return faculties.values().stream()
//                .filter(f -> f.getColor() != null && f.getColor().equalsIgnoreCase(color))
//               .collect(Collectors.toList());
//    }

    public List<Faculty> findByColor(String color) {
        return facultyRepository.findByColor(color);
    }
}
