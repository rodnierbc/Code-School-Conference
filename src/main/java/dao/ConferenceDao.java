package dao;

import models.Attende;
import models.Conference;
import java.util.List;
import java.util.Date;

public interface ConferenceDao {
    void add (Conference conference);
    List<Conference> getAll();
    List<Conference> getAllConferencesForAttendees(int attendeId);
    Conference findById(int id);
    void update(int id, Date confDate, String topic, String address, int instructorId, int sponsorId, int attendeesAverageAge, double attendeesAverageSalary, int womenNumber, int menNumber);
    void deleteById(int id);
}
