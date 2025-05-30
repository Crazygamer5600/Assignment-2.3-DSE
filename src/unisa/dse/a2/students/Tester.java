package unisa.dse.a2.students;

public class Tester {
public static void main(String[] args) {
	DSEList tester = new DSEList();
	
	System.out.println(tester.size());
	System.out.println(tester.get(0));
	tester.add("yay");
	tester.add("yolo");
	tester.add("lol");
	tester.add("bro");
	tester.add("dude");
	System.out.println(tester.toString());
	System.out.println(tester.get(3));
	System.out.println(tester.size());
	System.out.println(tester.indexOf("yay"));
	System.out.println(tester.remove(1));
	System.out.println(tester.remove(4));
	System.out.println(tester.remove(2));
	tester.add(2,"yay");
	tester.add(1,"head2");
	tester.add(5,"tail2");

//	System.out.println(tester.head.getString());
//	System.out.println(tester.head.next.getString());
//	System.out.println(tester.head.next.next.getString());
//	System.out.println(tester.tail.getString());
//	System.out.println(tester.tail.prev.getString());
//	System.out.println(tester.tail.prev.prev.getString());
}
}
