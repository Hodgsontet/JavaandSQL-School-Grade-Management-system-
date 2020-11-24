import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;

import com.db.connecToDb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.lang.Math;
import java.sql.SQLException;

import static java.util.stream.Collectors.*;
import static java.util.Map.Entry.*;

public class gpadraw {
	static Random rnd2 = new Random();
	static MyColor ca2 = MyColor.RED;
	public static Character[] keys = null;
	public static Integer[] values = null;
	static int sum = 0;
	public static Map<Character, Integer> h1 = new HashMap<Character, Integer>();

	public static void getter() throws SQLException {
		HashMap<Character, Integer> gotmap = new HashMap<Character, Integer>();
		connecToDb try1 = new connecToDb();
		gotmap = try1.createconnect();
		h1 = gotmap;

	}

	public static void drawpiechart(GraphicsContext g, int N) {
		try {
			gpadraw.getter();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keys = new Character[h1.size()];
		values = new Integer[h1.size()];

		for (char key : h1.keySet()) {
			System.out.println(key + ": " + h1.get(key));
			//System.out.println(h1.size());
		}
		int index = 0;
		for (Entry<Character, Integer> mapEntry : h1.entrySet()) {
			keys[index] = mapEntry.getKey();
			values[index] = mapEntry.getValue();
			index++;
		}

		for (int i = 0; i < h1.size(); i++) {
			sum = values[i] + sum;
		}

		h1 = h1.entrySet().stream().sorted(comparingByValue())
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

		for (int i = 0; i < h1.size(); i++) {
			System.out.println("keys:  " + keys[i] + "  values:  " + values[i]);
		}
		System.out.println("And sum is  " + sum);

		g.strokeOval(300, 100, 400, 400);

		double anglen = 0;
		double angle = 0;
		for (int i = 0; i <h1.size() ; i++) {
			angle = 0 + angle + anglen;

			anglen = ((double)(values[h1.size() - 1 - i]) / sum) * 360;
			System.out.println("strt " + angle + " enda " + anglen);
			int x, y, z;
			x = rnd2.nextInt(256);
			y = rnd2.nextInt(256);
			z = rnd2.nextInt(256);
			g.setFill(ca2.MixColor(x, y, z));
			g.fillArc(300, 100, 400, 400, angle, anglen, ArcType.ROUND);
			String s = String.valueOf((values[h1.size() - 1 - i]) );
			String sm = s + "  " + keys[h1.size() - 1 - i];
			g.fillRect(10, 30 * i + 90, 30, 40);
			g.strokeText(sm, 50, 30 * i + 100);

		}
		/*
		 * double anglen = 0; double angle =0; for(int i = 0; i< N; i++) { angle =
		 * 0+angle+anglen;
		 * 
		 * anglen = (values[25-i]/sum)*360 ; System.out.println("strt "+angle +
		 * " enda "+ anglen ); int x,y,z; x=rnd2.nextInt(256); y = rnd2.nextInt(256); z
		 * = rnd2.nextInt(256); g.setFill(ca2.MixColor(x,y , z )); g.fillArc(300, 100,
		 * 400, 400, angle, anglen, ArcType.ROUND); String s =
		 * String.valueOf(values[25-i]/sum); String sm = s+"  "+ keys[25-i];
		 * g.fillRect(10, 30*i+90, 30, 40); g.strokeText(sm, 50, 30*i+100);
		 */

	}
}
