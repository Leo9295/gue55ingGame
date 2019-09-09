import java.util.*;

/**
 * Including all main methods and Players object
 * To start game, process startTheGame()
 * 
 * @author Leo
 * @version 17.04.2018
 */

public class Game {
    // Create fields
    // Players obj
    private Human humanPlayer;
    private Computer computerPlayer = new Computer();

    public Game() {}

    /**
     * Judge the Player if abandon the Game
     * @param player
     */
    private void abandonRound(Player player) {
        player.setAbandonFlag(true);
    }

    /**
     * Cal the score when Player guessed hiddenNum
     * @param player
     */
    private void calScore(Player player, int attemptTimes) {
        switch (attemptTimes) {
            case 1:
            player.setScore(20); break;
            case 2:
            player.setScore(15); break;
            case 3:
            player.setScore(11); break;
            case 4:
            player.setScore(8); break;
            case 5:
            player.setScore(6); break;
            case 6:
            player.setScore(5); break;
        }
    }

    /**
     * Cal score for two players when round is over
     * @param humanPlayer
     * @param computerPlayer
     */
    private void calEndRoundScore(int hiddenNumber) {
        ArrayList<Player> playerList = new ArrayList<Player>();
        playerList.add(humanPlayer);
        playerList.add(computerPlayer);
        for (Player i : playerList) {
            int tempNum = Math.abs(i.getLastGuessesNum() - hiddenNumber);
            if (10 - tempNum > 0)
                i.setScore(10 - tempNum);
        }
    }

    /**
     * create a random number to let computer player decide whether abandon game
     * @return int(The number for computer to identify if abandon the game)
     */
    private int createAbandonNumberForComputerPlayer()
    {
        // RandomNumber obj(For abandonNumber)
        RandomNumber randomNumber = new RandomNumber();
        int abandonNum = randomNumber.createNewRandomNumber(1, 20);
        return abandonNum;
    }
    
    /**
     * Computer player input(abandonNum, createGuess)
     * @param minRange
     * @param maxRange
     * @return 0:Player has abandoned game
     *         1:Successed input
     */
    private int computerPlayerInputNumber(int minRange, int maxRange) {
        RandomNumber randomNumber = new RandomNumber();
        int abandonNum = randomNumber.createNewRandomNumber(1, 20);
        if (abandonNum == computerPlayer.getComputerAbandonNum())
        {
            abandonRound(computerPlayer);
            return 0;
        } else {
            while (true) {
                int random = randomNumber.createNewRandomNumber(minRange, maxRange);
                if (random != minRange && 
                    random != maxRange) {
                    computerPlayer.setLastGuessesNum(random);
                    break;
                }
            }
            return 1;
        }
    }

    private void displayWelcomScreen() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("$                                                 $");
        System.out.println("$           Welcome to the Gue55ing Game          $");
        System.out.println("$                                                 $");
        System.out.println("$          Press ENTER to start the Game          $");
        System.out.println("$                                                 $");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

    /**
     * Display the detail for players, During the game process
     */
    private void displayPlayerDetail() {
        System.out.println("* The score of " + humanPlayer.getPlayerName() + " is " + humanPlayer.getScore());
        System.out.println("* The score of " + computerPlayer.getPlayerName() + " is " + computerPlayer.getScore());
    }

    /**
     * BIG or SMALL displayed
     * @param num(D-value between hiddenNum and GuessNum)
     */
    private void displayGuessingInformation(int num) {
        if (num > 0) 
            System.out.println("       * Guessing is a little BIG! *");
         else 
            System.out.println("       * Guessing is a little SMALL! *");
    }

    /**
     * Ending info for each round
     * @param hiddenNumber
     */
    private void displayEndingOfRound(int hiddenNumber) {
        displayBar();
        System.out.println("    $         This round is OVER!!!");
        System.out.println("    $    The score of " + humanPlayer.getPlayerName() + " is " + humanPlayer.getScore());
        System.out.println("    $  The score of " + computerPlayer.getPlayerName() + " is " + computerPlayer.getScore());
        System.out.println("    $         The hidden number is " + hiddenNumber);
        displayBar();
    }

