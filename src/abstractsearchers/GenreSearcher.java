package abstractsearchers;

import java.io.File;
import java.util.List;

import common.ID3Tag;

import static common.GenreMapper.types;

public class GenreSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, ID3Tag tagList, String keyword) {
		try {
		Integer genreNum = tagList.getGenre();
		if (keyword.equals(Integer.toString(genreNum))) {
			return true;
		}
		return types.get(genreNum).toLowerCase().contains(keyword);
		}
		catch (Exception e) {
			return false;
		}
	}

}
