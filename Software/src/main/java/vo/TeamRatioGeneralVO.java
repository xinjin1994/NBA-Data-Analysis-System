package vo;

import enums.Teams;
import enums.Terminology;
import exceptions.TermNotFound;
import gui.util.GUIUtility;

public class TeamRatioGeneralVO implements StatsVO{
	//
	Teams team;
	int games;
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
			double wr, double offRounds, double off, double def, double offRebd, 
			double defRebd, double stl, double ast){
		this.team = team;
		this.games = games;
		this.fieldGoalsPercentage = fgp;
		this.freeThrowsPercentage = ftp;
		this.threePointFieldGoalsPercentage = tgp;
		this.winningRating = wr;
		this.offensiveRounds = offRounds;
		this.offensiveEfficiency = off;
		this.defensiveEfficiency = def;
		this.offensiveReboundsEfficiency = offRebd;
		this.defensiveReboundsEfficiency = defRebd;
		this.stealsEfficiency = stl;
		this.assistsEfficiency = ast;
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
		return fieldGoalsPercentage;
	}

	public double getFreeThrowsPercentage() {
		return freeThrowsPercentage;
	}

	public double getThreePointFieldGoalsPercentage() {
		return threePointFieldGoalsPercentage;
	}

	public double getWinningRating() {
		return winningRating;
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
			d = this.fieldGoalsPercentage;
			break;
		case FTP:
			d = this.freeThrowsPercentage;
			break;
		case TPP:
			d = this.threePointFieldGoalsPercentage;
			break;
		case WINR:
			d = this.winningRating;
			break;
		case OFR:
			d = this.offensiveRounds;
			break;
		case OFE:
			d = this.offensiveEfficiency;
			break;
		case DFE:
			d = this.defensiveEfficiency;
			break;
		case OREBDE:
			d = this.offensiveReboundsEfficiency;
			break;
		case DREBDE:
			d = this.defensiveReboundsEfficiency;
			break;
		case STLE:
			d = this.stealsEfficiency;
			break;
		case ASTE:
			d = this.assistsEfficiency;
			break;
		case GMWIN:
			d = Math.round(this.winningRating*games);
			break;
		default:
			throw new TermNotFound(term);
		}
		return GUIUtility.formatDouble(d);
	}
	
}
