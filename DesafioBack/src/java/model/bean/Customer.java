/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import java.math.BigDecimal;

/**
 *
 * @author Leo
 */
public class Customer {
    // Atributos
    private int id_customer;
    private String cpf_cnpj;
    private String nm_customer;
    private boolean is_active;
    private BigDecimal vl_total;
    
    // Construtor padrão
    public Customer() { }   
    
    // Construtor parametrizado
    public Customer(int id_customer, String cpf_cnpj, String nm_customer, boolean is_active, String vl_total) {
        this.setId_customer(id_customer);
        this.setCpf_cnpj(cpf_cnpj);
        this.setNm_customer(nm_customer);
        this.setIs_active(is_active);
        this.setVl_total(vl_total);        
    }
    
    // Getters
    public int getId_customer() {
        return this.id_customer;
    }
    
    public String getCpf_cnpj() {
        return this.cpf_cnpj;
    }
    
    public String getNm_customer() {
        return this.nm_customer;
    }
    
    public boolean getIs_active() {
        return this.is_active;
    }
    
    public BigDecimal getVl_total() {
        return this.vl_total;
    }
    
    // Setters
    void setId_customer(int value) {
        this.id_customer = value;
    }
    
    void setCpf_cnpj(String value) {
        this.cpf_cnpj = value;
    }
    
    void setNm_customer(String value) {
        this.nm_customer = value;
    }
    
    void setIs_active(boolean value) {
        this.is_active = value;
    }
    
    void setVl_total(String value) {
        BigDecimal value_bigde = new BigDecimal(value);
        this.vl_total = value_bigde;
    }
}
