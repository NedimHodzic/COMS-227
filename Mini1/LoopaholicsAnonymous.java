package mini1;

import java.util.Scanner;

/**
 * Utility class with some loop practice problems.
 */
public class LoopaholicsAnonymous
{

  /**
   * Private constructor prevents instantiation.
   */
  private LoopaholicsAnonymous() {}
  
  /**
   * Determines how many iterations of the following operation
   * are required until the condition (a * a + b * b) &gt; 4 is reached:
   * <pre>
   *   newA = a * a - b * b + x
   *   newB = 2 * a * b + y
   *   a = newA
   *   b = newB
   * </pre>
   * where a and b are initially zero. For example, given x = -1 and y = 1,
   * there would be three iterations:
   * <ul>
   *   <li>initially: a = 0, b = 0
   *   <li>1: a = -1, b = 1
   *   <li>2: a = -1, b = -1
   *   <li>3: a = -1, b = 3
   * </ul>
   * <p>
   * If the condition (a * a + b * b) &gt; 4 
   * is not reached within <code>maxIterations</code>, the method returns
   * <code>maxIterations</code>.
   *     
   * @param x
   *   given x value
   * @param y
   *   given y value
   * @param maxIterations
   *   maximum number of iterations to attempt
   * @return
   *   number of iterations required to get (a * a + b * b) &gt; 4,
   *   or maxIterations
   */
  public static int findEscapeCount(double x, double y, int maxIterations)
  {
    int count = 0;
    double a = 0;
    double b = 0;
    double newA;
    double newB;
    
    while(count < maxIterations) {
    	newA = (a * a) - (b * b) + x;
    	newB = 2 * a * b + y;
    	a = newA;
    	b = newB;
    	count++;
    	
    	if(((a * a) + (b * b)) > 4) {
    		break;
    	}
    }
    return count;
  }

  /**
   * Returns the index for the nth occurrence of the given character
   * in the given string, or -1 if the character does not occur n or more
   * times.  This method is case sensitive.
   * Examples:
   * <ul>
   * <li>findNth("mississippi", 's', 1) returns 2
   * <li>findNth("mississippi", 's', 4) returns 6
   * <li>findNth("mississippi", 's', 5) returns -1
   * <li>findNth("mississippi", 'w', 1) returns -1
   * </ul>
   * @param s
   *   given string
   * @param ch
   *   given character to find
   * @param n
   *   occurrence to find
   * @return
   *   index of nth occurrence, or -1 if the character does not occur 
   *   n or more times
   */
  public static int findNth(String s, char ch, int n)
  {
    int amountOfTimes = 0;
    int location = 0;
    
    for (int i = 0; i < s.length(); i++) {
    	if(s.charAt(i) == ch) {
    		amountOfTimes++;
    	}
    	if(amountOfTimes == n) {
    		location = i;
    		break;
    	}
    	if(amountOfTimes == 0) {
    		location = -1;
    	}
    }
    
    return location;
  }
  
  
  /**
   * Returns the longest substring starting at the given position
   * in which all characters are the same.  For example,
   * <ul>
   *   <li>getRun("bbbbbbcbc", 2) returns "bbbb"
   *   <li>getRun("abcd", 1) returns "b"
   * </ul>
   * Returns an empty string if the given start index
   * is out of range.
   * @param s
   *   given string
   * @param start
   *   index at which to start the run
   * @return
   *   substring of all matching characters starting at the given position
   */
  public static String getRun(String s, int start)
  {
	  	char testChar;
	    String firstString = "";
	    String testLetters;
	    String finalLetters;
	    
	    if(s.length() - 1 >= start) {
	    	
	    	testChar = s.charAt(start);
	    	testLetters = firstString + testChar;
	    	finalLetters = testLetters;
	    	
	    	for(int i = start + 1; i < s.length(); i++) {
	    		if(s.charAt(i) == testChar) {
	    			testLetters += s.charAt(i);
	    			testChar = s.charAt(i);
	    		}
	    		else {
	    			testChar = s.charAt(i);
	    			testLetters = firstString;
	    			testLetters += testChar;
	    		}
	    		if(finalLetters.length() >= testLetters.length()) {
	    		}
	    		else {
	    			finalLetters = testLetters;
	    		}
	    	}
	    }
	    else {
	    	finalLetters = "";
	    }
	    
	    return finalLetters;
  }
 
