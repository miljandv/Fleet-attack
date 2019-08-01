package sea;
public class Sailor {
	private String name;
	private int cap;
	public Sailor(String b,int a){name=b;if(a<0)cap=0;else if(a>100)cap=100;else cap=a;}
	public String getName(){return name;}
	public int getcap(){return cap;}
	public String toString(){return "M_"+name+":"+cap;}
}
