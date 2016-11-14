/*
Author: Ebube Abara
Project Name: Goal Scoring Statistics
Program Description: This program will enable users keep track of football statistics
*/
//importing SWING libraries
import javax.swing.*;
//importing AWT libraries
import java.awt.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//importing UTIL libraries
import java.util.Scanner;//needed for Scanner class
import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
//importing LANG libraries
import java.lang.*;
//importing IO library
import java.io.*;//needed for file i/o classes

class goalscoringstats
{
	//THE PROGRAM STARTS RUNNING FROM THIS METHOD
	public static void main (String[] param) throws IOException
	{
		String output = "";//initialising variable
		String filepath = "/home/.../files/";//initialising file path and stating where will be read from and saved to

		//START READING FILES
		BufferedReader inStreamName = new BufferedReader(new FileReader(filepath + "playername.txt"));//initialising inStreamName to buffer data read from 'playername.txt' file
		String[] nameArray = new String[5];//initialising nameArray array
		for (int i = 0; i < nameArray.length; i++)
		{
			nameArray[i] = inStreamName.readLine();//reading data line by line from 'playername.txt' file into nameArray
		}

		BufferedReader inStreamCountry = new BufferedReader(new FileReader(filepath + "playercountry.txt"));
		String[] countryArray = new String[5];
		for (int i = 0; i < countryArray.length; i++)
		{
			countryArray[i] = inStreamCountry.readLine();
		}

		BufferedReader inStreamGoals = new BufferedReader(new FileReader(filepath + "playergoals.txt"));
		String[] goalsArrayS = new String[5];
		int[] goalsArray = new int[5];
		for (int i = 0; i < goalsArray.length; i++)
		{
			goalsArrayS[i] = inStreamGoals.readLine();//reading data line by line from 'playergoals.txt' file into nameArray
			goalsArray[i] = Integer.parseInt(goalsArrayS[i]);//converting goalsArray string to Integer
		}

		BufferedReader inStreamGames = new BufferedReader(new FileReader(filepath + "playergames.txt"));
		String[] gamesArrayS = new String[5];
		int[] gamesArray = new int[5];
		for (int i = 0; i < gamesArray.length; i++)
		{
			gamesArrayS[i] = inStreamGames.readLine();
			gamesArray[i] = Integer.parseInt(gamesArrayS[i]);
		}

		BufferedReader inStreamAverage = new BufferedReader(new FileReader(filepath + "playeraverage.txt"));
		String[] averageArrayS = new String[5];
		double[] averageArray = new double[5];
		for (int i = 0; i < averageArray.length; i++)
		{
			averageArrayS[i] = inStreamAverage.readLine();
			averageArray[i] = Double.parseDouble(averageArrayS[i]);
		}
		//STOP READING FILES
					
		setPlayerDetails(nameArray, countryArray, goalsArray, gamesArray, averageArray);//calling 'setPlayerDetails' method
		sortPlayerDetails(nameArray, countryArray, goalsArray, gamesArray, averageArray);//calling 'sortPlayerDetails' method
		
		//START SAVING FILES
		PrintWriter outputStreamName = new PrintWriter(new FileWriter(filepath + "playernames.txt"));//initialising outputStreamName for writing/saving data into 'playernames.txt' file
		for (int i = 0; i < nameArray.length; i++)
		{
			outputStreamName.println(nameArray[i]);//writing data line by line into 'playernames.txt' file
		}
		outputStreamName.close();//to confirms writing to file is complete

		PrintWriter outputStreamCountry = new PrintWriter(new FileWriter(filepath + "playercountrys.txt"));
		for (int i = 0; i < countryArray.length; i++)
		{
			outputStreamCountry.println(countryArray[i]);
		}
		outputStreamCountry.close();

		PrintWriter outputStreamGoals = new PrintWriter(new FileWriter(filepath + "playergoalss.txt"));
		for (int i = 0; i < goalsArray.length; i++)
		{
			outputStreamGoals.println(goalsArray[i]);
		}
		outputStreamGoals.close();

		PrintWriter outputStreamGames = new PrintWriter(new FileWriter(filepath + "playergamess.txt"));
		for (int i = 0; i < gamesArray.length; i++)
		{
			outputStreamGames.println(gamesArray[i]);
		}
		outputStreamGames.close();

		PrintWriter outputStreamAverage = new PrintWriter(new FileWriter(filepath + "playeraverages.txt"));
		for (int i = 0; i < averageArray.length; i++)
		{
			outputStreamAverage.println(averageArray[i]);
		}
		outputStreamAverage.close();
		//STOP SAVING FILES
		System.exit(0);//end running program
	}//END method 'main'


