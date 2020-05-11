import java.sql.*;

public class database {

	public static void main(String[] args) {
		
		
		// Program to retrieve data from database 
		try{
			
			// Load driver
			Class.forName("com.mysql.jdbc.Driver"); // install sql connector
			System.out.println("Successful");
			
			// Connecting to DB
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csesem4","root","");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from cse"); // * means all rows
			
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
				System.out.println();
			}
			
			
		}
		catch(Exception ex){
			System.out.println("Can not process");
		}

	}

}