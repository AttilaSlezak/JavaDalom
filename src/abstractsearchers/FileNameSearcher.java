package abstractsearchers;

import java.io.File;
import java.util.List;

import mp3.ID3Tag;

public class FileNameSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, List<ID3Tag> tagList, String keyword) {

		String fileName = mp3file.getName().toString().toLowerCase();
		return fileName.contains(keyword);
	}
}
