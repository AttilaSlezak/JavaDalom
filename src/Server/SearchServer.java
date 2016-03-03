package Server;

import java.io.File;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Map;

import mp3.ID3Tag;
import mp3.Properties;


public class SearchServer{

	public int port;
	
	public SearchServer(int port)
	{
		this.port = port;
		
		Map<File, ID3Tag> filesAndTagsFromUser;
		String keywordFromUser;
		List<Properties> propertiesFromUser;
		
		try
		{
			ServerSocket ss = new ServerSocket(port);
			Socket s = ss.accept();
			
			InputStream is = s.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);

			OutputStream os = s.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			while(true){
				if (ois.read() > -1) {
					Object obj = ois.readObject();
					
					if (obj instanceof Map<?, ?>) {
						filesAndTagsFromUser = (Map<File, ID3Tag>)obj;
						System.out.println("Files and Tags OK");
					}
					if (obj instanceof String) {
						keywordFromUser = (String)obj;
						System.out.println("Keyword OK");
					}
					if (obj instanceof List<?>) {
						
						System.out.println("Properties OK");
				}
					oos.close();
					os.close();
					s.close();
				}
			}
		ss.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args)
	{
		new SearchServer(10031);
//		new SearchServer(10032);
//		new SearchServer(10033);
//		new SearchServer(10034);
	}
}
	
