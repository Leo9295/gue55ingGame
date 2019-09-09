 /**
 * Abstract class Player
 * Have all common attributes & behaviours for both players
 * @author Leo
 * @version 24.03.2018
 */
public abstract class Player
{
    // The name of player
    public String playerName;
    // The total score of player awarded
    public int score;
    // The number that last time guessed by player
    public int lastGuessesNum;
    // The flag shows if the player abandon the game
    public boolean abandonFlag;
    
    public Player(){}
    
    /**
     * Method display
     * 
     * For display all fields on the screen
     * Never use this method in program
     */
    public void display()
    {
        System.out.println("Player's Name is " + playerName);
        System.out.println("Player's Score is " + score);
        System.out.println("The Number of Player's Last time guesses is " + lastGuessesNum);
    }
    
    /**
     * Method setPlayerName
     *
     * @param nameFromInput
     */
    public void setPlayerName(String nameFromInput)
    {
        this.playerName = nameFromInput;
    }
        
    /**
     * Method getPlayerName
     *
     * @return playerName
     */
    public String getPlayerName()
    {
        return playerName;
    }
    
    /**
     * Method setScore
     *
     * @param newScore
     */
    public void setScore(int newScore)
    {
        this.score = score + newScore;
    }
    
    /**
     * Method getScore
     *
     * @return score
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * Method setLastGuessesNum
     *
     * @param guessingNum
     * update in every turn
     */
    public void setLastGuessesNum(int guessingNum)
    {
        this.lastGuessesNum = guessingNum;
    }
    
    /**
     * Method getLastGuessesNum
     *
     * @return lastGuessesNum
     */
    public int getLastGuessesNum()
    {
        return lastGuessesNum;
    }
    
    /**
     * If player abandon the game, set TURE
     * 
     * @param flag
     */
    public void setAbandonFlag(boolean flag)
    {
        this.abandonFlag = flag;
    }
    
    /**
     * Method getAbandonFlag
     * 
     * @return abandonFlag
     */
    public boolean getAbandonFlag()
    {
        return abandonFlag;
    }
}
