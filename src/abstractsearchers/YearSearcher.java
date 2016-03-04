package abstractsearchers;

import java.io.File;
import java.util.List;

import common.ID3Tag;

public class YearSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, ID3Tag tagList, String keyword) {
		String yearToString = Integer.toString(tagList.getYear());
		return yearToString.toLowerCase().contains(keyword);
	}
}
