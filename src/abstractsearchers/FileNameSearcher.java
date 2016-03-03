package abstractsearchers;

import java.io.File;

public class FileNameSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, String keyword) {

		String fileName = mp3file.getName().toString().toLowerCase();
		return fileName.contains(keyword);
	}
}
