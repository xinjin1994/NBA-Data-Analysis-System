package guiTest;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import org.junit.Test;

import enums.Terminology;
import gui.util.AdjustableTable.AttributesAdjustable;
import gui.util.AdjustableTable.ChooseAttributeDialog;
import junit.framework.TestCase;

public class ChooseAttributesDialogTest extends TestCase implements AttributesAdjustable<Terminology>{

	@Test
	public void test(){
		ArrayList<Map<Terminology,Boolean>> groups = new ArrayList<Map<Terminology,Boolean>>(2);
		Map<Terminology,Boolean> group_basic = new EnumMap<Terminology,Boolean>(Terminology.class);
		for(Terminology term:Terminology.getPlayerSeasonBasic())
			group_basic.put(term, false);
		groups.add(group_basic);
		Map<Terminology,Boolean> group_advanced = new EnumMap<Terminology,Boolean>(Terminology.class);
		for(Terminology term:Terminology.getPlayerAdvanced())
			group_advanced.put(term, false);
		groups.add(group_advanced);
		String[] tags = {"基本数据","进阶数据"};
		new ChooseAttributeDialog<Terminology>(groups,tags,this).setVisible(true);
	}

	@Override
	public void adjust(ArrayList<Terminology> attributes) {
		for(Terminology term:attributes)
			System.out.print(term.toString()+" ");
	}
}
