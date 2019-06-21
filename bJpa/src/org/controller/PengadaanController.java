package org.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.bni.Pengadaan2Dao;
import org.bni.PerusahaanDto;
import org.bni.PerusahaanDtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PengadaanController {
	private static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	@Autowired
	private Pengadaan2Dao pengadaan2Dao;

	@RequestMapping(value = "/{perusahaan}", method = RequestMethod.POST)
	public @ResponseBody
	boolean post(@RequestBody PerusahaanDto dto) {
		pengadaan2Dao.savePerusahaanDto(dto);
		return true;
	}

	//rest client : http://localhost:8080/bRestful/prs/2
	@RequestMapping(value = "/prs/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	PerusahaanDtos get(@PathVariable("id") String id) {
		System.out.println("id...." + id);
		pengadaan2Dao.deletePerusahaanDto(new PerusahaanDto(id));
		return list();
	}

	// /prs/1/1000
	@RequestMapping(value = "/prs/{id}/{nama}", method = RequestMethod.GET)
	public @ResponseBody
	PerusahaanDto get(@PathVariable("id") String id,
			@PathVariable("nama") int nama) {
		System.out.println("id...." + id);
		System.out.println("nama...." + nama);
		PerusahaanDto dto = pengadaan2Dao.selectPerusahaanDto(id);
		return dto;
	}
	
	@RequestMapping(value = "/prs", method = RequestMethod.PUT)
	public @ResponseBody
	PerusahaanDtos update(@RequestBody PerusahaanDto perusahaanDto) {
		pengadaan2Dao.updatePerusahaanDto(perusahaanDto);
//		PerusahaanDto dto = pengadaan2Dao.selectPerusahaanDto(perusahaanDto
//				.getId_perusahaan());
		return list();
	}

	// khusus method PUT dan POST
	// Setting di firefox nya Rest Client di Header => Content-Type :
	// application/xml
	// <perusahaanDto>
	// <id_perusahaan>1</id_perusahaan>
	// <nama>Jones</nama>
	// <alamat>5000</alamat>
	// <telepon>Jones</telepon>
	// <email>5000</email>
	// </perusahaanDto>

	// Setting di firefox nya Rest Client di Header => Content-Type :
	// application/json
	// {
	// "id_perusahaan":"1",
	// "nama":"Jones",
	// "alamat":"aa",
	// "telepon":"aa",
	// "email":"aa"
	// }
	
	//rest client : http://localhost:8080/bRestful/prs
	@RequestMapping(value = "/prs", method = RequestMethod.POST)
	public @ResponseBody
	PerusahaanDtos add(@RequestBody PerusahaanDto perusahaanDto) {
		pengadaan2Dao.savePerusahaanDto(perusahaanDto);
//		PerusahaanDto dto = pengadaan2Dao.selectPerusahaanDto(perusahaanDto
//				.getId_perusahaan());
		return list();
	}

	@RequestMapping(value = "/prsAll", method = RequestMethod.POST)
	public @ResponseBody
	PerusahaanDtos all(@RequestBody PerusahaanDto perusahaanDto) {
		pengadaan2Dao.savePerusahaanDto(perusahaanDto);
		return list();
	}

	private PerusahaanDtos list() {
		List<PerusahaanDto> perusahaanDtos = pengadaan2Dao.listPerusahaanDto();
		PerusahaanDtos dtos = new PerusahaanDtos();
		dtos.setPerusahaanDtos(perusahaanDtos);
		return dtos;
	}
}
