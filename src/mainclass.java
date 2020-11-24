import java.sql.SQLException;
import java.util.HashMap;

import com.db.connecToDb;

public class mainclass {

	public static void main(String[] args) throws SQLException {
		connecToDb try1 = new connecToDb();
		HashMap<Character, Integer> bash = try1.createconnect();
		for (char key : bash.keySet()) {
			System.out.println(key + ": " + bash.get(key));
		}
	

	}// TODO Auto-generated method stub*/

}
