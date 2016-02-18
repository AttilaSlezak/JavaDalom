package abstractsearchers;

import java.io.File;
import java.util.Map;

import mp3.GenreTypes;
import mp3.ID3Tag;

public class GenreSearcher extends AbstractSearcher {

	@Override
	public boolean isMatch(File mp3file, String keyword) {
		Map<Integer, String> genreTypes = GenreTypes.getGenreTypes();
		Integer genreNum = ID3Tag.id3tagFinder(mp3file).getGenre();
		if (keyword == Integer.toString(genreNum)) {
			return true;
		}
		return genreTypes.get(genreNum).contains(keyword);
	}

}
