package vo;

import enums.Teams;
import enums.Terminology;
import exceptions.TermNotFound;
import gui.util.GUIUtility;

public class TeamRatioGeneralVO implements StatsVO{
	//
	Teams team;
	int games;
	int wins;
	double fieldGoalsPercentage;                        //投篮命中率
	double freeThrowsPercentage;                        //罚球命中率
	double threePointFieldGoalsPercentage;              //三分命中率
	double winningRating;                               //胜率
	double offensiveRounds;                       //进攻回合
	double offensiveEfficiency;                   //进攻效率
	double defensiveEfficiency;                   //防守效率
	double offensiveReboundsEfficiency;           //进攻篮板效率
	double defensiveReboundsEfficiency;           //防守篮板效率
	double stealsEfficiency;                      //抢断效率
	double assistsEfficiency;                     //助攻（效）率
	
	public TeamRatioGeneralVO(Teams team, int games, double fgp, double ftp, double tgp, 
			double offRounds, double off, double def, double offRebd, 
			double defRebd, double stl, double ast, int wins){
		this.team = team;
		this.games = games;
		this.fieldGoalsPercentage = fgp;
		this.freeThrowsPercentage = ftp;
		this.threePointFieldGoalsPercentage = tgp;
		this.offensiveRounds = offRounds;
		this.offensiveEfficiency = off;
		this.defensiveEfficiency = def;
		this.offensiveReboundsEfficiency = offRebd;
		this.defensiveReboundsEfficiency = defRebd;
		this.stealsEfficiency = stl;
		this.assistsEfficiency = ast;
		this.wins = wins;
		this.winningRating = (double)wins/games;
	}
	
	public void average(){
		offensiveRounds /= games;
	}

	public Teams getTeam() {
		return team;
	}

	public int getGames() {
		return games;
	}

	public double getFieldGoalsPercentage() {
		return fieldGoalsPercentage*100;
	}

	public double getFreeThrowsPercentage() {
		return freeThrowsPercentage*100;
	}

	public double getThreePointFieldGoalsPercentage() {
		return threePointFieldGoalsPercentage*100;
	}

	public double getWinningRating() {
		return 100*winningRating;
	}

	public double getOffensiveRounds() {
		return offensiveRounds;
	}

	public double getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public double getOffensiveReboundsEfficiency() {
		return offensiveReboundsEfficiency;
	}

	public double getDefensiveReboundsEfficiency() {
		return defensiveReboundsEfficiency;
	}

	public double getStealsEfficiency() {
		return stealsEfficiency;
	}

	public double getAssistsEfficiency() {
		return assistsEfficiency;
	}

	@Override
	public String getProperty(Terminology term) throws TermNotFound {
		/*
		 double fieldGoalsPercentage;                        //投篮命中率
		double freeThrowsPercentage;                        //罚球命中率
		double threePointFieldGoalsPercentage;              //三分命中率
		double winningRating;                               //胜率
		double offensiveRounds;                       //进攻回合
		double offensiveEfficiency;                   //进攻效率
		double defensiveEfficiency;                   //防守效率
		double offensiveReboundsEfficiency;           //进攻篮板效率
		double defensiveReboundsEfficiency;           //防守篮板效率
		double stealsEfficiency;                      //抢断效率
		double assistsEfficiency;                     //助攻（效）率
		 */
		double d;
		switch(term){
		case FGP:
			d = this.getFieldGoalsPercentage();
			break;
		case FTP:
			d = this.getFreeThrowsPercentage();
			break;
		case TPP:
			d = this.getThreePointFieldGoalsPercentage();
			break;
		case WINR:
			d = this.getWinningRating();
			break;
		case OFR:
			d = this.getOffensiveRounds();
			break;
		case OFE:
			d = this.getOffensiveEfficiency();
			break;
		case DFE:
			d = this.getDefensiveEfficiency();
			break;
		case OREBDE:
			d = this.getOffensiveReboundsEfficiency();
			break;
		case DREBDE:
			d = this.getDefensiveReboundsEfficiency();
			break;
		case STLE:
			d = this.getStealsEfficiency();
			break;
		case ASTE:
			d = this.getAssistsEfficiency();
			break;
		case GMWIN:
			d =this.getWins();
			break;
		default:
			throw new TermNotFound(term);
		}
		return GUIUtility.formatDouble(d);
	}
	
	public int getWins(){
		return wins;
	}
	
}
