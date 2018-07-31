/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Customer;

/**
 *
 * @author Leo
 */
public class CustomerDAO {
    private Connection con = null;
    private PreparedStatement stmt = null;
    
    public int[] create(ArrayList<Customer> customers) { 
        Connection con = ConnectionFactory.getConnection();
        int[] success = null;
        try {
            stmt = con.prepareStatement("INSERT IGNORE INTO tb_customer_account(id_customer,cpf_cnpj,"
                + "nm_customer,is_active,vl_total) VALUES (?,?,?,?,?)");
            for(Customer customer : customers) {
                stmt.setInt(1,customer.getId_customer());
                stmt.setString(2,customer.getCpf_cnpj());
                stmt.setString(3,customer.getNm_customer());
                stmt.setBoolean(4,customer.getIs_active());
                stmt.setBigDecimal(5,customer.getVl_total());
                stmt.addBatch();
            }
            success = stmt.executeBatch();
            stmt.clearParameters();
            ConnectionFactory.closeConnection(con,stmt);
            System.out.println("Inserido com sucesso !");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir: "+ex);
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    public String showAvg() {
        Connection con = ConnectionFactory.getConnection();
        String result = "0";
        try {
            stmt = con.prepareStatement("SELECT AVG(vl_total) AS media FROM tb_customer_account"
                    + " WHERE vl_total > 560 AND id_customer between 1500 AND 2700");  
            ResultSet rs = stmt.executeQuery();
            rs.next();
            result = rs.getString("media");
            ConnectionFactory.closeConnection(con,stmt,rs);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<String> showCust() {
        Connection con = ConnectionFactory.getConnection();
        ArrayList<String> result = new ArrayList<String>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tb_customer_account"
                    + " WHERE vl_total > 560 AND id_customer between 1500 AND 2700 ORDER BY vl_total");  
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                result.add(rs.getString("id_customer"));
                result.add(rs.getString("cpf_cnpj"));
                result.add(rs.getString("nm_customer"));
                result.add(rs.getString("is_active"));
                result.add(rs.getString("vl_total"));
            }
            ConnectionFactory.closeConnection(con,stmt,rs);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
