package data.playersData;

import java.util.ArrayList;
import java.io.*;

import po.PlayerPO;

public class ReadFromTxt implements ReadPlayers {
	String path = "F:/学习/软工3/迭代一数据/players/info";

	@Override
	public ArrayList<PlayerPO> readAllPlayers() {
		File file = new File(path);
		if(file.exists()){
			File[] fileList = file.listFiles();
			ArrayList<PlayerPO> playerList = new ArrayList<PlayerPO>();
			
			for(int i=0; i<fileList.length; i++){
				PlayerPO player = readFromOneFile(fileList[i]);
				playerList.add(player);
			}
			
			return playerList;
		}
		
		return null;
	}
	
	private PlayerPO readFromOneFile(File file){
		if(file.exists()){
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(  
		                new FileInputStream(file), "utf-8"));
				
				br.readLine();
				String[] arr = new String[9];
				for(int i=0; i<18; i++){
					if(i%2 == 1){                    //有用信息在文件中一行隔一行
						br.readLine();
						continue;
					}
					arr[i/2] = getInfo(br.readLine());
				}
				PlayerPO player = new PlayerPO(arr);
				
				br.close();
				
				return player;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
	String getInfo(String s){
		//读取player文件时，从某一行信息筛选出需要的内容
		String info = s.split("│")[1];
		info = info.substring(0, info.length()-2);
		return info.trim();
	}

	
	//简单测试
	public static void main(String[] args){
		long time1 = System.currentTimeMillis();
		
		ReadFromTxt reader = new ReadFromTxt();
		ArrayList<PlayerPO> playerList = reader.readAllPlayers();
		
		long time2 = System.currentTimeMillis();
		
		System.out.println("Time:" + (time2-time1) + '\n');
		
		playerList.get(0).print();
	}
}
