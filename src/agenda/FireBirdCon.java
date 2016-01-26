package agenda;

import java.sql.Connection;
import java.sql.DriverManager;

public class FireBirdCon {
	public Connection getConnection(){
		try{
			return DriverManager.getConnection("jdbc:firebirdsql://localhost:3050/c:/database/)
		}
	}
}
