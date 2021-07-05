package GraphAlgorithrm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
public class BildingRoads {
	
	static StringBuilder output = new StringBuilder();
	public static void main(String[] args) {
		Vertice[] vertices = readGraph();
		int count=-1;
		int temp=0;
		List<Edge>list=new ArrayList<>();
		for (Vertice vertice : vertices) {
			if (vertice != null && !vertice.visited) {
				if(count>=0) {
					list.add(new Edge(temp, vertice.id));
				}
				dfs(vertice);
				temp=vertice.id;
				count++;
			}
			
		}
		output.append(count).append("\n");
		for(Edge edge:list) {
			output.append(edge.toString()).append("\n");
		}

		System.out.println(output);
	}

	static void dfs(Vertice vertice) {
		vertice.visited=true;
		for (Vertice next : vertice.adjacentVertice) {
			if (!next.visited) {
				dfs(next);

			}
		}
	}

	static Vertice[] readGraph() {
		int node = ni();
		int edges = ni();
		Vertice[] vertices = new Vertice[node + 1];
		for (int i = 1; i <= node; i++) {
			vertices[i] = new Vertice(i);
		}

		for (int i = 0; i < edges; i++) {
			Vertice u = vertices[ni()];
			Vertice v = vertices[ni()];
			u.addVertice(v);
			v.addVertice(u);
		}

		return vertices;

	}

	static class Vertice {
		public int id;
		public boolean visited = false;
		public List<Vertice> adjacentVertice = new ArrayList<Vertice>();

		public Vertice(int name) {
			this.id = name;

		}

		public void addVertice(Vertice vertex) {
			adjacentVertice.add(vertex);
		}
	}
	static class Edge {
		public int first;
		public int second;
		public Edge(int first,int second) {
			this.first = first;
			this.second=second;
		}
		@Override
		public String toString() {

            return first + " " + second;
        }
		

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
