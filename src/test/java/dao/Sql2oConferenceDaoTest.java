package dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.Attende;
import models.Conference;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class Sql2oConferenceDaoTest {
    private Connection conn;
    private Sql2oAttendeDao attendeDao;
    private Sql2oConferenceDao conferenceDao;


    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/conference.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        attendeDao = new Sql2oAttendeDao(sql2o);
        conferenceDao = new Sql2oConferenceDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingConferenceSetsId() throws Exception {
        Conference conference = setupConference();
        conferenceDao.add(conference);
        assertEquals(1, conference.getId());
    }
    public Conference setupConference()  {
        String testDate = "02/04/2018";
        return new Conference(testDate, "Topic", "address", 1,1 );
    }
}