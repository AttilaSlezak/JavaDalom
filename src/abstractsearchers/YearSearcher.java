package abstractsearchers;

import java.io.File;
import java.util.List;

import mp3.ID3Tag;

public class YearSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, List<ID3Tag> tagList, String keyword) {
		String yearToString = Integer.toString(tagList.get(3).getYear());
		return yearToString.toLowerCase().contains(keyword);
	}
}
