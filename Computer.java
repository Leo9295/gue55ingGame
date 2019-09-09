/**
 * For computer players.
 * Have typical attributes & behaviours for Computer player
 * @author Leo
 * @version 13.03.2018
 */
public class Computer extends Player
{
    // computerAbandonNumber 
    private int computerAbandonNum;
    
    /**
     * Initializing the detail of computer player
     */
    public Computer()
    {
        playerName = "Computer Player";
        score = 0;
        lastGuessesNum = 0;
    }
    
    public void setComputerAbandonNum(int abandonNum)
    {
        this.computerAbandonNum = abandonNum;
    }
    
    public int getComputerAbandonNum()
    {
        return computerAbandonNum;
    }

}
