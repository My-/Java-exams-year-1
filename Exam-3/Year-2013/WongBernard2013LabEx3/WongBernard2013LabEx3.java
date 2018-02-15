// WongBernard2013LabEx3 - Bernard Wong
// Update Sports League Table with Match Results

import java.util.Scanner;
import java.io.*;

public class WongBernard2013LabEx3
{
    public static void main(String[] args)
    					throws FileNotFoundException
    {
		//Constants
		final int MAX_TEAMS = 25, MAX_STATS = 7, WIN_PTS = 3, DRAW_PTS = 1, SENTINEL_0 = 0;
		final String SENTINEL_EOF = "eof";

		//File objects
		Scanner inLeagueFile = new Scanner(new FileReader("LeagueTable.dat"));
		Scanner inResultFile = new Scanner(new FileReader("MatchResults.dat"));
		PrintWriter outLeagueFile = new PrintWriter("NewLeagueTable.dat");
		PrintWriter outResultRep = new PrintWriter("RejectedMatchResults.dat");

		//File Variables
		String teamName;

		String homeTeam;
		int homeScore;
		String awayTeam;
		int awayScore;

		//Arrays
		String[] teamNames = new String [MAX_TEAMS];
		int[][] leagueTable = new int [MAX_TEAMS][MAX_STATS];

		//Other Variables
		Scanner console = new Scanner (System.in);
		int i = 0, j = 0, teamNo = 0, teamCount, resultCount, posHome;
		char homeResult;
		boolean foundHomeName;

		//League Table
		System.out.println("\nLab Exam 3 Feb 2013 - Bernard Wong");
		System.out.println("\n   Team        Play    Won   Draw   Lost Scored Conceded Points");
		System.out.println("===============================================================");

		teamName =  inLeagueFile.next(); // initial read

		while(!teamName.equalsIgnoreCase(SENTINEL_EOF))
		{
			teamNames[i] = teamName;
			System.out.printf("%2d %-10s",(i+1), teamNames[i]);
			i++;

			for(j = 0; j < MAX_STATS; j++)
			{
				leagueTable[i][j] = inLeagueFile.nextInt();
				System.out.printf("%6d ", leagueTable[i][j]);
			} // inner for

			System.out.println();
			teamName =  inLeagueFile.next(); // subsequent read
		} // while

		//Match Results
		System.out.println("\n   Home Team Score  V   Away Team Score Result");
		System.out.println("==============================================");

		homeTeam = inResultFile.next(); // initial read

		while(!homeTeam.equalsIgnoreCase(SENTINEL_EOF))
		{
			homeScore = inResultFile.nextInt();
			awayTeam = inResultFile.next();
			awayScore = inResultFile.nextInt();
			teamNo++;

			System.out.printf("%2d %-8s %4d %4c   %-8s %4d \n", teamNo, homeTeam, homeScore, 'V', awayTeam, awayScore);

			homeTeam = inResultFile.next(); // subsequent read
		} // while

		System.out.println();

		//Prompt team number and output
		do
		{
			do
			{
				System.out.print("Enter team number (0/End): ");
				teamNo = console.nextInt();

				if(teamNo > 0 && teamNo < 9)
				{
					System.out.println("\n   Team        Play    Won   Draw   Lost Scored Conceded Points");
					System.out.println("===============================================================");
					System.out.printf("%2d %-10s",(teamNo), teamNames[teamNo-1]);

					for(j = 0; j < MAX_STATS; j++)
					{
						System.out.printf("%6d ", leagueTable[teamNo][j]);
					} // inner for

					System.out.println();
				} // if

			} while(teamNo > 0 && teamNo < 9); // inner do..while

		} while(teamNo != 0); // do..while

		// 4) File 2 Reprocessed - Input init/while/subsequent read & Output
		inResultFile.close(); // close file
		inResultFile = new Scanner(new FileReader("MatchResults.dat")); // reopen file

		outResultRep.printf("Mismatched Rejected Match Results Report%n");
		outResultRep.printf("========================================%n");
		outResultRep.println("%n   Home Team Score  V   Away Team Score Result%n");
		outResultRep.println("==============================================%n");


		homeTeam = inResultFile.next(); // initial read

		while(!homeTeam.equalsIgnoreCase(SENTINEL_EOF))
		{
			homeScore = inResultFile.nextInt();
			awayTeam = inResultFile.next();
			awayScore = inResultFile.nextInt();

			posHome = -1;
			foundHomeName = false;

			while(!found)
			{
				++posHome;

				if(homeTeam.equalsIgnoreCase(teamNames[posHome]))
				{
					foundHomeName = true;
				}
				else
				{

				}
			} // inner while

			homeTeam = inResultFile.next(); // subsequent read
		} // while

		      // Search - sucessful/unsucessful processing

		// 5) File Output from arrays
		// Close Files
		inLeagueFile.close();
		inResultFile.close();
		outLeagueFile.close();
		outResultRep.close();

    }  // main

} // WongBernard2013LabEx3