    /**
     * Ending info for Game(Cal the Winner)
     */
    private void displayEndingOfGame() {
        displayBar();
        System.out.println("    $$$$$        G A M E   O V E R         $$$$$ \n");
        System.out.println("    $     The total score of " + humanPlayer.getPlayerName() + " is " + humanPlayer.getScore());
        System.out.println("    $ The total score of " + computerPlayer.getPlayerName() + " is " + computerPlayer.getScore());
        Player winner = ifWinner();
        if (winner != null)
            System.out.println("\n    $$$     The WINNER is " + winner.getPlayerName());
        else
            System.out.println("\n    $     It is tie...Good Luck Next Time!");
        displayBar();
    }

    private void displayBar()
    {
        System.out.println("===================================================");
    }

    private void displayEnter()
    {
        Scanner input = new Scanner(System.in);
        displayBar();
        System.out.print("* Press <Enter> to continue...");
        input.nextLine();
        displayBar();
    }

    /**
     * Compare the guessNum and hiddenNumber
     * @param Player
     * @return Player
     */
    private Player guessNumber(Player player, int hiddenNumber) {
        // Judge the number if equal(TRUE: return Player who has guessed the Number)
        if (isNumberEqual(player.getLastGuessesNum(), hiddenNumber))
            return player;
        else
            return null;
    }

    /**
     * Operation for comPlayer to guess number
     * @param hiddenNumber
     * @param minRange
     * @param maxRange
     * @return player(If error happens, return null)
     */
    private Player guessingStepOfComputerPlayer(int hiddenNumber, int minRange, int maxRange) {
        System.out.println("* Now is " + computerPlayer.getPlayerName() + "'s trun");
        computerPlayer.setAbandonFlag(false);
        computerPlayerInputNumber(minRange, maxRange);
        if (! computerPlayer.getAbandonFlag())
        {
            System.out.println("* Computer guessing is : " + computerPlayer.getLastGuessesNum());
            Player player = new Computer();
            player = guessNumber(computerPlayer, hiddenNumber);
            if (player != null)
                return player;
            else
                return null;
        } else
            return null;
    }

    /**
     * Operation for humanPlayer to guess number
     * @param hiddenNumber
     * @param minRange
     * @param maxRange
     * @return player(If error happens, return null)
     */
    private Player guessingStepOfHumanPlayer(int hiddenNumber, int minRange, int maxRange) {
        System.out.println("* Now is " + humanPlayer.getPlayerName() + "'s trun");
        humanPlayer.setInRangeInputFlag(true);
        humanPlayer.setAbandonFlag(false);
        humanPlayerInputNumber(minRange, maxRange);
        if (humanPlayer.getAbandonFlag())
            return null;
        if (humanPlayer.getInRangeInputFlag())
        {
            System.out.println("* " + humanPlayer.getPlayerName() + " guessing is : " + humanPlayer.getLastGuessesNum());
            Player player = new Human();
            player = guessNumber(humanPlayer, hiddenNumber);
            if (player != null)
                return player;
            else
                return null;
        } else
            return null;
    }

    /**
     * Input operation for HumanPlayer
     * (if number? if IN 1-100? if in vaildRange?)
     * @param minRange
     * @param maxRange
     */
    private int humanPlayerInputNumber(int minRange, int maxRange) {
        while (true){
            int guessNum = 0;
            Scanner input = new Scanner(System.in);
            System.out.println("* Please enter the number of your guess:");
            System.out.print("* >");
            try{
                guessNum = input.nextInt();
            } catch (Exception e) {
                System.out.println("% Please input Number ONLY ! ! !");
                continue;
            }
            if (guessNum == 999)
            {
                abandonRound(humanPlayer);
                return 0;
            }else if (! isNumBelongInVaildRange(guessNum))
            {
                System.out.println("% Please input the vaild number ONLY between 1 and 100 ! ! !");
                continue;
            }else if (! isNumBelongInGuessRange(guessNum, minRange, maxRange))
            {
                System.out.println("* The number you inputed is not in vaild range! You don't have another chance to try in this round!");
                humanPlayer.setInRangeInputFlag(false);
                return 0;
            }else{
                humanPlayer.setLastGuessesNum(guessNum);
                return 1;
            }
        }
    }

