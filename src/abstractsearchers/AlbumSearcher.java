package abstractsearchers;

import java.io.File;

import common.ID3Tag;

public class AlbumSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, ID3Tag tagList, String keyword) {
		return tagList.getAlbum().toLowerCase().contains(keyword.toLowerCase());
	}
}
