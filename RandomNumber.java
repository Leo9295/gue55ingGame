/**
 * Create a new random number
 *
 * @author Leo
 * @version 24.03.2018
 */

import java.util.*;

public class RandomNumber
{   
    public RandomNumber(){}
    
    /**
     * Depend on range to create a new random number
     * @param The range of random number, [min, max]
     * @return randomNum
     */
    public int createNewRandomNumber(int minRange, int maxRange)
    {
        Random random = new Random();
        int randomNum = random.nextInt((maxRange - minRange) + 1) + minRange;
        return randomNum;
    }
}