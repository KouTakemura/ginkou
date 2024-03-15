package jp.ac.ohara.ginkou.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="okane")
public class Ginkou{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
    @Column
    private long id;
    
//	@Column( nullable=false)
//    private Integer balance;
	
	@Column(nullable=false)
	private Integer nyuu;
	
	@Column(nullable=false)
	private Integer syutu;
	
//	@LastModifiedDate
//	@Temporal(TemporalType.TIMESTAMP)
//	@Column(name = "createdat",nullable = false, updatable = false)
//	private Date createdat;
	
	
	
//	public Integer getBalance() {
//		return balance;
//	}
//	public void setBalance(Integer balance) {
//		this.balance = balance;
//	}
}