	//THIS METHOD ALLOWS USER TO SET DETAILS OF 5 PLAYERS AND STORES THEM IN THEIR ARRAY POSITIONS
	public static void setPlayerDetails(String[] inputNameArray, String[] inputCountryArray, int[] inputGoalsArray, int[] inputGamesArray, double[] inputAverageArray)
	{
		String[] nameArray = inputNameArray;//initialising nameArray with inputNameArray values
		String[] countryArray = inputCountryArray;//initialising countryArray with inputCountryArray values
		int[] goalsArray = inputGoalsArray;//initialising goalsArray with inputGoalsArray values
		int[] gamesArray = inputGamesArray;//initialising gamesArray with inputGamesArray values
		double[] averageArray = inputAverageArray;//initialising averageArray with inputAverageArray values

		String startset = "yes";//initialising startset variables
		String keeptrack = "yes";//initialising keeptrack variables
		String nameQ = "";//initialising nameQ variables		
		String[] setParam = new String[] {};//initialising setParam array

		while (startset.equalsIgnoreCase("yes"))
		{
			messagebox("Goal Scoring Stats. The app that allows you to keep track of football statistics \n\nPlease enter total goals and games played by the following players for their respective countries:\n- Wayne Rooney\n- Christiano Ronaldo\n- Kanu Nwankwo\n- Lionel Messi\n- Pele");
			while (keeptrack.equalsIgnoreCase("yes"))
			{
				nameQ = inputbox("Player's name?");//inputbox asking for player's name
				if(nameQ.equalsIgnoreCase("Wayne Rooney")||nameQ.equalsIgnoreCase("Rooney Wayne")||nameQ.equalsIgnoreCase("Wayne")||nameQ.equalsIgnoreCase("Rooney"))
				{
					setParam = setPlayerDetailsAlgorithm(nameArray[0], countryArray[0], goalsArray[0], gamesArray[0], averageArray[0]);//call 'setPlayerDetailsAlgorithm' method and pass the following parameters
					nameArray[0] = setParam[0];//pass setParam position 0 to nameArray position 0
					countryArray[0] = setParam[1];//pass setParam position 1 to countryArray position 0
					goalsArray[0] = Integer.parseInt(setParam[2]);//pass setParam position 2 to goalsArray position 0
					gamesArray[0] = Integer.parseInt(setParam[3]);//pass setParam position 3 to gamesArray position 0
					averageArray[0] = Double.parseDouble(setParam[4]);//pass setParam position 4 to averageArray position 0
				}
				else if(nameQ.equalsIgnoreCase("Christiano Ronaldo")||nameQ.equalsIgnoreCase("Ronaldo Christiano")||nameQ.equalsIgnoreCase("Christiano")||nameQ.equalsIgnoreCase("Ronaldo"))
				{
					setParam = setPlayerDetailsAlgorithm(nameArray[1], countryArray[1], goalsArray[1], gamesArray[1], averageArray[1]);//call 'setPlayerDetailsAlgorithm' method and pass the following parameters
					nameArray[1] = setParam[0];
					countryArray[1] = setParam[1];
					goalsArray[1] = Integer.parseInt(setParam[2]);
					gamesArray[1] = Integer.parseInt(setParam[3]);
					averageArray[1] = Double.parseDouble(setParam[4]);
				}
				else if(nameQ.equalsIgnoreCase("Kanu Nwankwo")||nameQ.equalsIgnoreCase("Nwankwo Kanu")||nameQ.equalsIgnoreCase("Kanu")||nameQ.equalsIgnoreCase("Nwankwo"))
				{
					setParam = setPlayerDetailsAlgorithm(nameArray[2], countryArray[2], goalsArray[2], gamesArray[2], averageArray[2]);//call 'setPlayerDetailsAlgorithm' method and pass the following parameters
					nameArray[2] = setParam[0];
					countryArray[2] = setParam[1];
					goalsArray[2] = Integer.parseInt(setParam[2]);
					gamesArray[2] = Integer.parseInt(setParam[3]);
					averageArray[2] = Double.parseDouble(setParam[4]);
				}
				else if(nameQ.equalsIgnoreCase("Lionel Messi")||nameQ.equalsIgnoreCase("Messi Lionel")||nameQ.equalsIgnoreCase("Lionel")||nameQ.equalsIgnoreCase("Messi"))
				{
					setParam = setPlayerDetailsAlgorithm(nameArray[3], countryArray[3], goalsArray[3], gamesArray[3], averageArray[3]);//call 'setPlayerDetailsAlgorithm' method and pass the following parameters
					nameArray[3] = setParam[0];
					countryArray[3] = setParam[1];
					goalsArray[3] = Integer.parseInt(setParam[2]);
					gamesArray[3] = Integer.parseInt(setParam[3]);
					averageArray[3] = Double.parseDouble(setParam[4]);
				}
				else if(nameQ.equalsIgnoreCase("Pele"))
				{
					setParam = setPlayerDetailsAlgorithm(nameArray[4], countryArray[4], goalsArray[4], gamesArray[4], averageArray[4]);//call 'setPlayerDetailsAlgorithm' method and pass the following parameters
					nameArray[4] = setParam[0];
					countryArray[4] = setParam[1];
					goalsArray[4] = Integer.parseInt(setParam[2]);
					gamesArray[4] = Integer.parseInt(setParam[3]);
					averageArray[4] = Double.parseDouble(setParam[4]);
				}
				else
				{
					messagebox("Please enter either Wayne Rooney, Christiano Ronaldo, Kanu Nwankwo, Lionel Messi or Pele.");//shows messagebox to alert user they were wrong.
				}
				keeptrack = inputbox("Do you still want to set player details? (yes/no)");
			}//END 'keeptrack' while loop
			startset = "no";//stops program from continuously looping
		}//END 'startset' while loop
	}//END method 'setPlayerDetails'


