package data.init;

import java.io.IOException;
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
	
	public FileListener(String filepath) throws IOException {
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
				Path filepath = e.context();
				addData.AddMatch(filepath.toAbsolutePath().toString());
			}
			
			if(!key.reset()){
				break;
			}
		}
	}

}
