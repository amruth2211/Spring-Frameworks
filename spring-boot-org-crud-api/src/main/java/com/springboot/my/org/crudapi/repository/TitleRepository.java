package com.springboot.my.org.crudapi.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.sql.Date;
import com.springboot.my.org.crudapi.dao.TitleDAO;
import com.springboot.my.org.crudapi.models.Title;
import com.springboot.my.org.crudapi.util.DatabaseConnection;


@Repository
public class TitleRepository implements TitleDAO{
	 	private final Connection conn; 
	    

	    public TitleRepository() throws SQLException, ClassNotFoundException {
	        this.conn = DatabaseConnection.getConnection();
	    }
	    
	    @Override
	    public List<Title> getWorkerTitle(int id) throws SQLException{
	    	
	   	 List<Title> titleList = new ArrayList<>();
		 PreparedStatement ps = conn.prepareStatement("SELECT * FROM title WHERE title.WORKER_REF_ID = ?");
		 ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();
         while(rs.next()) 
         {
        	 titleList.add(new Title(rs.getInt(1), rs.getString(2), rs.getDate(3)));
         }
         
         return titleList;
	    }
	    
	    @Override
	    public List<Title> getAllWorkerTitleInDept(String dept) throws SQLException{
	    	List<Title> titleList = new ArrayList<>();
	    	
	    	PreparedStatement ps=conn.prepareStatement("SELECT * FROM title INNER JOIN worker on worker.WORKER_ID = title.WORKER_REF_ID WHERE worker.DEPARTMENT LIKE ? ");
	    	ps.setString(1, dept);
		    ResultSet rs = ps.executeQuery();
		     while(rs.next()) 
		     {
		    	 titleList.add(new Title(rs.getInt(1), rs.getString(2), rs.getDate(3)));
		     }
		     
		     return titleList;
	    }
	    
	    @Override
	    public boolean createTitle(int id, String title) throws SQLException {
	    	Date date = new Date(System.currentTimeMillis());
	    	String update = "insert into title values (?,?,?)";
	    	PreparedStatement prep = conn.prepareStatement(update);
	        prep.setInt(1, id);
	        prep.setString(2, title);
	        prep.setDate(3, date);
	        
	        int rowCount = prep.executeUpdate();
	        return rowCount==1;
	    }
	    
	    @Override
	    public boolean deleteTitle(int id) throws SQLException{
	    	 PreparedStatement ps = conn.prepareStatement("DELETE FROM title WHERE WORKER_REF_ID = ?");
		        ps.setInt(1, id);
		        int rowDeleted = ps.executeUpdate();
		     	return rowDeleted==1;
	    }
	    
	    
	    
}
  