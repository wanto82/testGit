package org.bni;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "pegawaiDto")
@Table(name = "bni_perusahaan_jpa_pegawai")
public class PegawaiDto implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String nama;

	// @ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "id_perusahaan")
	private PerusahaanDto perusahaanDto;

	public PegawaiDto() {
		super();
	}

	public PegawaiDto(String id) {
		super();
		this.id = id;
	}

	public PegawaiDto(String id, String nama, PerusahaanDto perusahaanDto) {
		super();
		this.id = id;
		this.nama = nama;
		this.perusahaanDto = perusahaanDto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public PerusahaanDto getPerusahaanDto() {
		return perusahaanDto;
	}

	public void setPerusahaanDto(PerusahaanDto perusahaanDto) {
		this.perusahaanDto = perusahaanDto;
	}

}
