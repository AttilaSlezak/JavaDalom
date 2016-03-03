package abstractsearchers;

import java.io.File;
import java.util.List;

import mp3.ID3Tag;

public class AlbumSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, List<ID3Tag> tagList, String keyword) {
		return tagList.get(2).getAlbum().toLowerCase().contains(keyword);
	}
}
