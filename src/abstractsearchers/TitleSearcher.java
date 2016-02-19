package abstractsearchers;

import java.io.File;

import mp3.ID3Tag;

public class TitleSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, String keyword) {
		return ID3Tag.parse(mp3file).getTitle().toLowerCase().contains(keyword);
	}

}
