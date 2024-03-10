package hw2;

import java.util.Random;

/**
 * 
 * @author Nedim
 * Model of a working Padlock
 */

public class Padlock {
	
	/**
	 * Instance variables for the 3 discs.
	 */
	private int disc1;
	private int disc2;
	private int disc3;
	/**
	 * Instance variable to test if lock is open.
	 */
	private boolean open;
	/**
	 * Instance variables for the 3 offsets
	 */
	private int offset1;
	private int offset2;
	private int offset3;

	public static final int TOOTH = 2;

	/**
	 * Constructs a padlock with a given combination.
	 * @param n1
	 * @param n2
	 * @param n3
	 */
	public Padlock(int n1, int n2, int n3) {
		disc1 = 4;
		disc2 = 2;
		disc3 = 0;
		offset1 = n1 - (2 * TOOTH);
		if(offset1 < 0) {
			offset1 %= 360;
			offset1 += 360;
		}
		offset2 = n2 + TOOTH;
		if(offset2 > 360) {
			offset2 %= 360;
		}
		offset3 = n3;
		open = true;
	}
	
	/**
	 * Closes the lock.
	 */
	public void close() {
		open = false;
	}
	
	/**
	 * Returns disc position
	 * @param which
	 */
	public int getDiscPosition(int which) {
		if(which == 1) {
			which = disc1;
		}
		else if(which == 2) {
			which = disc2;
		}
		else if(which == 3) {
			which = disc3;
		}
		else {
			return -1;
		}
		return which;
	}
	
	/**
	 * Tests if the lock is aligned.
	 */
	public boolean isAligned() {
		if(disc1 == offset1 && disc2 == offset2 && disc3 == offset3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Checks if the lock is open
	 */
	public boolean isOpen() {
		if(open == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Opens the lock
	 */
	public void open() {
		if(isAligned() == true) {
			open = true;
		}
	}
	
	/**
	 * Randomizes disc positions.
	 * @param rand
	 */
	public void randomizePositions(Random rand) {
		disc1 = rand.nextInt(360);
		disc2 = rand.nextInt(360);
		disc3 = rand.nextInt(360);
	}
	
	/**
	 * Sets the disc positions.
	 * @param n1
	 * @param n2
	 * @param n3
	 */
	public void setPositions(int n1, int n2, int n3) {
		if(n1 > 360) {
			n1 %= 360;
		}
		else if(n1 < 0) {
			n1 %= 360;
			n1 += 360;
		}
		if(n2 > 360) {
			n2 %= 360;
		}
		else if(n2 < 0) {
			n2 %= 360;
			n2 += 360;
		}
		if(n3 > 360) {
			n3 %= 360;
		}
		else if(n3 < 0) {
			n3 %= 360;
			n3 += 360;
		}
		 
		disc1 = n1;
		disc2 = n2;
		disc3 = n3;
		
		if(Math.abs(disc3 - disc2) < 2 || Math.abs(disc3 - disc2) > 358) {
			if(Math.abs(disc3 - disc2) == 0 || Math.abs(disc3 - disc2) == 360) {
				disc2 += 2;
			}
			if(Math.abs(disc3 - disc2) == 1 || Math.abs(disc3 - disc2) == 359) {
				disc2 += 1;
			}
		}
		if(Math.abs(disc2 - disc1) < 2 || Math.abs(disc2 - disc1) > 358) {
			if(Math.abs(disc2 - disc1) == 0 || Math.abs(disc2 - disc1) == 360) {
				disc1 += 2;
			}
			if(Math.abs(disc2 - disc1) == 1 || Math.abs(disc2 - disc1) == 359) {
				disc1 += 1;
			}
		}
		
		if(isAligned()) {
			open();
		}
	}
	
	/**
	 * Turns the lock.
	 * @param degrees
	 */
	public void turn(int degrees) {
		int differenceD3D2;
		int differenceD2D1;
		if(degrees >= 0) {
			differenceD3D2 = disc2 - disc3 - TOOTH;
			differenceD2D1 = disc1 - disc2 - TOOTH;
				
			if(differenceD2D1 < 0) {
				differenceD2D1 += 360;
			}
			if(differenceD3D2 < 0) {
				differenceD3D2 += 360;
			}
				
			if(differenceD2D1 < (degrees - differenceD3D2)) {
				disc1 += ((degrees - differenceD3D2) - differenceD2D1);
				if(disc1 > 360) {
					disc1 %= 360;
				}
				if(disc1 < 0) {
					disc1 %= 360;
					disc1 += 360;
				}
			}
			
			if(differenceD3D2 < degrees) {
				disc2 += (degrees - differenceD3D2);
				if(disc2 > 360) {
					disc2 %= 360;
				}
				if(disc2 < 0) {
					disc2 %= 360;
					disc2 += 360;
				}
			}
			
			disc3 += degrees;
			if(disc3 > 360) {
				disc3 %= 360;
			}
			if(disc3 < 0) {
				disc3 %= 360;
				disc3 += 360;
			}
		}
		if(degrees < 0) {
			differenceD3D2 = disc3 - disc2 - TOOTH;
			differenceD2D1 = disc2- disc1 - TOOTH;
				
			if(differenceD2D1 < 0) {
				differenceD2D1 += 360;
			}
			if(differenceD3D2 < 0) {
				differenceD3D2 += 360;
			}
				
			if(differenceD2D1 < (Math.abs(degrees) - differenceD3D2)) {
				disc1 -= ((Math.abs(degrees) - differenceD3D2) - differenceD2D1);
				if(disc1 < 0) {
					disc1 %= 360;
					disc1 += 360;
				}
			}
			
			if(differenceD3D2 < Math.abs(degrees)) {
				disc2 -= (Math.abs(degrees) - differenceD3D2);
				if(disc2 < 0) {
					disc2 %= 360;
					disc2 += 360;
				}
				if(disc2 > 360) {
					disc2 %= 360;
				}
			}
			
			disc3 += degrees;
			if(disc3 < 0) {
				disc3 %= 360;
				disc3 += 360;
			}
			if(disc3 > 360) {
				disc3 %= 360;
			}
		}	
	}
	
	/**
	 * Turns disc3 left to the number
	 * @param number
	 */
	public void turnLeftTo(int number) {
		int degreeNumber = number - disc3;
		if(degreeNumber < 0) {
			degreeNumber += 360;
		}
		turn(degreeNumber);
	}
	
	/**
	 * Turns disc3 right to the number
	 * @param number
	 */
	public void turnRightTo(int number) {
		int degreeNumber = number - disc3;
		if(degreeNumber > 0) {
			degreeNumber -= 360;
		}
		turn(degreeNumber);
	}
}
