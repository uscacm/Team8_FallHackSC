package com.example.coupinionsc;


//probably won't be implemented until later
public class UserManager 
{
	private int intLevel;
	private int intExperience;
	
	public UserManager(int userLevel, int userExperience)
	{
		intLevel = userLevel;
		intExperience = userExperience;
		
	}//ends the no-arg UserManager constructor
	
	public UserManager()
	{
		//new user, has no saved data
		intLevel = 1;
		intExperience = 0;		
		
	}//ends the no-arg UserManager constructor
	
	public void levelUp()
	{
		intLevel++;
	}
	
	public void checkExperience()
	{
		if (intExperience >= intLevel * 10)
		{
			this.levelUp();	
		}
	}
	
	public int getLevel()
	{
		return intLevel;
	}
	
	
}//ends the UserManager class
