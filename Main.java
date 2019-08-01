import sea.*;
public class Main {
public static void main(String[] args) {
Sailor m1 = new Sailor("A", 50), m2 = new Sailor("B", 100), m3 = new Sailor("C", 60), m4 = new
Sailor("D", 40);
PirateShip g1 = new PirateShip("Pearl", 5, m1);
RoyalNavyShip k1 = new RoyalNavyShip("St. John", 2, m3);
try {
g1.addSailor(m2);
g1.addSailor(new Sailor("E", 60));
k1.addSailor(m4);
System.out.println("Number of sailors on the pirate ship: " + g1.getNum());
System.out.println("Pirate ship captain: " + g1.getCaptain());
try {
System.out.println("Royal Navy sailor on position 1: " + k1.getSailor(1));
} catch(ErrIndex e) {}
System.out.println("*** Output ships ***");
System.out.println(g1);
System.out.println(k1);
g1.Attack(k1);
System.out.println("*** Ships after the attack ***");
System.out.println(g1);
System.out.println(k1);
Fleet fleet = new Fleet("F");
fleet.add(k1);
try {
fleet.add(g1); //neuspesno dodavanje gusarskog broda u flotu
} catch(ErrInadequate e) {}
fleet.add(new RoyalNavyShip("Santa Maria", 3, new Sailor("F", 40)));
System.out.println("*** Fleet ***");
System.out.println(fleet);
fleet.getShip(0).addSailor(new Sailor("G", 50));
System.out.println("*** Fleet after reconstruction ***");
System.out.println(fleet);
} catch (Exception e) {
System.err.println(e);
}
}
}