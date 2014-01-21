package io.model;

import java.util.ArrayList;
/**
 * 
 * @author jwil1446
 *
 */
public class Game
{
	/**
	 * creates an arrayList for gameRules
	 */
	private ArrayList<String> gameRules;
	private int funRanking;
	private String gameTitle;

	public Game()
	{
		gameRules = new ArrayList<String>();
		funRanking = 0;
		gameTitle = "";

	}
	/**
	 *  getter for GameTitle
	 * @return gameTitle
	 */
	public String getGameTitle()
	{
		return gameTitle;
	}
	/**
	 * setter for gameTitle
	 * @param gameTitle
	 */
	public void setGameTitle(String gameTitle)
	{
		this.gameTitle = gameTitle;
	}

	/**
	 * getter for getGameRules
	 * @return gameRules
	 */
	public ArrayList<String> getGameRules()
	{
		return gameRules;
	}
	/**
	 * getter for FunRanking
	 * @return funRanking
	 */
	public int getFunRanking()
	{
		return funRanking;
	}
	/**
	 * setter for GameRUles
	 * @param gameRules
	 */
	public void setGameRules(ArrayList<String> gameRules)
	{
		this.gameRules = gameRules;
	}
	/**
	 * setter for FunRanking
	 * @param funRanking
	 */
	public void setFunRanking(int funRanking)
	{
		this.funRanking = funRanking;
	}
	/**
	 * constructor for the Game class
	 * @param gameRule
	 * @param funRanking
	 * @param gameTitle
	 */
	public Game(ArrayList<String> gameRules, int funRanking, String gameTitle)
	{
		this.gameRules = gameRules;
		this.funRanking = funRanking;
		this.gameTitle = gameTitle;
	}
}
