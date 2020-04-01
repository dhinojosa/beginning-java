package com.fghcorp;

import java.util.Objects;
import java.util.StringJoiner;

public class Team implements Comparable<Team> {
    private String name;
    private int wins;
    private int losses;
    private int rank;
    private static int count;

    public Team(String name) {
        count += 1;
        this.name = name;
    }

    public Team(int rank, String name) {
        this(name);
        this.rank = rank;
    }

    public static int getCount() {
        return count;
    }

    //static method factory!
    public static Team create(String name, int rank) {
        //complicated logical,
        //creating object graph,
        //complicated setup,
        //complicated validation
        return new Team(rank, name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Team.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .toString();
    }

    public void win() {
       this.wins += 1;
    }

    public String getRecord() {
        return String.format("%d-%d", wins, losses);
    }

    public void loss() {
       this.losses += 1;
    }

    @Override
    public int compareTo(Team o) {
        return Integer.compare(this.rank, o.rank);
    }
}
