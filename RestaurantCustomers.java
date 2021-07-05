package SortingAndSearching;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class RestaurantCustomers {
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		//GetPrefix();
		solveSort();
	}
	
	static void GetPrefix() {
		int customer = 0;
		int num = ni();
		for (int i = 0; i < num; i++) {	
			addMapValue(ni(), 1);
			addMapValue(ni(), -1);
		}
		int min=Integer.MIN_VALUE;
		for(int temp:listN.values()) {
			customer+=temp;
			min=Math.max(min,customer);	
		}
		output.append(min);
		System.out.println(output);
	}
	static void solveSort() {
		int n = ni() * 2;
		int[] endPoints = new int[n];
		for (int i = 0; i < n; i += 2) {
			endPoints[i] = ni() * 2 + 1;
			endPoints[i + 1] = ni() * 2;
		}
		Arrays.sort(endPoints);
		int customer = 0, maxCustomer = 0;
		for (int endPoint : endPoints) {
			customer += (endPoint & 1) == 0 ? -1 : +1;
			maxCustomer = Math.max(maxCustomer, customer);
		}
		System.out.println(maxCustomer);
	}
	static void getTwoPoid() {
		
	        int n  = ni();

	        int[] arrive = new int[n];
	        int[] depart = new int[n];
	        for (int i = 0; i < n; i++) {
	            arrive[i] = ni();
	            depart[i] = ni();
	        }
	        Arrays.sort(arrive);
	        Arrays.sort(depart);

	        int currCustomers = 0;
	        int maxCustomers = 0;
	        for (int i = 0, j = 0; i < n; i++) {
	            currCustomers++;
	            if (arrive[i] > depart[j]) {
	                j++;
	                currCustomers--;
	            }
	            maxCustomers = Math.max(maxCustomers,currCustomers);
	        }
	        System.out.println(maxCustomers);
	}
	
	static TreeMap<Integer, Integer> listN = new TreeMap<>();
	static void addMapValue(int key, int value) {
		Integer mapValue = listN.getOrDefault(key, null);
		listN.put(key, mapValue != null ? (value + mapValue) : value);
	}
	
	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}
