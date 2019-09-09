import java.util.*;
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public void go()
    {
        String[][] a = {
                {" ","A","A","A"," "," "},
                {"A"," "," "," ","A"," "},
                {"A"," "," "," ","A"," "},
                {"A"," "," "," ","A"," "},
                {"A","A","A","A","A"," "},
                {"A"," "," "," ","A"," "},
                {"A"," "," "," ","A"," "}  
            };

        for(int i = 0; i < a.length; i++)
        {    for(int j = 0; j < a[i].length; j++)
            {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }

    }

    public String formatPlayerName(String newName){
        String formatName = "";
        if (newName.contains("-")){
            int indexOfHyphen = newName.indexOf("-");
            String temp1 = newName.substring(0, indexOfHyphen);
            String temp2 = newName.substring(indexOfHyphen + 1, newName.length());
            temp1 = temp1.substring(0, 1).toUpperCase() + temp1.substring(1, temp1.length());
            temp2 = temp2.substring(0, 1).toUpperCase() + temp2.substring(1, temp2.length());
            formatName = temp1 + "-" + temp2;
        } else {
            formatName = newName.substring(0, 1).toUpperCase() + newName.substring(1, newName.length());
        }
        return formatName;
    }

    public void hah(){
        String[] team1 = {"China","3","1","1"};
        String[] team2 = {"Australia","4","2","1"};
        displayGameResult(team1,team2);
    }

    public void displayGameResult(String[] team1, String[] team2) {

        System.out.println("------------------------------------------------------------");
        System.out.println("|                   * Last game result *                   |");
        System.out.println("|        Game Result:  " + team1[0] + "  " + team1[1] + "  vs.  " + team2[0] + "  " + team2[1] + "          |");
        System.out.println("|                                                   |");
        System.out.println("|        Card Awarded: " + team1[0] + " - " + team1[2] + " yellow Card(s)           |");
        System.out.println("|                      "+String.format("%" + team1[0].length() + "s","")+" - " + team1[3] + " red Card(s)              |");
        System.out.println("|        Card Awarded: " + team2[0] + " - " + team2[2] + " yellow Card(s)           |");
        System.out.println("|                      "+String.format("%" + team2[0].length() + "s","")+" - " + team2[3] + " red Card(s)           |");
        System.out.println("|                                                   |");
        System.out.printf("%-60s","|              Press <Enter> to run next game...            |/n");
        System.out.println("-------------------------------------------------------------");

    }
    
    public void tryList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("China");
        list.add("Australia");
        list.add("Ghana");
        list.add("Spain");
        System.out.println("Before remove");
        for(int i = 0; i<list.size();i++){
            String s = list.get(i);
            System.out.println(i+":"+s);
        }
        System.out.println("\nTry Move");
        for(int i = 0; i< list.size(); i++){
            String s1 = list.get(i);
            System.out.println("s1:"+s1);
            list.remove(s1);
            for(int j = 0; j< list.size();j++){
                String s2 = list.get(j);
                System.out.println("s1:"+s1+"|||s2:"+s2);
            }
            s1 = "0"+i+s1;
            list.add(i,s1);
        }
        
        System.out.println("\nAfter remove");
        for(int i = 0; i<list.size();i++){
            String s = list.get(i);
            System.out.println(i+":"+s);
        }
    }
    
    public void hyh(){
        String s1 = "aaa";
        boolean flag1 = justEquals(s1);
        boolean flag2 = dotEquals(s1);
        System.out.println(flag1);
        System.out.println(flag2);
    }
    private boolean justEquals(String s){
        if(s == "aaa")
            return true;
        else
            return false;
    }
    private boolean dotEquals(String s){
        if(s.equals("aaa"))
            return true;
        else
            return false;
    }
    
    public void yyy(){
        String[] array = {"China", "3","Japan","0"};
        displayPenaltyShootResult(array);
    }
    	private void displayPenaltyShootResult(String[] array) {
    	System.out.println("-----------------------------------------------------");
    	System.out.println("|                Penalty Shoot result               |");
    	System.out.println("|                                                   |");
    	System.out.println("|\t\t" + array[0] + "\t  vs.  \t" + array[2] + "            |");
    	System.out.println("|\t\t  " + array[1] + "\t       \t  " + array[3] + "            |");
    	System.out.println("|                                                   |");
    	System.out.println("|            Press <Enter> to continue...           |");
    	System.out.println("-----------------------------------------------------");
    
    }
    
    public void compare(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        System.out.println("Before");
        for(int i = 0; i<list.size();i++){
            String s = list.get(i);
            System.out.println(i+":"+s);
        }
        list.add(0,"C");
        list.add(1,"D");
        System.out.println("After");
        for(int i = 0; i<list.size();i++){
            String s = list.get(i);
            System.out.println(i+":"+s);
        }
    }
}
