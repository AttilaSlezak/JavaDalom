package interfaces;

import java.io.File;
import java.util.List;
import java.util.Map;

import mp3.ID3Tag;

public interface IMyFileSearcher {
	public List<File> search(String keyword, Map<File, List<ID3Tag>> allFile);
}
