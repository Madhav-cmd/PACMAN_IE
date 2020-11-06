package pacman;

public class Location {
	
	public boolean CheckLocation(int x,int y,String f) {
		// To check if the provided location is valid or not.
		
		if(x>=0 && x<=4) {
			if(y>=0 && y<=4) {
				if(f.equals("NORTH")||f.equals("SOUTH")||f.equals("WEST")||f.equals("EAST")) {
					return true;
				}
				else { return false;}
			}
			else { return false;}
		}
		else { return false;}
	}
	
}
