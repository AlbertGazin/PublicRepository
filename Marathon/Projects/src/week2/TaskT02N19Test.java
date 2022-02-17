package week2;

import static util.Assert.assertEquals;

public class TaskT02N19Test {
    public static void main(String[] args) {
        testScore1();
        testScore2();
        testResult1();
        testResult2();
        testResult3();
    }

    public static void testScore1() {
        Game game = new Game();
        game.setTeamNumber(1);
        assertEquals("Week2.TaskT02N19Test.testScore1", "Team #1 has " + 3 + " score(s) and team #2 has " + 0 + " score(s)", game.score(3));
    }

    public static void testScore2() {
        Game game = new Game();
        game.setTeamNumber(2);
        assertEquals("Week2.TaskT02N19Test.testScore2", "Team #1 has " + 0 + " score(s) and team #2 has " + 2 + " score(s)", game.score(2));
    }

    public static void testResult1() {
        Game game = new Game();
        game.setTeamOneName("Team1");
        game.setTeamTwoName("Team2");
        game.setTeamOneScore(2);
        game.setTeamTwoScore(3);
        assertEquals("Week2.TaskT02N19Test.testResult1", "Team1 has " + 2 + " score(s); Team2 has " + 3 + " score(s). Team2 wins !", game.result());
    }

    public static void testResult2() {
        Game game = new Game();
        game.setTeamOneName("Team1");
        game.setTeamTwoName("Team2");
        game.setTeamOneScore(2);
        game.setTeamTwoScore(1);
        assertEquals("Week2.TaskT02N19Test.testResult2", "Team1 has " + 2 + " score(s); Team2 has " + 1 + " score(s). Team1 wins !", game.result());
    }

    public static void testResult3() {
        Game game = new Game();
        game.setTeamOneName("Team1");
        game.setTeamTwoName("Team2");
        game.setTeamOneScore(2);
        game.setTeamTwoScore(2);
        assertEquals("Week2.TaskT02N19Test.testResult3", "Team1 has " + 2 + " score(s); Team2 has " + 2 + " score(s). Friendship wins !", game.result());
    }
}
