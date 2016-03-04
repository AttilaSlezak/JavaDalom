package abstractsearchers;

import java.io.File;
import java.util.List;

import common.ID3Tag;

public class TitleSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file,ID3Tag tagList, String keyword) {
		return tagList.getTitle().toLowerCase().contains(keyword);
	}

}
