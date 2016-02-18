package searcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Menu {
    
    public static List<String> inputForConsol() {
        
       String input = null;
       String keyword = null;
       final String yesAnswer = "y";
       final String noAnswer = "n";
       List<String> listToSearch = new ArrayList<String>();
       
       listToSearch.add("file name");
       listToSearch.add("title");
       listToSearch.add("artist");
       listToSearch.add("album");
       listToSearch.add("year");
       listToSearch.add("comment");
       listToSearch.add("genre");
       
       Scanner inputReader = new Scanner(System.in);
       
       System.out.println("Please write here the keyword for searching: ");
       keyword = inputReader.nextLine();

       for (int i = 0; i < listToSearch.size(); i++) {
            do{
                System.out.println("Would you like to search in " + listToSearch.get(i) + "? (Y / N): " );
                input = inputReader.nextLine().toLowerCase();
                if(input.equals(noAnswer)){
                    listToSearch.remove(i);
                    i--;
                }
                else if(input.equals(yesAnswer)){
                     System.out.println(listToSearch.get(i) + " added to search!");
                }else{
                    System.out.println("Wrong answer. Please press Y to 'yes'or N to 'no'!");               
                }
            }while(!( input.equals(yesAnswer) ||  input.equals(noAnswer)));
       }

       
       inputReader.close();
        return listToSearch;
   }
    
    public static void main(String[] args) {
        List<String> result = new ArrayList<String>();
        result = inputForConsol();
        System.out.println(result);
    }
}