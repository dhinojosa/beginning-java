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

    @Test
    public void testThatTwoEqualItemsHaveTheSameHash() {
        Team team = new Team("Seattle Sounders");
        Team team2 = new Team("Seattle Sounders");
        assertEquals(team.hashCode(), team2.hashCode());
    }

    @Test
    public void testToString() {
        Team team = new Team("Seattle Sounders");
        assertEquals("Team[name='Seattle Sounders']", team.toString());
    }

    @Test
    public void testGiveTeamAWin() {
        Team team = new Team("Seattle Sounders");
        team.win();
        assertEquals("1-0", team.getRecord());
    }

    @Test
    public void testGiveTeamATwoWins() {
        Team team = new Team("Seattle Sounders");
        team.win();
        team.win();
        assertEquals("2-0", team.getRecord());
    }

    @Test
    public void testGiveTeamATwoWinsAndALoss() {
        Team team = new Team("Seattle Sounders");
        team.win();
        team.win();
        team.loss();
        assertEquals("2-1", team.getRecord());
    }
}
