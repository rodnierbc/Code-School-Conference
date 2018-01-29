package dao;

import models.Attende;
import models.Conference;
import java.util.List;
import java.util.Date;

public interface AttendeDao {
    void add (Attende attende);
    void addAttendeToConference(Attende attende, Conference conference);
    List<Attende> getAll();
    List<Attende> getAllAttendeesForConference(int conferenceId);
    Attende findById(int id);
    void update(int id, String name, String email, String phone, double salary, Date birthdate, String gender);
    void deleteById(int id);
}
