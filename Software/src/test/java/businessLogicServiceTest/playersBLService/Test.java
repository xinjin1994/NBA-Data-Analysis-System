package businessLogicServiceTest.playersBLService;

import java.util.ArrayList;
import test.data.*;
import data.init.DataInit;
import enums.Terminology;
import businessLogic.playersBL.PlayersBL_new;
import businessLogicService.playersBLService.PlayersBLForTest;
import junit.framework.TestCase;

public class Test extends TestCase {

	PlayersBLForTest service = new PlayersBL_new();
	
	protected void setUp() throws Exception {
		super.setUp();
		new DataInit().init();
	}
	
	public void testGetNormal() {
		String[] filter = new String[]{"position.F", "league.West"};
		Terminology[] sortField = new Terminology[]{Terminology.PTS, Terminology.AST};
		boolean[] asc = new boolean[]{false, true};
		int num = 10;
		ArrayList<PlayerNormalInfo> list = service.getPlayerNormalInfo_avg(filter, sortField, asc, num);
		System.out.println(list.size());
	}
	
	public void testGetNormal_total() {
		String[] filter = new String[]{"position.F", "league.West"};
		Terminology[] sortField = new Terminology[]{Terminology.PTS, Terminology.AST};
		boolean[] asc = new boolean[]{false, true};
		int num = 10;
		ArrayList<PlayerNormalInfo> list = service.getPlayerNormalInfo_total(filter, sortField, asc, num);
		System.out.println(list.size());
	}
	
	public void testGetHigh() {
		Terminology[] sortField = new Terminology[]{Terminology.GMSC, Terminology.PER};
		boolean[] asc = new boolean[]{false, true};
		int num = 10;
		
		ArrayList<PlayerHighInfo> list = service.getPlayerHighInfo(sortField, asc, num);
		System.out.println(list.size());
	}
	
	public void testGetHot() {
		String hotField = "score";
		int num = 5;
		ArrayList<PlayerHotInfo> list = service.getPlayerHotInfo(hotField, num);
		System.out.println(list.size());
	}
	
	public void testGetKing_season() {
		String kingField = "assist";
		int num = 10;
		ArrayList<PlayerKingInfo> list = service.getPlayerKingInfo_daily(kingField, num);
		System.out.println(list.size());
	}

}
