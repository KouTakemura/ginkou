package jp.ac.ohara.ginkou.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    
    @Column(length=128, nullable=false)
    private String email;
    
    @Column(length=128, nullable=false)
    private String pass;
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmeil(String email) {
    	this.email = email;
    }
    
    public String getPass() {
    	return pass;
    }
    
    public void setPass(String pass) {
    	this.pass = pass;
    }

	public int getNyuu() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
    
}