//******************************* Author : Keerthana Muniraj *************************************//

import java.util.*;

public 	class PuzzleSolver
{
       //Given function
  	   static List<String> DICTIONARY = Arrays.asList("OX","CAT","TOY","AT","DOG","CATAPULT","T");
	    static boolean IsWord(String testWord)
	    {
	        System.out.println(testWord);
	        if (DICTIONARY.contains(testWord))		
	        	return true;
	
	        return false;
	
	    }

    //logic for displaying the number of occurrence of the words
    public static int FindWords (char[][] puzzle){
    	
    	//counter variable to keep tab of the number
    	int wordcount = 0;
    	for(int i=0;i<puzzle.length;i++)
    		for(int j=0;j<puzzle[0].length;j++)
    		{   //Compare with 8 respective neighboring characters
    			wordcount+=SearchMatrix(i,j,0,1,puzzle);
    			
    	        wordcount+=SearchMatrix(i,j,0,-1,puzzle);
    	        
    	        wordcount+=SearchMatrix(i,j,1,0,puzzle);
    	        
    	        wordcount+=SearchMatrix(i,j,-1,0,puzzle);
    	        
    	        wordcount+=SearchMatrix(i,j,1,1,puzzle);
    	         
    	        wordcount+=SearchMatrix(i,j,-1,-1,puzzle);
    	        
    	        wordcount+=SearchMatrix(i,j,1,-1,puzzle);
    	         
    	        wordcount+=SearchMatrix(i,j,-1,1,puzzle);
    	         
    		}
    	
    	for (int i = 0; i < puzzle.length; i++)
			for (int j = 0; j < puzzle[0].length; j++)
			{
				String tofind = "" + puzzle[i][j];
				if (IsWord(tofind))
				{
					wordcount++;
				}
			}
		
		return wordcount;
    }

    /*------logic to compare a character with adjacent characters in the matrix-----*/
    public static int SearchMatrix(int i, int j, int ii, int jj, char[][] puzzle){
    	int count = 0;
    	String tofind = "" + puzzle[i][j];
    	i+=ii;
    	j+=jj;
    	while(i<puzzle.length && j<puzzle[0].length && i>=0 && j>=0)
    	{
    		tofind +=puzzle[i][j];
	    	if(IsWord(tofind)){
	    		count++;
	    	}
	    	i+=ii;
	    	j+=jj;
    	}
    	
    	return count;
    }
    
    public static void main(String[] args){
    	
    	char[][] puzzle = {{'A','T','C','X','Y','D'},{'X','O','A','O','Y','K'},{'D','O','G','T','I','X'},{'T','X','D','Y','W','P'},{'A','T','C','X','Y','D'},{'X','O','A','O','Y','K'},{'D','O','G','T','I','X'},{'T','X','O','Y','W','O'},{'D','O','G','T','I','X'}};
    	int sum = FindWords(puzzle);
    	System.out.println(sum);
    }
}