	//THIS METHOD ALLOWS USER TO ASK PLAYER VARIOUS QUESTIONS LIKE PLAYER GOALS AND GAMES
	public static String[] setPlayerDetailsAlgorithm(String inputName, String inputCountry, int inputGoals, int inputGames, double inputAverage)
	{
		String goalsQ = "";//initialise goalsQ variable
		String gamesQ = "";//initialise gamesQ variable
		int goalsI = 0;//initialise goalsI variable
		int gamesI = 0;//initialise gamesI variable
		double goalsD = 0;//initialise goalsD variable
		double gamesD = 0;//initialise gamesD variable
		double avgGoalsD = 0;//initialising avgGoalsD variable
		String avgGoals = "";//initialising avgGoals variable
		String[] outputParam = new String[5];

		goalsQ = inputbox("How many goals has " + inputName + " scored?");//ask for total goals
		goalsI = Integer.parseInt(goalsQ);//converts goals string to integer
		goalsD = Double.parseDouble(goalsQ);//converts goals string to double
		gamesQ = inputbox("How many games has " + inputName + " played for " + inputCountry + "?");//ask for total games
		gamesI = Integer.parseInt(gamesQ);//convert games string to integer
		gamesD = Double.parseDouble(gamesQ);//convert games to double
		avgGoalsD = averageGoals(goalsD, gamesD);//pass total goals and games into METHOD 'averageGoals' to get avgGoals
		inputGoals = goalsI;
		inputGames = gamesI;
		inputAverage = avgGoalsD;
		avgGoals = Double.toString(avgGoalsD);//converting average goals to string

		outputParam[0] = inputName;
		outputParam[1] = inputCountry;
		outputParam[2] = goalsQ;
		outputParam[3] = gamesQ;
		outputParam[4] = avgGoals;
		return outputParam;
	}//END method 'setPlayerDetailsAlgorithm'


