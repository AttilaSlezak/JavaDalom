package searcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import abstractsearchers.AbstractSearcher;
import file.DirectoryScanner;

public class MusicHandler {
	
	public static void main(String[] args) {
		List<AbstractSearcher> searchers = new ArrayList<AbstractSearcher>();
		String keyword;
		List<File> getFiles = DirectoryScanner.getResultFiles();
		List<File> resultFiles = DirectoryScanner.getResultFiles();
		
		if (Menu.isSearch())
		{
			keyword = Menu.keyWordForConsol();
			searchers = Menu.ID3ForConsol();
		}else
		{
			printAllFilesToConsol(getFiles);
			return;
		}
		
		MyFileSearcher myfiles;
		myfiles = buildChain(searchers);
		myfiles.search(keyword, getFiles);
		
		printAllFilesToConsol(resultFiles);
		System.out.println("");
		System.out.println(resultFiles.size() + " files");
	}

	public static MyFileSearcher buildChain(List<AbstractSearcher> searchers) {
		AbstractSearcher searchChain = searchers.get(0);
		
		for (int i = 0; i < searchers.size()-1; i++) {
			searchers.get(i).setNextSearcher(searchers.get(i+1));
		}
		
		MyFileSearcher m = new MyFileSearcher(searchChain);
		
		return m;
		
	}
	
	public static void printAllFilesToConsol(List<File> files)
	{
		for (File file : files) {
			System.out.println(file);
		}
	}
}
