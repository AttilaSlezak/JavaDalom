package abstractsearchers;

import java.io.File;
import static mp3.GenreTypes.genreMap;
import mp3.ID3Tag;

public class GenreSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, String keyword) {
		Integer genreNum = ID3Tag.id3tagFinder(mp3file).getGenre();
		if (keyword.equals(Integer.toString(genreNum))) {
			return true;
		}
		return genreMap.get(genreNum).toLowerCase().contains(keyword);
	}

}
