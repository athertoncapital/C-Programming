import java.util.Scanner;

public class TeamTest
{
    public static void main(String[] args)
    {
        
        Team TeamName = new setTeam("null");
        System.out.printf("Team: %n%s average score: %d%n", TeamName.getName(),TeamName.getAvg());
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the team's name:");
        String theName= input.nextLine();
        TeamName.setName(theName);
        //System.out.println();
        
        Team Score1 = new setScore1(0.0);
        System.out.printf("Please enter the team's first score: %n");
        Scanner inputscore01 = new Scanner(System.in);
        int score1=inputscore01.nextLine();
        Score1.setScore1(score1);
    
        Team Score2 = new setScore1(0.0);
        System.out.printf("Please enter the team's second score: %n");
        Scanner inputscore02 = new Scanner(System.in);
        int score1=inputscore02.nextLine();
        Score2.setScore2(score2);
        
        Team Score3 = new setScore1(0.0);
        System.out.printf("Please enter the team's third score: %n");
        Scanner inputscore03 = new Scanner(System.in);
        int score3=inputscore03.nextLine();
        Score3.setScore3(score3);
        
        System.out.printf("Team: %n%s; average score: %d%n", TeamName.getName(), TeamName.getAvg());

        
    }
}