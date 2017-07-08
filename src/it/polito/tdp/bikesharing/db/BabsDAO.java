package it.polito.tdp.bikesharing.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.bikesharing.model.Station;
import it.polito.tdp.bikesharing.model.Trip;

public class BabsDAO {
	
	public List<Trip> listTrip(){
		
		final String sql = "SELECT * FROM trip";

		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			List<Trip> list = new ArrayList<Trip>();
			
			/*while(rs.next()){
				
				Trip t = new Trip(rs.getInt("id"), rs.getTimestamp("StartDate").toLocalDateTime());
				list.add(t);
				
			}*/
			
			rs.close();
			conn.close();
			
			return list;
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException("Database error.\n");
			
		}
		
	}

	public List<Station> getAllStations() {

		final String sql = "SELECT * FROM station";
		System.out.println("BOOO");
		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			List<Station> list = new ArrayList<Station>();
			
			while(rs.next()){
				
				Station s = new Station(rs.getInt("station_id"), rs.getString("name"), rs.getDouble("lat"), rs.getDouble("long"), rs.getInt("dockcount"), rs.getString("landmark"), rs.getDate("installation").toLocalDate());
				list.add(s);
				
			}
			
			rs.close();
			conn.close();
			
			return list;
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException("Database error.\n");
			
		}
		
	}

	public int getPickNumber(Station stazione, LocalDate date) {

		int result;
		
		final String sql = "SELECT COUNT(*) AS counter FROM trip WHERE DATE(StartDate)=? AND StartTerminal=?";

		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setDate(1, Date.valueOf(date));
			st.setInt(2, stazione.getId());
			
			ResultSet rs = st.executeQuery();
			rs.next();
			result = rs.getInt("counter");
			
			rs.close();
			conn.close();
						
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException("Database error.\n");
			
		}
		
		return result;
		
	}
	
	public int getDropNumber(Station stazione, LocalDate date) {

		int result;
		
		final String sql = "SELECT COUNT(*) AS counter FROM trip WHERE DATE(EndDate)=? AND EndTerminal=?";

		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setDate(1, Date.valueOf(date));
			st.setInt(2, stazione.getId());
			
			ResultSet rs = st.executeQuery();
			rs.next();
			result = rs.getInt("counter");
			
			rs.close();
			conn.close();
						
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw new RuntimeException("Database error.\n");
			
		}
		
		return result;
		
	}

}
