package com;
public class Holder {
	private int n;
	
	public String[] aa ;
	
	public String[] getAa() {
		
		return aa;
	}

	
	public void setAa(String[] aa) {
		
		this.aa = aa;
	}

	public Holder(int n) {
		this.n = n;
	}

	void assertSainty() {
		if (n != n)
			System.out.println("error");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
