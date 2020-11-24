package com.db;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class connecToDb  {

	static String codev = "CSc";
	static HashMap<Character, Integer> hash = new HashMap<>();

	static Connection c = null;

	public connecToDb() {
		String quan = "CSc";
	}

	public static HashMap<Character, Integer> createconnect() throws SQLException {
		hash.put('A', 0);
		hash.put('B', 0);
		hash.put('C', 0);
		hash.put('D', 0);
		hash.put('E', 0);
		hash.put('F', 0);
		hash.put('W', 0);

		try {
			Class.forName("org.sqlite.JDBC");// load driver
			c = DriverManager.getConnection("jdbc:sqlite:info.db");
			System.out.println("connection succesful");

		} catch (Exception e) {
			System.out.println("connection failed");
			System.exit(0);
		}

		System.out.println("********Please select option: 1:Populate tables ********** , *******2: See gpa proportion ********");
		Scanner read = new Scanner(System.in);
		int process = read.nextInt();
		int process2 = 0;
		switch (process) {
		case (1): {
			System.out.println("*************Please select what table u want to populate:  or CTRLZ ************");
			Scanner read2 = new Scanner(System.in);
			process2 = read2.nextInt();
			switch (process2) {
			case(1): {
				System.out.println("*********You selected Student with fields " +" studentID, " + "firstName, lastName, sex enter all inorder ,");
				Scanner in1 = new Scanner(System.in);
				Scanner in2 = new Scanner(System.in);
				Scanner in3 = new Scanner(System.in);
				Scanner in4 = new Scanner(System.in);
				System.out.println("enter studentid");
				String studentd = in1.nextLine();
				System.out.println("enter firstname");
				String usernme = in2.nextLine();
				System.out.println("enter lastname");
				String slastn = in3.nextLine();
				System.out.println("enter sex");
				String sexx = in4.nextLine();	
				String SQLAdd = "INSERT INTO Student(field1, field2, field3, field4) " + "VALUES ('" + studentd + "', '" + usernme+ "', '" + slastn + "', '" + sexx + "')";
						
				Statement stmt = c.createStatement();
				stmt.executeUpdate(SQLAdd);
				System.out.println("record added");
				break;
				
				
			}
			
			case(2): {
				System.out.println("*********You selected courses with fields (courseID, courseTitle, department ) enter all inorder or CtrlZ to exit");
				Scanner in1 = new Scanner(System.in);
				Scanner in2 = new Scanner(System.in);
				Scanner in3 = new Scanner(System.in);
				Scanner in4 = new Scanner(System.in);
				System.out.println("courseID");
				String courseid = in1.nextLine();
				System.out.println("courseTitle");
				String course = in2.nextLine();
				System.out.println("department");
				String department = in3.nextLine();
					
				String SQLAdd = "INSERT INTO Courses(field1, field2, field3) " + "VALUES ('" + courseid + "', '" + course+ "', '" + department+ "')";
						
				Statement stmt = c.createStatement();
				stmt.executeUpdate(SQLAdd);
				System.out.println("record added");
				break;
			
			}
			
			
		
			case(3): {
				System.out.println("you selected Classes with fields (classCode, courseID, studentID, year, semester, GPA)");
				Scanner in1 = new Scanner(System.in);
				Scanner in2 = new Scanner(System.in);
				Scanner in3 = new Scanner(System.in);
				Scanner in4 = new Scanner(System.in);
				System.out.println("enter classCode");
				String studentd = in1.nextLine();
				System.out.println("enter courseID");
				String usernme = in2.nextLine();
				System.out.println("enter studentID");
				String slastn = in3.nextLine();
				System.out.println("enter year");
				String yearn = in3.nextLine();
				System.out.println("enter semester");
				String sems = in3.nextLine();
				System.out.println("enter GPA");
				String gpaa= in4.nextLine();	
				String SQLAdd = "INSERT INTO Classes(classCode, courseID, studentID, year, semester, GPA) " + "VALUES ('" + studentd + "', '" + usernme+ "', '" + slastn + "', '" + yearn + "', '" + sems+ "', '" + gpaa+ "')";
						
				Statement stmt = c.createStatement();
				stmt.executeUpdate(SQLAdd);
				System.out.println("record added");
				break;
				
			}
			

		} 
			}
		case (2): {
			//System.out.println("About to create statement");
			Statement stmt2 = c.createStatement();
			String SQLRead = "SELECT classCode,courseID, year, semester,GPA FROM  Classes";
			System.out.println("");
			ResultSet rs = stmt2.executeQuery(SQLRead);
			// System.out.println("classCode"+"\t"+"courseID");
			//System.out.println("check1");
			System.out.println("CourseId   Year   CourseCode   GPA");
			while (rs.next()) {
				// int id = rs.getInt("id");
				String code = rs.getString("classCode");
				String crseid = rs.getString("courseID");
				String yearstr = rs.getString("year");
				String semesstr = rs.getString("semester");
				String GPAstr = rs.getString("GPA");
	
                  
				if (code.equals(codev) && yearstr.equals("2019") && crseid.equals("211")) {
					// System.out.println("we made it " + GPAstr);
					System.out.println(crseid+"      "+yearstr+"      "+code+"         "+GPAstr);
					if (hash.containsKey(GPAstr.charAt(0))) {

						int value = hash.get(GPAstr.charAt(0));
						hash.put(GPAstr.charAt(0), value + 1);
			    

					}

				}

			}
		//	System.out.println("check1");/// end of while loop

			/*
			 * hash = hash.entrySet() .stream() .sorted(comparingByValue()) .collect(
			 * toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
			 * LinkedHashMap::new));
			 */
			rs.close();
			stmt2.close();
			c.close();
		}

		}
		System.out.println("retured hash");

		return hash;
	
	}/// switch case
	
	

	public static void main(String[] args) throws SQLException {
		connecToDb try1 = new connecToDb();
		HashMap<Character, Integer> bash = try1.createconnect();
		for (char key : bash.keySet()) {
			System.out.println(key + ": " + bash.get(key));
		}
	

	}// TODO Auto-generated method stub*/

}
