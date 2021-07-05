package GraphAlgorithrm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildingTeams {
	static InputReader reader = new InputReader(System.in);
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		Bipartites[] bipartites = readGraph();
		boolean flag = false;
		for (Bipartites vertex : bipartites) {
			if (vertex != null && !vertex.visited) {
				flag = dfs(vertex);
				if (!flag) {
					break;
				}
			}
		}
		if (flag) {
			for (Bipartites temp : bipartites) {
				if (temp == null) {
					continue;
				}
				output.append(temp.bipartite == false ? 1 : 2).append(" ");
			}

		} else {
			output.append("IMPOSSIBLE");
		}

		System.out.println(output);
	}

	static boolean dfs(Bipartites bipartites) {
		bipartites.visited = true;
		for (Bipartites next : bipartites.adjacentBipartites) {
			if (!next.visited) {
				next.bipartite = !bipartites.bipartite;
				if (next.adjacentBipartites.size() != 0) {
					if (!dfs(next)) {
						return false;
					}
				}
			}
			if (next.bipartite == bipartites.bipartite) {
				return false;
			}
		}
		return true;
	}

	static Bipartites[] readGraph() {
		int n = reader.nextInt();
		Bipartites[] bipartites = new Bipartites[n + 1];
		for (int i = 1; i <= n; i++) {
			bipartites[i] = new Bipartites(i);
		}
		int m = reader.nextInt();
		for (int i = 0; i < m; i++) {
			Bipartites u = bipartites[reader.nextInt()];
			Bipartites v = bipartites[reader.nextInt()];

			u.addBipartite(v);
			v.addBipartite(u);

		}

		return bipartites;
	}

	static class Bipartites {
		public int id;
		public boolean visited = false;
		public boolean bipartite = false;
		public List<Bipartites> adjacentBipartites = new ArrayList<Bipartites>();

		public Bipartites(int id) {
			this.id = id;
		}

		public void addBipartite(Bipartites vertex) {
			adjacentBipartites.add(vertex);
		}
	}

	static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