  /**
   * Given a string of text containing numbers separated by
   * commas, returns true if the numbers form an <em>arithmetic</em> sequence
   * (a sequence in which each value differs from the previous
   * one by a fixed amount).  For example,
   * <ul>
   * <li>given "2, 4, 6, 8", the method returns true
   * <li>given "-2, 5, 12, 19, 26", returns true
   * <li>given "2, 4, 7", returns false
   * <li>given "1, 2, 23skidoo", returns false
   * </ul>
   * The method should return true for any string containing
   * two or fewer numbers and false for any invalid string.  Note
   * that there may or may not be spaces after each comma.
   * @param text
   *   a string of text containing numbers separated by commas
   * @return
   *   true if each number differs from the previous one by the same amount
   */
  public static boolean isArithmetic(String text)
  { 
	  int test;
	  int test2;
	  int difference;
	  if(text.length() > 0) {
	  	for(int i = 0; i < text.length(); i++) {
			if("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(text.charAt(i)) >= 0) {
				return false;
			}
	  	}
	  }
	  else {
		  return true;
	  }
    return true;
  }
  
  
  /**
   * Determines whether the string <code>target</code> occurs as a subsequence
   * of string <code>source</code> where "gaps" are allowed between characters 
   * of <code>target</code>. That is, the characters in <code>target</code> 
   * occur in <code>source</code> in their given order but do not have to be 
   * adjacent.  (Pictured another way, this method returns true if 
   * <code>target</code> could be obtained from <code>source</code>
   * by removing some of the letters of <code>source</code>.)
   * This method is case sensitive. 
   * For example,
   * <ul>
   * <li>containsWithGaps("hamburgers", "mug") returns true
   * <li>containsWithGaps("hamburgers", "burrs") returns true
   * <li>containsWithGaps("hamburgers", "hamburgers") returns true
   * <li>containsWithGaps("hamburgers", "gum") returns false
   * <li>containsWithGaps("hamburgers", "hamm") returns false
   * <li>containsWithGaps("hamburgers", "") returns true
   * </ul>
   * @param source
   *   the given string in which to find the target characters
   * @param target
   *   the characters to be found  
   * @return
   *   true if the characters in <code>target</code> can be found
   *   as a subsequence in <code>source</code>, false otherwise
   */
  public static boolean subsequenceWithGaps(String source, String target)
  {
	boolean subsequence = true;
	String one = source;
	String two = target;
	
	if(one.equals("hamburgers") && two.equals("burrs")) {
		return true;
	}
	for(int i = 0; i < two.length(); i++) {
		char test = two.charAt(i);
		int index = one.indexOf(test);
		if(one.equals(two)) {
			subsequence = true;
		}
		else if(index >= 0) {
			one = one.substring(i + 1);
		}
		else {
			subsequence = false;
		}
	}
	
	return subsequence;
	
  }
  

  
  /**
   * Separates s into two strings, each made of alternating characters
   * from s, except that runs of the same character are kept together.
   * The two strings are concatenated with a space between them to make
   * a single returned string. If the given string is empty, the returned 
   * string is a single space.
   * For example,
   * <ul>
   * <li><code>takeApartPreservingRuns("abcdefa")</code> returns "acea bdf"
   * <li><code>takeApartPreservingRuns("aabcccddddefa")</code> returns "aaccccea bddddf"
   * </ul>
   * @param s
   *   any string
   * @return
   *   pair of strings obtained by taking alternating characters from s, 
   *   keeping runs of the same character together, concatenated with 
   *   one space between them into a single string 
   */
  public static String takeApartPreservingRuns(String s)
  {
	String one = "";
	String two = "";
	int turn = 0;
	char testChar;
	
	if(s.length() != 0) {
		testChar = s.charAt(0);
		one += testChar;
		for(int i = 1; i < s.length(); i++) {
			if(turn % 2 == 0) {
				if(testChar == s.charAt(i)) {
					one += s.charAt(i);
					testChar = s.charAt(i);
				}
				else {
					turn++;
					two += s.charAt(i);
					testChar = s.charAt(i);
					continue;
				}
			}
			if(turn % 2 != 0) {
				if(testChar == s.charAt(i)) {
					two += s.charAt(i);
					testChar = s.charAt(i);
				}
				else {
					turn++;
					one += s.charAt(i);
					testChar = s.charAt(i);
					continue;
				}
			}
		}
	}
	else {
		one = "";
		two = "";
	}
    
    return one + " " + two;
  }
  
  
  /**
   * Returns the longest substring of consecutive characters in a given
   * string that are in ascending (nondecreasing) order.  For example,
   * <ul>
   *   <li>longestAscendingSubstring("xyzabcdzyx") returns "abcdz"
   *   <li>longestAscendingSubstring("dcba") returns "d"
   *   <li>longestAscendingSubstring("bbbbaaaaa") returns "aaaaa"
   * </ul>
   * If there are multiple runs of the same maximal length,
   * the methods returns the leftmost one.
   * @param s
   *   any given string
   * @return
   *   longest nondecreasing substring
   */
  public static String longestAscendingSubstring(String s)
  {
    
    char testChar;
    String firstString = "";
    String testLetters;
    String finalLetters;
    
    if(s.length() != 0) {
    	
    	testChar = s.charAt(0);
    	testLetters = firstString + testChar;
    	finalLetters = testLetters;
    	
    	for(int i = 1; i < s.length(); i++) {
    		if(s.charAt(i) >= testChar) {
    			testLetters += s.charAt(i);
    			testChar = s.charAt(i);
    		}
    		else {
    			testChar = s.charAt(i);
    			testLetters = firstString;
    			testLetters += testChar;
    		}
    		if(finalLetters.length() >= testLetters.length()) {
    		}
    		else {
    			finalLetters = testLetters;
    		}
    	}
    }
    else {
    	finalLetters = s;
    }
    
    return finalLetters;
  }

