package sea;
public class PirateShip extends Ship {
	public char getType() {
		return 'P';
	}
	public PirateShip(String s,int numm, Sailor capp) {super(s,numm,capp);}
	protected boolean condition(Ship b) {
		return curnum>b.getNum();
	}
	protected void Fight(Ship b) {
		Sailor m=b.takeSailor();
		if(curnum<num && m.getcap()>crew[worst()].getcap()){
			addSailor(m);
		}
	}
}
