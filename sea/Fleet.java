package sea;
public class Fleet {
private String name;
private int num;
private char type='-';
public Fleet(String n) {name=n;}
private static class elem{
	Ship b;
	elem next;
	elem(Ship bb){b=bb;next=null;}
	}
private elem first,last;
public void add(Ship b)throws ErrInadequate {
	if (num==0) {
	type=b.getType();
	}else if(b.getType()!=type)throw new ErrInadequate();
	num++;if(first==null)first=last=new elem(b);
else { if(type!=b.getType())throw new ErrInadequate(); last.next=new elem(b);last=last.next;}
	}
public Ship getShip(int i)throws ErrIndex {if(i<0 || i>num)throw new ErrIndex();
	elem curr=first;int j=0;
	while(j<i) {curr=curr.next;j++;}	
	return curr.b;
	}
public float getQuality() {float sum=0;elem curr=first;
	for(int i=0;i<num;i++) {
		sum+=curr.b.getstr();curr=curr.next;	
		}
	return sum/num;
	}
	public String toString() {StringBuilder sb=new StringBuilder();
	sb.append("Fleet("+type+")"+name+":"+getQuality());
	elem curr=first;
	while(curr!=null) {sb.append("\n"+curr.b);curr=curr.next;}
	return sb.toString();
	}
}
