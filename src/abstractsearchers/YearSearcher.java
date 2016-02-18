package abstractsearchers;

import java.io.File;

import mp3.ID3Tag;

public class YearSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, String keyword) {
		String yearToString = Integer.toString(ID3Tag.id3tagFinder(mp3file).getYear());
		return yearToString.contains(keyword);
	}
}