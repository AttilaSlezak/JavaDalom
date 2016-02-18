package interfaces;

import java.io.File;
import java.util.List;

public interface IMyFileSearcher {
	public List<File> search(String keyword, List<File> allFile);
}
