package sea;
public class RoyalNavyShip extends Ship {
	public char getType() {
		return 'R';
	}
	public RoyalNavyShip(String s,int numm, Sailor capp) {super(s, numm, capp);}
	protected boolean condition(Ship b) {
		return b.getType()!='R';
	}
	protected void Fight(Ship b) {
		while(curnum<num) {
			if(b.getCaptain().getcap()>crew[worst()].getcap()) {
				crew[curnum++]=b.takeSailor();
			} else break;
		}
	}

}
