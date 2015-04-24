package data.matchesData;

import java.util.ArrayList;
import java.io.*;
import po.MatchPO;

public class ReadFromTxt implements ReadMatches{
	String path = "matches";

	public ArrayList<MatchPO> readAllMatches(String filepath) {
		path = filepath == null ? path : filepath + "/" + path;
		File file = new File(path);
		if(file.exists()){
			File[] fileList = file.listFiles();
			ArrayList<MatchPO> matchList = new ArrayList<MatchPO>();
			
			for(int i=0; i<fileList.length; i++){
				MatchPO match = readFromOneFile(fileList[i]);
				matchList.add(match);
			}
			
			return matchList;
		}
		return null;
	}
	
	public MatchPO readFromOneFile(File file) {
		if(file.exists()){
			System.out.println("Read " + file);
			try{
				String season = file.getName().split("_")[0];           //读取赛季
				
				BufferedReader br = new BufferedReader(new InputStreamReader(
						new FileInputStream(file), "utf-8"));
				
				String line = br.readLine();                            //读取前两行
				if(line == null){
					br.close();
					return null;
				}
				String[] arr1 = line.split(";");
				line = br.readLine();
				String[] arr2 = line.split(";");
				
				ArrayList<String[]> team1Players = new ArrayList<String[]>();
				ArrayList<String[]> team2Players = new ArrayList<String[]>();
				br.readLine();                                          //球队名1
				while((line = br.readLine()).length() != 3){            //遇到球队名2时跳出循环
					String[] stats = line.split(";");                   //获取队伍1球员数据
					team1Players.add(stats);
				}
				while((line = br.readLine()) != null){
					String[] stats = line.split(";");
					team2Players.add(stats);
				}
				
				MatchPO match = new MatchPO();                          //创建MatchPO对象
				match.setSimpleData(season, arr1, arr2);
				match.setTeamsStats(team1Players, team2Players);
				
				br.close();
								
				return match;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	
	//简单测试
	public static void main(String[] args){
		long time1 = System.currentTimeMillis();
		
		ReadFromTxt reader = new ReadFromTxt();
		ArrayList<MatchPO> matchList = reader.readAllMatches(null);
		
		long time2 = System.currentTimeMillis();
		
		System.out.println("Time:" + (time2-time1));
		
		
		time1 = System.currentTimeMillis();
		
		for(int i=0; i<matchList.size(); i++){
			MatchPO match = matchList.get(i);
			for(int j=0; j<match.team1Players().size(); j++){
				if(match.team1Players().get(j).points() == null){
					System.out.println(match.date());
				}
			}
			for(int j=0; j<match.team2Players().size(); j++){
				if(match.team2Players().get(j).points() == null){
					System.out.println(match.date());
				}
			}
		}
		
		time2 = System.currentTimeMillis();
		
		System.out.println("Time:" + (time2-time1));
	}
}
