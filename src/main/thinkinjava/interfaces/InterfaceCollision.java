//: interfaces/InterfaceCollision.java
package interfaces;

import java.util.Random;

interface I1 { 
	int a =new Random().nextInt();
	
	void f(); }
interface I2 { int f(int i); }
interface I3 { int f(); }
class C { public int f() { return 1; } }

class C2 implements I1, I2 {
  public void f() {}
  public int f(int i) { return 1; } // overloaded
}

class C3 extends C implements I2 {
  public int f(int i) { return 1; } // overloaded
}

class C4 extends C implements I3 {
  // Identical, no problem:
  public int f() { return 1; }
}

class Test implements I1{ 
	static final int a2 =new Random().nextInt();
	  public void f() {}
	  public static void main(String[] args) {
		System.out.println(Test.a);
		 
	}
	
}

// Methods differ only by return type:
//! class C5 extends C implements I1 {}
//! interface I4 extends I1, I3 {} ///:~