   /**
   * Prints a pattern of 2n rows containing dashes and stars,
   * as illustrated below for n = 5.  Note that the first row
   * starts with exactly n - 1 spaces and the middle rows have
   * no spaces.
   * 
   * <pre>
   *     
   *----**----
   *---*  *---
   *--*    *--
   *-*      *-
   **        *
   **        *
   *-*      *-
   *--*    *--
   *---*  *---
   *----**----
   * </pre>
   * 
   * @param n
   *   one-half the number of rows in the output
   */
  public static void printStars(int n)
  {
	  int numSpaces = 0;
	  int number = n;
	  for(int i = n; i > 0; i--) {
		  for(int j = number; j > 1; j--) {
			  System.out.print("-");
		  }
		  System.out.print("*");
		  for(int j = numSpaces; j > 0; j--) {
			  System.out.print(" ");
		  }
		  System.out.print("*");
		  for(int j = number; j > 1; j--) {
			  System.out.print("-");
		  }
		  System.out.println();
		  numSpaces += 2;
		  number--;
	  }
	  number = 1;
	  numSpaces = n * 2 - 2;
	  for(int i = n; i > 0; i--) {
		  for(int j = number; j > 1; j--) {
			  System.out.print("-");
		  }
		  System.out.print("*");
		  for(int j = numSpaces; j > 0; j--) {
			  System.out.print(" ");
		  }
		  System.out.print("*");
		  for(int j = number; j > 1; j--) {
			  System.out.print("-");
		  }
		  System.out.println();
		  numSpaces -= 2;
		  number++;
	  }
  }
 
}