	public static void sortPlayerDetails(String[] inputNameArray, String[] inputCountryArray, int[] inputGoalsArray, int[] inputGamesArray, double[] inputAverageArray)
	{
		String[] nameArray = inputNameArray;//initialising nameArray with inputNameArray values
		String[] countryArray = inputCountryArray;//initialsing countryArray with inputCountryArray values
		int[] goalsArray = inputGoalsArray;//initialising goalsArray with inputGoalsArray values
		int[] gamesArray = inputGamesArray;//initialising gamesArray with inputGamesArray values
		double[] averageArray = inputAverageArray;//initialising averageArray with inputAverageArray values
		String holdName = "";
		String holdCountry = "";
		int holdGoals = 0;
		int holdGames = 0;
		double holdAverage = 0;		
		boolean sorted = false;
		String sortQuestion = "";
		String output = "";		
		
		sortQuestion = inputbox("Please enter 'A' to sort player details in order of average goals per game OR any other to ignore sorting");
		while (!sorted)
		{
			sorted = true;
			if (sortQuestion.equalsIgnoreCase("A"))
			{
				for (int i = 0; i < averageArray.length-1; i++)
				{
					if (averageArray[i] < averageArray[i+1])
					{
						holdAverage = averageArray[i+1];//variable stores value of the next i array position
						averageArray[i+1] = averageArray[i];//next i array position stores value of current i array position
						averageArray[i] = holdAverage;//current i array position stores value of next i array
						
						holdName = nameArray[i+1];
						nameArray[i+1] = nameArray[i];
						nameArray[i] = holdName;

						holdCountry = countryArray[i+1];
						countryArray[i+1] = countryArray[i];
						countryArray[i] = holdCountry;

						holdGoals = goalsArray[i+1];
						goalsArray[i+1] = goalsArray[i];
						goalsArray[i] = holdGoals;

						holdGames = gamesArray[i+1];
						gamesArray[i+1] = gamesArray[i];
						goalsArray[i] = holdGames;
						sorted = false;
					}					
				}
			}
			else if (!(sortQuestion.equalsIgnoreCase("A")))
			{
				sorted = true;
			}
		}
		output = "Below are the updated football statistics: " + "\n " + nameArray[0] + " | " + countryArray[0] + " | " + goalsArray[0] + " goals " + " in " + gamesArray[0] + " games " + " with an average of " + averageArray[0] + " goals per game." + "\n\n " + nameArray[1] + " | " + countryArray[1] + " | " + goalsArray[1] + " goals " + " in " + gamesArray[1] + " games " + " with an average of " + averageArray[1] + " goals per game." + "\n\n " + nameArray[2] + " | " + countryArray[2] + " | " + goalsArray[2] + " goals " + " in " + gamesArray[2] + " games " + " with an average of " + averageArray[2] + " goals per game." + "\n\n " + nameArray[3] + " | " + countryArray[3] + " | " + goalsArray[3] + " goals " + " in " + gamesArray[3] + " games " + " with an average of " + averageArray[3] + " goals per game." + "\n\n " + nameArray[4] + " | " + countryArray[4] + " | " + goalsArray[4] + " goals " + " in " + gamesArray[4] + " games " + " with an average of " + averageArray[4] + " goals per game.";//building up string data to be shown on messagebox
		messagebox(output);//showing output details on messagebox
	}


	//THIS METHOD CALCULATES AVERAGE GOAL OF PLAYER
	public static double averageGoals(double goalsValue, double gamesValue)
	{		
		double averageGoalsPerGame = 0;//initialising averageGoalsPerGame variable
		double newAverage = 0;//initialising newAverage variable		
		averageGoalsPerGame = (goalsValue / gamesValue);
		newAverage = Math.round(averageGoalsPerGame*100.0)/100.0;
		return newAverage;
	}//END of 'averageGoals' method


	//THIS METHOD SHOWS AN INPUTBOX FOR USER TO ENTER QUESTION
	public static String inputbox(String input)
	{
		String question = "";//initialising question variable
		question = JOptionPane.showInputDialog(input);//creating an input dialog which recieves 'input' value
		return question;
	}//END method 'inputbox'


	//THIS METHOD OUTPUTS INFORMATION ON MESSAGEBOX
	public static void messagebox(String input)
	{		
		JOptionPane.showMessageDialog(null, input);//creating a message dialog and displaying information passed in
	}//END method 'messagebox'
}//END class 'goalscoringstats'



