package org.bni;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "perusahaanDto")
@Table(name = "bni_perusahaan_jpa")
public class PerusahaanDto implements Serializable {
	private static final long serialVersionUID = 1L;

	// @GeneratedValue(strategy = GenerationType.SEQUENCE)
	// private Integer id_perusahaan;
	// bisa juga pake @GeneratedValue
	@Id
	private String id_perusahaan;
	private String nama;
	private String alamat;
	private String telepon;
	private String email;

	public PerusahaanDto() {
		super();
	}

	public PerusahaanDto(String id_perusahaan) {
		super();
		this.id_perusahaan = id_perusahaan;
	}

	public PerusahaanDto(String id_perusahaan, String nama) {
		super();
		this.id_perusahaan = id_perusahaan;
		this.nama = nama;
	}

	public PerusahaanDto(String id_perusahaan, String nama, String alamat,
			String telepon, String email) {
		super();
		this.id_perusahaan = id_perusahaan;
		this.nama = nama;
		this.alamat = alamat;
		this.telepon = telepon;
		this.email = email;
	}

	public String getId_perusahaan() {
		return id_perusahaan;
	}

	public void setId_perusahaan(String id_perusahaan) {
		this.id_perusahaan = id_perusahaan;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
