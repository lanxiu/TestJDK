package thisTest;

public class Test {
	
	Window win1 = new Window(1);
	
	Window win21 = new Window(2);

	Test(int i) {
		
		System.out.println("TEST CONSTUCTOR");

		
		Window win21 = new Window(21);
	}
	
	Window win3 = new Window(3);
	Test(String i) {
		
	}
	Test(double i) {
		i++;
	}
	Test() {
		this("a");
	}

	int i =g();
	
	public static void main(String[] args) {
		Test tt = new Test(1);
	}

	public int g() {
		return 0;
	}
	
	int a =g();
	
	
}
