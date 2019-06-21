package org.bni;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.apache.bcel.generic.NEW;
import org.hibernate.envers.RevisionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:WebContent/WEB-INF/applicationContext.xml" })
public class BniTest {
	@Autowired
	private Pengadaan2Dao pengadaan2Dao;

	@Test
	public void main() {
		pengadaan2Dao.deletePerusahaanDto(new PerusahaanDto("4"));
//		System.out.println(p.size());
	}

}
