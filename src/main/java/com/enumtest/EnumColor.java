package com.enumtest;

public enum EnumColor {
	red(1, 2, 3), yellow(2, 3, 3);

	private EnumColor(int a, int b, int c) {
		this.redValue = a;
		this.greenValue = b;
		this.blueValue = c;
	}

	public int count() {
		return this.redValue + this.greenValue + this.blueValue;
	}

	@Override
	public String toString() {
		return String.valueOf(this.redValue + this.greenValue + this.blueValue);
	}

	private int redValue;
	private int greenValue;
	private int blueValue;
}
