package abstractsearchers;

import java.io.File;
import java.util.List;

import mp3.ID3Tag;

public abstract class AbstractSearcher {

	protected AbstractSearcher nextSearcher;

	public void setNextSearcher(AbstractSearcher nextSearcher) {
		this.nextSearcher = nextSearcher;
	}

	public boolean isInResults(File mp3file, List<ID3Tag> tagList, String keyword) {
		if (isMatch(mp3file, tagList, keyword)) {
			return true;
		}
		if (nextSearcher != null) {
			return nextSearcher.isInResults(mp3file, tagList, keyword);
		} else {
			return false;
		}
	}

	protected abstract boolean isMatch(File mp3file, List<ID3Tag> tagList, String keyword);
}