package abstractsearchers;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNameSearcher extends AbstractSearcher {

	@Override
	protected boolean isMatch(File mp3file, String keyword) {

		Path p = Paths.get(mp3file.getAbsolutePath());
		String fileName = p.getFileName().toString();
		
		return fileName.contains(keyword);
	}
}
