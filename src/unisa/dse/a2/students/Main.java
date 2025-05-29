package unisa.dse.a2.students;

public class Main {
public static void main(String[] args) {
	DSEList tester = new DSEList();
	
	System.out.println(tester.size());
	System.out.println(tester.get(0));
	tester.add("yay");
	tester.add("yolo");
	tester.add("lol");
	System.out.println(tester.toString());
	System.out.println(tester.get(3));
	System.out.println(tester.size());
	System.out.println(tester.indexOf("yay"));

//	System.out.println(tester.head.getString());
//	System.out.println(tester.head.next.getString());
//	System.out.println(tester.head.next.next.getString());
//	System.out.println(tester.tail.getString());
//	System.out.println(tester.tail.prev.getString());
//	System.out.println(tester.tail.prev.prev.getString());
}
}
