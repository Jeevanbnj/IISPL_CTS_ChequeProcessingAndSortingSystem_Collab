package com.iispl.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.iispl.connectionpool.ConnectionPool;
import com.iispl.enums.ChequePriority;
import com.iispl.enums.ChequeStatus;
import com.iispl.model.Cheque;

public class ChequeDaoImpl implements ChequeDao {

	@Override
	public void addCheque(Cheque cheque) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cheque> getAllCheques() {
		// TODO Auto-generated method stub
		List<Cheque> chequeList=new ArrayList<>();
		Connection connection = null;
		PreparedStatement prepstmt=null;
		String sql= " SELECT * from cheque ";
		try {
			DataSource datasource=ConnectionPool.getDataSource();
			connection= datasource.getConnection();
			prepstmt=connection.prepareStatement(sql);
			ResultSet resultSet=prepstmt.executeQuery();
			while(resultSet.next()) {
				Cheque cheque = new Cheque(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),
						resultSet.getBigDecimal(5),resultSet.getDate(6).toLocalDate(),resultSet.getDate(7).toLocalDate(),ChequePriority.valueOf(resultSet.getString(8)),
						ChequeStatus.valueOf(resultSet.getString(9)));
				chequeList.add(cheque);			
			}
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return chequeList;
	}

	@Override
	public List<Cheque> getHighValueCheques() {
		Connection connection = null;
		String sql = "SELECT * FROM cheque WHERE chequeAmount >= ?";
		List<Cheque> cheques = new ArrayList<Cheque>();

		try {

			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			PreparedStatement prepstmt = connection.prepareStatement(sql);
			prepstmt.setBigDecimal(1,new BigDecimal("200000"));
			ResultSet resultSet = prepstmt.executeQuery();

			while(resultSet.next()) {
				cheques.add(new Cheque(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getBigDecimal(5),resultSet.getDate(6).toLocalDate(),resultSet.getDate(7).toLocalDate(),ChequePriority.valueOf(resultSet.getString(8)),ChequeStatus.valueOf(resultSet.getString(9))));
			}		
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cheques;
	}

	@Override
	public List<Cheque> getPendingCheques() {
		Connection connection = null;
		String sql = "SELECT * FROM cheque WHERE status = ?::chequestatus";
		List<Cheque> cheques = new ArrayList<Cheque>();

		try {

			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			PreparedStatement prepstmt = connection.prepareStatement(sql);
			prepstmt.setString(1, ChequeStatus.PENDING.name());
			ResultSet resultSet = prepstmt.executeQuery();

			while(resultSet.next()) {
				cheques.add(new Cheque(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getBigDecimal(5),resultSet.getDate(6).toLocalDate(),resultSet.getDate(7).toLocalDate(),ChequePriority.valueOf(resultSet.getString(8)),ChequeStatus.valueOf(resultSet.getString(9))));
			}		
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cheques;
	}

	@Override
	public void updateChequeStatus(String chequeNumber, ChequeStatus status) {
		Connection connection = null;
		String sql = "update cheque set status = ?::chequestatus where chequeNumber = ?";

		try {

			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			PreparedStatement prepstmt = connection.prepareStatement(sql);
			prepstmt.setString(1, status.name());
			prepstmt.setString(2, chequeNumber);
			prepstmt.executeUpdate();	
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
