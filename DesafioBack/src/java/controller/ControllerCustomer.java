/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Customer;
import model.dao.CustomerDAO;

/**
 *
 * @author Leo
 */
public class ControllerCustomer {  
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private CustomerDAO cusdao = new CustomerDAO();
    
    public void insert(int id_customer, String cpf_cnpj, String nm_customer, boolean is_active, String vl_total) {
        // Instância objeto Customer
        Customer customer = new Customer(id_customer, cpf_cnpj, nm_customer, is_active, vl_total);   
        customers.add(customer);
    }
    
    public String showAvg() {
        return cusdao.showAvg();
    }
    
    public ArrayList<String> showCust() {
        return cusdao.showCust();
    }
    
    // Ordena a inserção dos dados
    public int execute() {
        // retorna o tamanho do array
        return cusdao.create(customers).length;
    }
}
