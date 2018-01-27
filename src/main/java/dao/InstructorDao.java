package dao;

import models.Instructor;
import java.util.List;

public interface InstructorDao {
    //create
    void add(Instructor instructor);

    //read
    List<Instructor> getAll();

    //delete
    void deleteById(int id);

}
