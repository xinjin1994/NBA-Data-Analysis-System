package Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import vo.MatchVO;
import businessLogic.matchesBL.MatchesBL_new;
import businessLogic.playersBL.PlayersBL_new;
import businessLogic.teamsBL.TeamsBL_new;
import businessLogicService.matchesBLService.MatchesBLService;
import businessLogicService.playersBLService.PlayersBLService_new;
import businessLogicService.teamsBLService.TeamsBLService_new;
import data.init.DataInit;
import data.init.FileListener;
import exceptions.MatchNotFound;
import exceptions.StatsNotFound;

public class AddDataTest {
	MatchesBLService matchService = new MatchesBL_new();
	PlayersBLService_new playerService = new PlayersBL_new();
	TeamsBLService_new teamService = new TeamsBL_new();

	public AddDataTest() {
		new DataInit().init();
	}

	public void test() {
		ArrayList<Date> dates;
		while(true){
			try {
				//dates = matchService.getAvailableDays("12-13");
				ArrayList<MatchVO> matches = matchService.getMatchBySeason("12-13");
				System.out.println(matches.size());
			} catch (MatchNotFound e) {
				System.out.println(0);
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		
		AddDataTest test = new AddDataTest();
		Thread t = new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String path = "matches";
				try {
					FileListener listener = new FileListener(path);
					while(true){
						listener.start();
					}
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t.start();
		test.test();
		
		/*
		String path = "matches";
		try {
			new FileListener(path).start();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}
