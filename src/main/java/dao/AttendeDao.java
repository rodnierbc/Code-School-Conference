package dao;

import models.Attende;
import models.Conference;
im

public interface AttendeDao {

    void add (Attende attende);
    void addAttendeToConference(Attende attende, Conference conference);

    List<Attende> getAll(); //A
    List<Foodtype> getAllFoodtypesForARestaurant(int restaurantId); //D & E - we will implement this soon.

    Restaurant findById(int id); //B & C

    //update
    void update(int id, String name, String address, String zipcode, String phone, String website, String email); //L

    //delete
    void deleteById(int id); //K
}
