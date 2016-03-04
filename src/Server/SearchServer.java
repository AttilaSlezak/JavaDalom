package Server;

import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import abstractsearchers.AbstractSearcher;
import abstractsearchers.AlbumSearcher;
import abstractsearchers.ArtistSearcher;
import abstractsearchers.CommentSearcher;
import abstractsearchers.FileNameSearcher;
import abstractsearchers.GenreSearcher;
import abstractsearchers.TitleSearcher;
import abstractsearchers.YearSearcher;
import common.ID3Tag;
import common.Property;
import searcher.MyFileSearcher;

public class SearchServer {

	private int port;
	private String errorMessage = "";

	public SearchServer(int port) {
		this.port = port;

		Map<File, ID3Tag> filesAndTagsFromUser = null;
		String keywordFromUser = null;
		List<Property> propertiesFromUser = null;
		ServerSocket ss = null;

		try {
			ss = new ServerSocket(port);
			Socket s = ss.accept();

			InputStream is = s.getInputStream();
			OutputStream os = s.getOutputStream();

			ObjectInputStream ois = new ObjectInputStream(is);
			ObjectOutputStream oos = new ObjectOutputStream(os);

			boolean haveMap = false;
			boolean haveString = false;
			boolean haveList = false;

			while (true) {
				int i;
				if ((i = ois.read()) > -1) {
				if (i == 1) {break;}
					Object obj = ois.readObject();

					if (obj instanceof Map<?, ?>) {
						try {
							filesAndTagsFromUser = (Map<File, ID3Tag>) obj;
							haveMap = true;
							System.out.println("Files and Tags OK");
						} catch (Exception e) {

							errorMessage = "Wrong files and ID3 tags!";
							oos.writeObject(errorMessage);
							haveMap = false;
						}
					}
					if (obj instanceof String) {
						try {
							keywordFromUser = (String) obj;
							haveString = true;
							System.out.println("Keyword OK");
						} catch (Exception e) {
							errorMessage = "Wrong keyword!";
							oos.writeObject(errorMessage);
							haveString = false;
						}
					}
					if (obj instanceof List<?>) {
						try {
							propertiesFromUser = (List<Property>) obj;
							haveList = true;
							System.out.println("Properties OK");
						} catch (Exception e) {
							errorMessage = "Wrong properties!";
							oos.writeObject(errorMessage);
						}
					}
					if (haveString && haveList && haveMap) {
						List<File> result;
						result = generateSearchResult(filesAndTagsFromUser, keywordFromUser, propertiesFromUser);
						System.out.println("Itt jön a visszaadás");
						oos.writeObject(result);

						haveList = false;
						haveString = false;
						haveMap = false;
						// break;
					}
				}
			}
			oos.close();
			os.close();
			s.close();
			ois.close();
			is.close();
			ss.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			// if(! ss.isClosed())
			// {
			// ss.close();
			// }
		}
	}

	public List<File> generateSearchResult(Map<File, ID3Tag> filesAndTagsFromUser, String keyword,
			List<Property> properties) {
		List<File> resultFiles;
		List<AbstractSearcher> searchers = new ArrayList<AbstractSearcher>();

		System.out.println("Itt van");
		for (Property p : properties) {
			System.out.println(p);
			switch (p) {
			case FILENAME:
				searchers.add(new FileNameSearcher());
			case TITLE:
				searchers.add(new TitleSearcher());
			case ARTIST:
				searchers.add(new ArtistSearcher());
			case ALBUM:
				searchers.add(new AlbumSearcher());
			case YEAR:
				searchers.add(new YearSearcher());
			case COMMENT:
				searchers.add(new CommentSearcher());
			case GENRE:
				searchers.add(new GenreSearcher());
			}
		}
		AbstractSearcher searchChain = searchers.get(0);

		for (int i = 0; i < searchers.size() - 1; i++) {
			searchers.get(i).setNextSearcher(searchers.get(i + 1));
		}

		MyFileSearcher myfiles = new MyFileSearcher(searchChain);

		resultFiles = myfiles.search(keyword, filesAndTagsFromUser);

		return resultFiles;
	}

	public static void main(String[] args) {
		new SearchServer(10031);
		// new SearchServer(10032);
		// new SearchServer(10033);
		// new SearchServer(10034);
	}
}
