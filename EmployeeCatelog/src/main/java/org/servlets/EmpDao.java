package org.servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","Yash@1th");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public static int save(Emp e) {
		int status=0;
		try {
			Connection conn = EmpDao.connect();
			PreparedStatement ps = conn.prepareStatement(
					"insert into user905(name,password,email,country) values (?,?,?,?)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			status = ps.executeUpdate();
			conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int update(Emp e) {
		int status =0;
		try {
			Connection conn = EmpDao.connect();
			PreparedStatement ps = conn.prepareStatement(
					"update user905 set name=?,password=?,email=?,country=? where id=?");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getCountry());
			ps.setInt(5, e.getId());
			status = ps.executeUpdate();
			conn.close();

		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}
	public static int delete(int id){
        int status=0;
        try{
            Connection conn=EmpDao.connect();
            PreparedStatement ps=conn.prepareStatement("delete from user905 where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();

            conn.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }
	public static Emp getEmployeeByID(int id) {
		Emp e = new Emp();
		try {
			Connection conn = EmpDao.connect();
			PreparedStatement ps = conn.prepareStatement("select * from user905 where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt(1));
			     e.setName(rs.getString(2));
	              e.setPassword(rs.getString(3));
	             e.setEmail(rs.getString(4));
	             e.setCountry(rs.getString(5));
	        }
	            conn.close();
	       }catch(Exception ex){ex.printStackTrace();}

	        return e;

		}
	 public static List<Emp> getAllEmployees(){
	        List<Emp> list=new ArrayList<>();

	        try{
	            Connection conn=EmpDao.connect();
	            PreparedStatement ps=conn.prepareStatement("select * from user905");
	            ResultSet rs=ps.executeQuery();
	            while(rs.next()){
	                Emp e=new Emp();
	                e.setId(rs.getInt(1));
	                e.setName(rs.getString(2));
	                e.setPassword(rs.getString(3));
	                e.setEmail(rs.getString(4));
	                e.setCountry(rs.getString(5));
	                list.add(e);
	            }
	            conn.close();
	        }catch(Exception e){e.printStackTrace();}

	        return list;
	    }
}


