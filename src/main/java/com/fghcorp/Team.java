package com.fghcorp;

import java.util.Objects;
import java.util.StringJoiner;

public class Team  {
    private String name;
    private int wins;
    private int losses;

    public Team(String name) {
       this.name = name;
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
}