    /**
     * Compare score to show Winner
     * @return player (Winner or null(for tie))
     */
    private Player ifWinner()
    {
        int tempScore = humanPlayer.getScore() - computerPlayer.getScore();
        if (tempScore < 0)
        {
            return computerPlayer;
        }else if (tempScore == 0){
            return null;
        }else{
            return humanPlayer;
        }
    }

    /**
     * Indicate name for HumanPlayer
     */
    private void indicatePlayersName() {
        System.out.println("* Please input your name(Bewteen 1-8 characters):");
        System.out.print("* >");
        String playerName = indicatePlayersNameImpl();
        if (playerName.equals("ERROR_INVILD_PLAYERNAME")) {
            System.out.println("* Your name is invild, Please reenter your name! *");
            indicatePlayersName();
        } else {
            humanPlayer = new Human(playerName); // Init HumanPlayer
            displayBar();
            System.out.println("* Welcome Player " + playerName + " to join in the Game!");
            displayBar();
            System.out.print("* Press Enter for next step: ");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }
    }

    /**
     * Input HumanPlayer name
     * 
     * @return String playerName or ErrorMessage
     */
    private String indicatePlayersNameImpl() {
        Scanner input = new Scanner(System.in);
        String playerName = input.nextLine();
        playerName = playerName.trim();
        if (isName(playerName))
            return playerName;
        else 
            return "ERROR_INVILD_PLAYERNAME";
    }

    /**
     * Judge the length of Name
     * @param name
     * @return boolean
     */
    private boolean isName(String name)
    {
        if (name.length() >= 1 && name.length() <= 8)
            return true;
        else
            return false;
    }

    /**
     * Judge guessNumber and HiddenNumber equal or not
     * @param guessingNumber
     * @param hiddenNumber
     * @return boolean
     */
    private boolean isNumberEqual(int guessingNumber, int hiddenNumber)
    {
        if (guessingNumber == hiddenNumber)
            return true;
        else
            return false;
    }

    /**
     * If inputNumber IN vaildRange?
     * @param guessNum
     * @param minRange
     * @param maxRange
     * @return boolean
     */
    private boolean isNumBelongInGuessRange(int guessNum, int minRange, int maxRange)
    {
        if (guessNum > minRange && 
            guessNum < maxRange)
            return true;
        else
            return false;
    }

    /**
     * If guessNumber IN 1-100?
     * @param guessNum
     * @return boolean
     */
    private boolean isNumBelongInVaildRange(int guessNum)
    {
        if (guessNum >= 1 && 
            guessNum <= 100)
            return true;
        else
            return false;
    }

    /**
     * Computer guessing operation
     * @param gameNum
     * @param minRange
     * @param maxRange
     * @param hiddenNumber
     * @return 0: Something wrong in the guessing operation(abandonGame)
     * @return 1: Everything is going fine
     */    
    private int operateOfComputer(int gameNum, int minRange, int maxRange ,int hiddenNumber)
    {
        displayBar();
        System.out.println("          # This is attemp " + gameNum + " out of 6 #");
        displayBar();
        System.out.println("      *** The guessing range is : " + minRange+ " ~ " +maxRange + " ***");
        displayEnter();
        Player tempPlayer = new Computer();
        tempPlayer = guessingStepOfComputerPlayer(hiddenNumber, minRange, maxRange);
        // Step of Cal score
        if (tempPlayer != null)    
        {
            calScore(computerPlayer, gameNum);
            System.out.println("        ######################");
            System.out.println("        # Computer Guessed~! #");
            System.out.println("        ######################");
            displayPlayerDetail();
            return 0;
        } else if (computerPlayer.getAbandonFlag()){
            System.out.println("     # " + computerPlayer.getPlayerName() + " has ABANDBONED the game! #");
            return 0;
        } else {
            // Change guessing range
            int num1 = computerPlayer.getLastGuessesNum() - hiddenNumber;
            displayGuessingInformation(num1);
            if (num1 < 0)
                minRange = computerPlayer.getLastGuessesNum();
            else
                maxRange = computerPlayer.getLastGuessesNum();
        }
        return 1;
    }
    
