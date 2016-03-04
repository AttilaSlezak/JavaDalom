package interfaces;

import java.io.File;
import java.util.List;
import java.util.Map;

import common.ID3Tag;

public interface IMyFileSearcher {
	public List<File> search(String keyword, Map<File, ID3Tag> allFile);
}
