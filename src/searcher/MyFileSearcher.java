package searcher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import abstractsearchers.AbstractSearcher;
import interfaces.IMyFileSearcher;
import mp3.ID3Tag;

public class MyFileSearcher implements IMyFileSearcher {
	AbstractSearcher searchChain;

	public MyFileSearcher(AbstractSearcher searchChain) {
		this.searchChain = searchChain;
	}

	@Override
	public List<File> search(String keyword, Map<File, List<ID3Tag>> allFile) {
		List<File> results = new ArrayList<File>();

		for (Entry<File, List<ID3Tag>> entry : allFile.entrySet()) {
			if (searchChain.isInResults(entry.getKey(), entry.getValue(), keyword)) {
				results.add(entry.getKey());
			}
		}
		return results;
	}
}