    /**
     * Human guessing operation
     * @param gameNum
     * @param minRange
     * @param maxRange
     * @param hiddenNumber
     * @return 0: Something wrong in the guessing operation(abandonGame or invaildInput)
     * @return 1: Everything is going fine
     */
    private int operateOfHuman(int gameNum, int minRange, int maxRange ,int hiddenNumber)
    {
        displayBar();
        System.out.println("          # This is attemp " + gameNum + " out of 6 #");
        displayBar();
        System.out.println("      *** The guessing range is : " + minRange+ " ~ " +maxRange + " ***");
        Player tempPlayer = new Human();
        tempPlayer = guessingStepOfHumanPlayer(hiddenNumber, minRange, maxRange);
        // Step of Cal score
        if (tempPlayer != null)
        {
            calScore(humanPlayer, gameNum);
            System.out.println("          ###################");
            System.out.println("          # Human Guessed~! #");
            System.out.println("          ###################");
            displayPlayerDetail();
            return 0;
        } else if (humanPlayer.getAbandonFlag()){
            System.out.println("     # " + humanPlayer.getPlayerName() + " has ABANDBONED the game! #");
            return 0;
        } else if (humanPlayer.getInRangeInputFlag()) {
            // Change guessing range
            int num1 = humanPlayer.getLastGuessesNum() - hiddenNumber;
            displayGuessingInformation(num1);
            if (num1 < 0)
                minRange = humanPlayer.getLastGuessesNum();
            else
                maxRange = humanPlayer.getLastGuessesNum();
        }
        return 1;
    }
    
    /**
     * Main method for the Game
     */
    public void startTheGame(){
        displayWelcomScreen();
        indicatePlayersName();
        for(int roundNum = 1; roundNum < 5; roundNum++){
            RandomNumber randomNumber = new RandomNumber();
            displayBar();
            System.out.println("         ### This is round " + roundNum + " out of 4 ###");
            displayBar();
            int minRange = 1;
            int maxRange = 100;
            int hiddenNumber = randomNumber.createNewRandomNumber(minRange, maxRange);
            int orderNumber = randomNumber.createNewRandomNumber(1, 2);
            computerPlayer.setComputerAbandonNum(createAbandonNumberForComputerPlayer()); //Each round create an abandonNumber for ComputerPlayer
            switch (orderNumber)
            {
                case 1:
                for(int gameNum = 1; gameNum < 7;)
                {
                    displayBar();
                    System.out.println("          # This is attemp " + gameNum + " out of 6 #");
                    displayBar();
                    System.out.println("      *** The guessing range is : " + minRange+ " ~ " +maxRange + " ***");
                    Player player1 = new Human();
                    player1 = guessingStepOfHumanPlayer(hiddenNumber, minRange, maxRange);
                    if(operateOfHuman(gameNum, minRange, maxRange, hiddenNumber) == 1)
                        gameNum++;
                    else
                        break;

                    if(operateOfComputer(gameNum, minRange, maxRange, hiddenNumber) == 1)
                        gameNum++;
                    else
                        break;

                    // EndRound calScore for both players
                    if (gameNum == 7)
                    {
                        calEndRoundScore(hiddenNumber);
                    }
                } break;
                case 2:
                for(int gameNum = 1; gameNum < 7;)
                {
                    if(operateOfComputer(gameNum, minRange, maxRange, hiddenNumber) == 1)
                        gameNum++;
                    else
                        break;

                    if(operateOfHuman(gameNum, minRange, maxRange, hiddenNumber) == 1)
                        gameNum++;
                    else
                        break;

                    // EndRound calScore for both players
                    if (gameNum == 7)
                    {
                        calEndRoundScore(hiddenNumber);
                    }
                } break;
                default:
                System.out.println("# SYSTEM ERROR!");
                System.exit(0);
            }
            // End one round
            displayEndingOfRound(hiddenNumber);
            displayEnter();
        }
        //End whole game
        displayEndingOfGame();
    }
}
