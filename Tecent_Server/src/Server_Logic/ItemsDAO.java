package Server_Logic;
import Common.Items;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemsDAO {

	public Items getItems(String name){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = DBHelper.getConnection();
			String sql = "SELECT * FROM user where name = '"+name+"';";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			Items item =  new Items();
			while(rs.next()){
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setRealname(rs.getString("realname"));
				item.setSex(rs.getString("sex"));
				item.setAge(rs.getInt("age"));
			}
			return item;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			if(rs!=null){
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt!=null){
					try {
						stmt.close();
						stmt = null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
}
