package abstractsearchers;

import java.io.File;

import common.ID3Tag;

public class ArtistSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, ID3Tag tagList, String keyword) {
		return tagList.getArtist().toLowerCase().contains(keyword.toLowerCase());
	}
}
