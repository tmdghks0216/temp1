package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class HavingDAO {
	Connection conn;
	PreparedStatement pstmt;
	
	

	public void having_update_del(HavingVO vo) {
		conn=JDBCUtil.connect();
		final String update2="update having_ set  hcnt=hcnt-?,"
				+ "htotal=htotal-?,hnprice=?,hplpercent=?,"
				+ "hpltotal=hpltotal-?  where  hname like ? and hstock like ?";
		try {
			pstmt=conn.prepareStatement(update2);
			pstmt.setInt(1, vo.getHcnt());
			pstmt.setInt(2, vo.getHtotal());
			pstmt.setInt(3,vo.getHnprice());
			pstmt.setDouble(4, vo.getHplpercent());
			pstmt.setInt(5, vo.getHpltotal());
			pstmt.setString(6, vo.getHname());
			pstmt.setString(7, vo.getHstock());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public void having_update_add(HavingVO vo) {
		conn=JDBCUtil.connect();
		final String update="update having_ set hcnt=hcnt+?, htotal=htotal+?,"
				+ " hnprice=?, hplpercent=?, hpltotal=hpltotal+?"
				+ " where hname like ? and hstock like ?";
		try {
			pstmt=conn.prepareStatement(update);
			pstmt.setInt(1, vo.getHcnt());
			pstmt.setInt(2, vo.getHtotal());
			pstmt.setInt(3,vo.getHnprice());
			pstmt.setDouble(4, vo.getHplpercent());
			pstmt.setInt(5, vo.getHpltotal());
			pstmt.setString(6, vo.getHname());
			pstmt.setString(7, vo.getHstock());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public void having_insert(HavingVO vo) {
		conn=JDBCUtil.connect();
		final String having_insert="insert into having_ values(?,?,?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(having_insert);
			pstmt.setInt(1, vo.getPk());
			pstmt.setString(2, vo.getHname());
			pstmt.setInt(3, vo.getHcnt());
			pstmt.setString(4, vo.getHstock());
			pstmt.setInt(5, vo.getHtotal());
			pstmt.setInt(6,vo.getHnprice());
			pstmt.setDouble(7, vo.getHplpercent());
			pstmt.setInt(8, vo.getHpltotal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}
	
	public void having_delete(HavingVO vo) {
		conn=JDBCUtil.connect();
		final String stock_delete="delete from having_ where hname=? and hstock=?";
		try {
			pstmt=conn.prepareStatement(stock_delete);
			pstmt.setString(1, vo.getHname());
			pstmt.setString(2, vo.getHstock());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
	}

	public HavingVO having_one_select(HavingVO vo) {
		conn=JDBCUtil.connect();
		final String stock_select="select * from having_ where hname=? and hstock=?";
		HavingVO data=null;
		try {
			pstmt=conn.prepareStatement(stock_select);
			pstmt.setString(1, vo.getHname());
			pstmt.setString(2, vo.getHstock());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new HavingVO();
				data.setPk(rs.getInt("hpk"));
				data.setHname(rs.getString("hname"));
				data.setHcnt(rs.getInt("hcnt"));
				data.setHstock(rs.getString("hstock"));
				data.setHnprice(rs.getInt("hnprice"));
				data.setHplpercent(rs.getDouble("hplpercent"));
				data.setHpltotal(rs.getInt("hpltotal"));
				data.setHtotal(rs.getInt("htotal"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return data;
	}
	
	public ArrayList<HavingVO> having_select_all(MemVO vo) {
		conn=JDBCUtil.connect();
		final String stock_select_all="select * from having_ where hname = ?";
		ArrayList<HavingVO> datas=new ArrayList<HavingVO>();
		try {
			pstmt=conn.prepareStatement(stock_select_all);
			pstmt.setString(1, vo.getMname());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) { 
				HavingVO data=new HavingVO();
				data.setPk(rs.getInt("hpk"));
				data.setHname(rs.getString("hname"));
				data.setHcnt(rs.getInt("hcnt"));
				data.setHstock(rs.getString("hstock"));
				data.setHnprice(rs.getInt("hnprice"));
				data.setHplpercent(rs.getDouble("hplpercent"));
				data.setHpltotal(rs.getInt("hpltotal"));
				data.setHtotal(rs.getInt("htotal"));
				datas.add(data);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return datas;
	}
	
}



