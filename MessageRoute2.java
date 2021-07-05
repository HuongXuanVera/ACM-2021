
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Queue;

public class MessageRoute2 {
	static int node = 0;
	static List<List<Integer>> listOut = new ArrayList<>();
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		Vertex[] vertices = readGraph();
		List<Integer> list = new ArrayList<>();
		bfs(vertices[1]);
		Vertex temp=vertices[node];
		while(temp.parent!=null) {
			list.add(temp.id);
			temp=temp.parent;
		}
		if (list.size()!=0) {
			list.add(1);
			output.append(list.size()).append("\n");
			for(int i=list.size()-1;i>=0;i--) {
				output.append(list.get(i)).append(" ");
			}
		} else {
			output.append("IMPOSSIBLE");
		}
		System.out.println(output);
	}

	static void bfs(Vertex root) {
		Queue<Vertex> queue = new ArrayDeque<>();
		root.visited = true;
		queue.add(root);
		while (!queue.isEmpty()) {
			Vertex vertex = queue.poll();
			for (Vertex next : vertex.adjacentVertice) {
				if (!next.visited) {
					next.visited = true;
					next.parent = vertex;
					queue.add(next);
					if (next.id == node) {
						return;
					}
				}
			}

		}

	}

	static Vertex[] readGraph() {
		node = ni();
		int edges = ni();
		Vertex[] vertices = new Vertex[node + 1];
		for (int i = 1; i <= node; i++) {
			vertices[i] = new Vertex(i);
		}
		for (int i = 0; i < edges; i++) {
			Vertex u = vertices[ni()];
			Vertex v = vertices[ni()];
			u.addVertice(v);
			v.addVertice(u);
		}
		return vertices;
	}

	static class Vertex {
		public int id;
		public Vertex parent;
		public boolean visited = false;
		public List<Vertex> adjacentVertice = new ArrayList<Vertex>();

		public Vertex(int name) {
			this.id = name;
		}

		public void addVertice(Vertex vertex) {
			adjacentVertice.add(vertex);
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
