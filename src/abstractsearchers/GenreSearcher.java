package abstractsearchers;

import static common.GenreMapper.types;

import java.io.File;

import common.ID3Tag;

public class GenreSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, ID3Tag tagList, String keyword) {
		try {
			Integer genreNum = tagList.getGenre();
			if (keyword.equals(Integer.toString(genreNum))) {
				return true;
			}
			return types.get(genreNum).toLowerCase().contains(keyword);
		} catch (Exception e) {
			return false;
		}
	}

}
