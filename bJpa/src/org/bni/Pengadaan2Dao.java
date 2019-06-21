package org.bni;

import java.util.List;

public interface Pengadaan2Dao {
	public void savePerusahaanDto(PerusahaanDto dto);
	public void updatePerusahaanDto(PerusahaanDto dto);
	public void deletePerusahaanDto(PerusahaanDto dto);
	public PerusahaanDto selectPerusahaanDto(String id);
	public List<PerusahaanDto> listPerusahaanDto();
}
