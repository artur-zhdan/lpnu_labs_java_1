package ua.lviv.iot.algo.part1.crocodileApp;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stadium {
    private String name;
    private int capacity;
    private int currentAttendance;
    private String homeTeam;
    private String awayTeam;

    private static Stadium instance = new Stadium();

    public static Stadium getInstance() {
        if (instance == null) {
            instance = new Stadium();
        }
        return instance;
    }

    public void addAttendies(int count) {
        int remainingCapacity = capacity - currentAttendance;
        if (count <= remainingCapacity) {
            currentAttendance += count;
        } else {
            System.out.println("Not enough available seats.");
        }
    }

    public void decreaseAttendance() {
        if (currentAttendance >= 100) {
            currentAttendance -= 100;
        } else {
            currentAttendance = 0;
        }
    }

    public void changeHomeTeam(String teamName) {
        homeTeam = teamName;
    }

    public void changeAwayTeam(String teamName) {
        awayTeam = teamName;
    }

    public static void main(String[] args) {
        Stadium[] stadiums = new Stadium[4];

        stadiums[0] = new Stadium();
        stadiums[1] = new Stadium("Camp Nou", 99354, 50000, "FC Barcelona", "Real Madrid");
        stadiums[2] = Stadium.getInstance();
        stadiums[3] = Stadium.getInstance();



        for (Stadium stadium : stadiums) {
            System.out.println(stadium);
        }
    }
}

