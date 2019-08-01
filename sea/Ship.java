package sea;
public abstract class Ship {
	protected String name;
	protected Sailor[] crew;
	protected int num;
	protected int curnum;
	protected Sailor captain;
	public Ship(String s,int brr,Sailor cap) {num=brr;captain=cap;name=s;crew=new Sailor[brr];
	crew[0]=cap;curnum=1;}
	public Sailor getCaptain() {return captain;}
	public void addSailor(Sailor mm) { crew[curnum++]=mm;if(curnum==1)captain=mm; else if(mm.getcap()>captain.getcap())captain=mm;}
	public Sailor getSailor(int i)throws ErrIndex {if(i<0 || i>curnum)throw new ErrIndex();return crew[i];}
	public int worst() {int min=101,s=-1;for(int i=0;i<curnum;i++)if(crew[i].getcap()<min)
		{min=crew[i].getcap();s=i;}return s;}
	public Sailor takeSailor() { int z=0;Sailor m=null;int mn=0;
	for(int i=0;i<curnum;i++)if(crew[i].getcap()>mn) {
		z=i;m=crew[i];mn=m.getcap();}
	crew[z]=null;
	if(m!=null) {
		for(int i=z;i<curnum-1;i++)crew[i]=crew[i+1];
		curnum--;
	}
		return m;
	}
	public int quality() {int s=0;for(int i=0;i<curnum;i++)s+=crew[i].getcap();return s;}
	public int getNum() {return curnum;}
	public abstract char getType();
	public void removeAll() {for(int i=0;i<curnum;i++)crew[i]=null;curnum=0;captain=null;}
	public float getstr() {if(curnum==0) return 0;else return (float)quality()/curnum;}
	protected abstract boolean condition(Ship b);
	protected abstract void Fight(Ship b);
	public void Attack(Ship b) {
		if(condition(b)) {
			if(quality()>b.quality()) {
				Fight(b);b.removeAll();
			}
			else if(quality()<b.quality()){
				b.Fight(this);removeAll();
			}
		}
	}
	public String toString() {StringBuilder ss= new StringBuilder();ss.append(getType()+" - "+name+":"+getstr()+"\n");
	ss.append("(");
	if(crew[0]!=null)ss.append(crew[0]);
	for(int i=1;i<curnum;i++)ss.append(","+crew[i]);
	ss.append(")");
	return ss.toString();
	}
}
