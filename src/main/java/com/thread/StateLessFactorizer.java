package com.thread;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StateLessFactorizer implements Servlet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private long count = 0;

	public long getCount() {
		return count;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		BigInteger i = extractFromRequest(arg0);
		BigInteger[] factors = factor(i);
		++count;
		encodeIntoResponse(arg1, factors);

	}

	private void encodeIntoResponse(ServletResponse arg1, BigInteger[] factors) {
		// TODO Auto-generated method stub

	}

	private BigInteger[] factor(BigInteger i) {
		// TODO Auto-generated method stub
		return null;
	}

	private BigInteger extractFromRequest(ServletRequest arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
