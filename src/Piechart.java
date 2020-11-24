
import java.util.regex.Pattern;

import com.db.connecToDb;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;



import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
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



public class Piechart 
{
	Random rnd2 = new Random();
	 MyColor ca2 = MyColor.RED ;
	 public static Character[] keys = null;
   public  static Integer[] values = null;
	
	public static Map<Character, Integer> h1 = new HashMap<Character,Integer>();
	
	
	public  static double sum = 0;

	
	public  HashMap<Character,Integer>  getter(String[] args) throws SQLException {
		HashMap<Character, Integer> gotmap = new HashMap<Character,Integer>();
		connecToDb try1 = new connecToDb();
		gotmap = try1.createconnect();
		return gotmap;
		
		}

	
	public Piechart()
	{
		
		
		h1.put('a',45);
		h1.put('b',46);
			h1.put('c',37);
				h1.put('d',36);
					h1.put('e',36);
						h1.put('f',23);
							h1.put('g',29);
								h1.put('h',39);
									h1.put('i',27);
										h1.put('j',26);
											h1.put('k',25);
												h1.put('l',28);
	    h1.put('m',12);
		h1.put('n',23);
		h1.put('o',34);
		h1.put('p',28);
		h1.put('p',29);
		h1.put('q',29);
			h1.put('r',29);
				h1.put('s',29);
					h1.put('t',19);
						h1.put('u',26);
							h1.put('v',89);
								h1.put('w',19);
									h1.put('x',18);
										h1.put('y',26);
											h1.put('z',48);
		
		
		
		  keys = new Character[h1.size()];
		  values = new Integer[h1.size()];
		int index = 0;
		
		for (Entry<Character, Integer> mapEntry : h1.entrySet()) 
		{
		    keys[index] = mapEntry.getKey();
		    values[index] = mapEntry.getValue();
		    index++;
		}
		for(int i = 0; i<= 25; i++)
		{
			sum = values[i]+ sum;
		}
		for(int i = 0; i<= 25; i++)
		{
			System.out.println("keys:  "+ keys[25-i] +"  values:  "+ values[25-i]);
		}
		System.out.println("And sum is  "+sum);
		
	}
	
	
	 /********************************************/
/*	public static void main(String[] args) throws FileNotFoundException
	{
		Piechat();
	}*/
	
	
	
	
	 /********************************************/
	    public void draw(GraphicsContext g, int frequency)
	    {
	    	double angle = (frequency/sum)*360;
	    	g.setFill(ca2.MixColor(rnd2.nextInt(256), rnd2.nextInt(256), rnd2.nextInt(256) ));
	    	g.fillArc(200, 200, 400, 400, 0, angle,  ArcType.ROUND);
	    }
	    
	    
	    /********************************************/
	   public void drawpiechart(GraphicsContext g, int N)
	   {
		   g.strokeOval(300, 100, 400, 400);
		   double anglen = 0;
		   double angle =0;
		   for(int i = 0; i< N; i++)
			{
			    angle = 0+angle+anglen;
			    
			    anglen = (values[25-i]/sum)*360 ;
			    System.out.println("strt "+angle + " enda "+ anglen );
			    int x,y,z;
			    x=rnd2.nextInt(256);
			    y = rnd2.nextInt(256);
			    z = rnd2.nextInt(256);
		    	g.setFill(ca2.MixColor(x,y , z ));
		    	g.fillArc(300, 100, 400, 400, angle, anglen,  ArcType.ROUND);
		    	String s = String.valueOf(values[25-i]/sum);
		    	String sm = s+"  "+ keys[25-i];
		    	g.fillRect(10, 30*i+90, 30, 40); g.strokeText(sm, 50, 30*i+100); 
		    	
		    	
		    	
		    	 
			}
	   }

}
