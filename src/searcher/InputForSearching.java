package searcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.out;	

public class InputForSearching {
	
	static String keyword = "";
	List<String> listToSearch = new ArrayList<String>();
	char answer;

	public String inputForKeyword() throws IOException {
		
		out.print("Please write here the keyword for searching: ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		keyword = in.readLine();
		
		return keyword;
	}
		
	public List<String> handlingAttributeList() {
		
		//adding all items to the list of searching attributes:
		listToSearch.add("file name");
		listToSearch.add("title");
		listToSearch.add("artist");
		listToSearch.add("album");
		listToSearch.add("year");
		listToSearch.add("comment");
		listToSearch.add("genre");
		
		//setting searching parameters: answer = keyboard.findWithinHorizon(".",0).charAt(0); answer = Character.valueOf('\u0000');
		Scanner keyboard = new Scanner(System.in);
		try{
		for (int i = 0; i < listToSearch.size(); i++) {
			do {
				out.print("Would you like to search in " + listToSearch.get(i) + "? (Y / N): ");
				answer = keyboard.findWithinHorizon(".",0).charAt(0);
				
				if (answer == 'n' ) {
					listToSearch.remove(i);
					i--;
				}	
				else if (answer == 'y') {
				} else {
					out.print("Wrong answer. Please press Y to 'yes'or N to 'no'!");
				}
				answer = Character.valueOf('\u0000');
			} while(answer != 'n' || answer != 'y');
		}
		}catch(Exception e)
		{
			out.println(e);
		}
		keyboard.close();
		return listToSearch;
	}
}