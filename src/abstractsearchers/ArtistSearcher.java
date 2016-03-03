package abstractsearchers;

import java.io.File;

import mp3.ID3Tag;

public class ArtistSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, String keyword) {
		return ID3Tag.parse(mp3file).getArtist().toLowerCase().contains(keyword);
	}
}
