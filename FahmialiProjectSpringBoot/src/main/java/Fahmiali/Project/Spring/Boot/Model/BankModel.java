package Fahmiali.Project.Spring.Boot.Model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="tabungan_tbl")

@EntityListeners(AuditingEntityListener.class)



public class BankModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nik;
	
	private String nama;
	
	
	private Long kredit;
	
	
	private Long debet;
	
	private Long saldo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_Time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	

	public Long getKredit() {
		return kredit;
	}

	public void setKredit(Long kredit) {
		this.kredit = kredit;
	}



	public Long getDebet() {
		return debet;
	}

	public void setDebet(Long debet) {
		this.debet = debet;
	}

	public Date getCreateTime() {
		return create_Time;
	}

	public void setCreateTime(Date createTime) {
		this.create_Time = createTime;
	}

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}
	
}
