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
	System.out.println(tester.indexOf("bruh"));
	System.out.println(tester.remove(1));
	System.out.println(tester.remove(4));
	System.out.println(tester.remove(2));
	tester.add(2,"yay");
	tester.add(1,"head2");
	tester.add(5,"tail2");
	System.out.println(tester.toString());
	System.out.println(tester.contains("tail2"));
	System.out.println(tester.contains("tail"));
	System.out.println(tester.remove("tail2"));
	System.out.println(tester.toString());	
	
	
	
	DSEListGeneric tester2 = new DSEListGeneric();
	
	System.out.println(tester2.size());
	System.out.println(tester2.get(0));
	tester2.add("yay");
	tester2.add(7);
	tester2.add("lol");
	tester2.add("bro");
	tester2.add("dude");
	System.out.println(tester2.toString());
	System.out.println(tester2.get(3));
	System.out.println(tester2.size());
	System.out.println(tester2.indexOf("yay"));
	System.out.println(tester.indexOf("bruh"));
	System.out.println(tester2.remove(1));
	System.out.println(tester2.remove(4));
	System.out.println(tester2.remove(2));
	tester2.add(2,"yay");
	tester2.add(1,"head2");
	tester2.add(5,"tail2");
	System.out.println(tester2.toString());
	System.out.println(tester2.contains("tail2"));
	System.out.println(tester2.contains("tail"));
	System.out.println(tester2.remove("tail2"));
	System.out.println(tester2.toString());	
	

}
}
