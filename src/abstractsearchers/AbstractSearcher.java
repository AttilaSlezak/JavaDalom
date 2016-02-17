package abstractsearchers;

import java.io.File;

public abstract class AbstractSearcher {
	
	protected AbstractSearcher nextSearcher;
	
	public void setNextSearcher(AbstractSearcher nextSearcher) {
		this.nextSearcher = nextSearcher;
	}
	
	public boolean isInResults(File mp3file, String keyword){
		if(isMatch(mp3file, keyword)){
			return true;
		}
		if(nextSearcher != null){
			return nextSearcher.isInResults(mp3file, keyword);
		}else{
			return false;
		}
	}
	
	protected abstract boolean isMatch(File mp3file, String keyword);
}