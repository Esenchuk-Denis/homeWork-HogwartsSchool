package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private HashMap<Long, Faculty> faculties = new HashMap<>();
    private Long count = 0l;


    //CRUD

    //POST-create
    public Faculty addFaculty(Faculty faculty) {
        faculty.setId(count++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    //GET-read
    public Faculty findFaculty(long id) {
        return faculties.get(id);
    }

    //PUT-update
    public Faculty editFaculty(long id, Faculty faculty) {
        if (!faculties.containsKey(id)) {
            return null;
        }
        faculties.put(id, faculty);
        return faculty;
    }

    //DELETE-delete
    public Faculty deleteFaculty(long id) {
      //  faculties.remove(id);
        return faculties.remove(id);
    }

    @Override
    public Collection<Faculty> getFacultiesByColor(String color) {
        return faculties.values().stream()
                .filter(f -> f.getColor() != null && f.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

}
