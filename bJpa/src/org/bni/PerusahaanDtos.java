package org.bni;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "perusahaanDtos")
public class PerusahaanDtos {
	private List<PerusahaanDto> perusahaanDtos;

	public List<PerusahaanDto> getPerusahaanDtos() {
		return perusahaanDtos;
	}

	public void setPerusahaanDtos(List<PerusahaanDto> perusahaanDtos) {
		this.perusahaanDtos = perusahaanDtos;
	}

}
