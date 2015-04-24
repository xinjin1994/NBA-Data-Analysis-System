package data.init;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class FileListener {
	//监听比赛文件夹的变化
	WatchService watcher;
	Path path;
	AddData addData;
	String filepath;
	
	public FileListener(String filepath) throws IOException {
		this.filepath = filepath;
		path = Paths.get(filepath);
		watcher = FileSystems.getDefault().newWatchService();
		path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
		addData = new AddData();
	}
	
	public void start() throws InterruptedException {
		while(true){
			WatchKey key = watcher.take();
			for(WatchEvent<?> event: key.pollEvents()){
				WatchEvent.Kind kind = event.kind();
				
				if(kind == StandardWatchEventKinds.OVERFLOW){
					continue;
				}
				
				WatchEvent<Path> e = (WatchEvent<Path>)event;
				
				Path filepath_Path = e.context();
				String filename = filepath_Path.getFileName().toString();
				String newFile = filepath + "\\" + filename;
				addData.AddMatch(newFile);
				System.out.println("Add File " + newFile);
			}
			
			if(!key.reset()){
				break;
			}
		}
	}
	
	/*
	public static void main(String[] args){
		try {
			new FileListener("D:\\下载").start();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	*/

}
