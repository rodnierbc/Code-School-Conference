package dao;

import models.Sponsor;
import java.util.List;

public interface SponsorDao {
    //create
    void add(Sponsor sponsor);

    //read
    List<Sponsor> getAll();

    //delete
    void deleteById(int id);

}
