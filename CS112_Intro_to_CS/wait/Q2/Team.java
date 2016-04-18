public class Team 
{  
    private String name=null;
    private int score1=0;
    private int score2=0;
    private int score3=0;
    private int avg;

    
    public void setName(String name)
    {
        this.name=name;
    }
    public void setScore1(int score1)
    
    {
        this.score1 = score1;
    }
    public void setScore2(int score2)
    {
        this.score2 = score2;
    }
    public void setScore3(int score3)
    {
        this.score3 = score3;
    }
    public void avg( int avg )
    {
        avg = (score1+score2+score3)/3;
    }
    public int getAvg()
    {  
	return avg; 
    }
    public int getName()
    {
        return name;
    }
} // end class Team 