/**
 * For human players.
 * Have typical attributes & behaviours for Human player
 * @author Leo
 * @version 13.03.2018
 */
public class Human extends Player
{
    // HumanAbandonNumber, default as "999"
    private int humanAbandonNum;
    // Identification the input of human if in the vaild range
    private boolean inRangeInputFlag;
    
    public Human()
    {
    }
    
    public Human(String name)
    {
        playerName = name;
        score = 0;
        lastGuessesNum = 0;
        humanAbandonNum = 999;
        inRangeInputFlag = true;
    }
    
    public void setHumanAbandonNum(int abandonNum)
    {
        humanAbandonNum = abandonNum;
    }
    
    public int getHumanAbandonNum()
    {
        return humanAbandonNum;
    }
    
    public void setInRangeInputFlag(boolean flag)
    {
        inRangeInputFlag = flag;
    }
    
    public boolean getInRangeInputFlag()
    {
        return inRangeInputFlag;
    }
}
