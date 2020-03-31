package com.fghcorp;

import com.xyzcorp.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void testGetName() {
        Team team = new Team("Seattle Sounders");
        assertEquals("Seattle Sounders", team.getName());
    }

    @Test
    public void testTeamEquality() {
        Team team = new Team("Seattle Sounders");
        Team team2 = new Team("Seattle Sounders");
        assertEquals(team, team2);
    }
    
    @Test
    public void testTeamEqualityWithAnotherObject() {
        Team team = new Team("Seattle Sounders");
        Person person = new Person("Albert", "Einstein");
        assertFalse(team.equals(person));
    }
}
