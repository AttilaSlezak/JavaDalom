package searcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import abstractsearchers.AbstractSearcher;
import interfaces.IMyFileSearcher;

public class MyFileSearcher implements IMyFileSearcher {
	AbstractSearcher searchChain;

	public MyFileSearcher(AbstractSearcher searchChain) {
		this.searchChain = searchChain;
	}

	@Override
	public List<File> search(String keyword, List<File> allFile) {
		List<File> results = new ArrayList<File>();

		for (File file : allFile) {
			if (searchChain.isInResults(file, keyword)) {
				results.add(file);
			}
		}
		return results;
	}
}
