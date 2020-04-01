package com.fghcorp;

class StaticExample {
    public static void main(String[] args) {
        Team a = new Team("Minneapolis Twins");
        Team b = new Team("Kansas City Royals");
        Team c = new Team("Washington Nationals");
        System.out.println(Team.getCount());
    }
}
