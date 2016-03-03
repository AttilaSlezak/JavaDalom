package abstractsearchers;

import java.io.File;
import java.util.List;

import static mp3.GenreTypes.genreMap;
import mp3.ID3Tag;

public class GenreSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, List<ID3Tag> tagList, String keyword) {
		try {
		Integer genreNum = tagList.get(5).getGenre();
		if (keyword.equals(Integer.toString(genreNum))) {
			return true;
		}
		return genreMap.get(genreNum).toLowerCase().contains(keyword);
		}
		catch (Exception e) {
			return false;
		}
	}

}
