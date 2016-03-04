package searcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import abstractsearchers.AbstractSearcher;
import abstractsearchers.AlbumSearcher;
import abstractsearchers.ArtistSearcher;
import abstractsearchers.CommentSearcher;
import abstractsearchers.FileNameSearcher;
import abstractsearchers.GenreSearcher;
import abstractsearchers.TitleSearcher;
import abstractsearchers.YearSearcher;
import common.GenreMapper;
public class Menu {
    
    public static List<AbstractSearcher> ID3ForConsol() {
        
       String input = null;
       final String yesAnswer = "y";
       final String noAnswer = "n";
       List<AbstractSearcher> listToSearch = new ArrayList<AbstractSearcher>();
       
       listToSearch.add(new FileNameSearcher());
       listToSearch.add(new TitleSearcher());
       listToSearch.add(new ArtistSearcher());
       listToSearch.add(new AlbumSearcher());
       listToSearch.add(new YearSearcher());
       listToSearch.add(new CommentSearcher());
       listToSearch.add(new GenreSearcher());
       
       List<String> menuElements = new ArrayList<String>();
       
       menuElements.add("file name");
       menuElements.add("title");
       menuElements.add("artist");
       menuElements.add("album");
       menuElements.add("year");
       menuElements.add("comment");
       menuElements.add("genre");
       
       Scanner inputReader = new Scanner(System.in);       

       for (int i = 0; i < listToSearch.size(); i++) {
            do{
                System.out.println("Would you like to search in " + menuElements.get(i) + "? (Y / N): " );
                input = inputReader.nextLine().toLowerCase();
                if(input.equals(noAnswer)){
                    listToSearch.remove(i);
                    menuElements.remove(i);
                    i--;
                }
                else if(input.equals(yesAnswer)){
                     System.out.println(menuElements.get(i) + " added to search!");
                }else{
                    System.out.println("Wrong answer. Please press Y to 'yes'or N to 'no'!");               
                }
            }while(!( input.equals(yesAnswer) ||  input.equals(noAnswer)));
       }
       return listToSearch;
   }

	public static String keyWordForConsol() {
		String keyword = null;
 		listGenreTypes();	
 		Scanner inputReader = new Scanner(System.in);
		do {
			   System.out.println("Please write here the keyword for searching: ");
			   keyword = inputReader.nextLine();
		   } while (keyword.equals(""));
		return keyword.toLowerCase();
	}
	
	public static boolean isSearch()
	{
		String question = null;
		Scanner inputReader = new Scanner(System.in);
		do {
			   	if (question != null) {
			   		System.out.println("Wrong answer. Please press Y to 'yes'or N to 'no'!");
			   	}
				System.out.println("Would you like to search any keyword or tag? (Y / N): ");
				question = inputReader.nextLine();
		   } while (!question.toLowerCase().equals("y") && !question.toLowerCase().equals("n"));
		return question.toLowerCase().equals("y") ? true : false;
	}
	
	public static void listGenreTypes()
	{
		String question = null;
		Scanner inputReader = new Scanner(System.in);
		do {
			   System.out.println("Would you like to list the genre types? (Y / N): ");
			   question = inputReader.nextLine();
		   } while (question.toLowerCase().equals(""));
		if(question.equals("y"))
		{
			for (Object key : GenreMapper.types.keySet()) {
				System.out.println(key.toString() + " : " + GenreMapper.types.get(key));
			}
			return;
		}
		return;
	}
	
}