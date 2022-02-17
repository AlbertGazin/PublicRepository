package week2;

import java.util.Scanner;

public class TaskT02N19 {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}

class Game {
    private int teamOneScore = 0;
    private int teamTwoScore = 0;
    private String teamOneName;
    private String teamTwoName;
    private int teamNumber;

    public void setTeamOneName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter team #1 name :");
        teamOneName = scanner.nextLine();
    }

    public void setTeamTwoName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter team #2 name :");
        teamTwoName = scanner.nextLine();
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public String getTeamOneName() {
        return this.teamOneName;
    }

    public String getTeamTwoName() {
        return this.teamTwoName;
    }

    public void setTeamNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter team to score (1 or 2 or 0 to finish game) :");
        teamNumber = scanner.nextInt();
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public int setScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter score (1, 2 or 3) :");
        return scanner.nextInt();
    }

    public void setTeamOneScore(int teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public void setTeamTwoScore(int teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }

    public int getTeamOneScore() {
        return teamOneScore;
    }

    public int getTeamTwoScore() {
        return teamTwoScore;
    }

    void play() {
        setTeamOneName();
        setTeamTwoName();
        while (true) {
            setTeamNumber();
            if (teamNumber != 1 && teamNumber != 2 && teamNumber != 0) {
                System.out.println("You should enter valid team number ( 1 or 2 or 0 to finish game)");
                continue;
            }
            if (teamNumber == 0) {
                System.out.println(result());
                break;
            } else {
                int score = setScore();
                if (score != 1 && score != 2 && score != 3) {
                    System.out.println("Score should be positive (1, 2 or 3)");
                    continue;
                }
                System.out.println(score(score));
            }
        }
    }

    String score(int score) {
        if (teamNumber == 1) {
            teamOneScore = teamOneScore + score;
        } else {
            teamTwoScore = teamTwoScore + score;
        }
        return "Team #1 has " + teamOneScore + " score(s) and team #2 has " + teamTwoScore + " score(s)";
    }

    String result() {
        String whoWins = "";
        if (teamOneScore == teamTwoScore) {
            whoWins = "Friendship wins !";
        } else if (teamOneScore > teamTwoScore) {
            whoWins = teamOneName + " wins !";
        } else {
            whoWins = teamTwoName + " wins !";
        }
        return teamOneName + " has " + teamOneScore + " score(s)" + "; " +
                teamTwoName + " has " + teamTwoScore + " score(s)" + ". " + whoWins;
    }
}
