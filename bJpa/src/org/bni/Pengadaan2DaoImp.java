package org.bni;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Pengadaan2DaoImp implements Pengadaan2Dao {
	@PersistenceContext
	private EntityManager em;

	// JPA buang jar di spring 3.2 : jpa-annotations-source.jar
	public EntityManager getSessionFactory() {
		return em;
	}

	public void setSessionFactory(EntityManager em) {
		this.em = em;
	}

	public void savePerusahaanDto(PerusahaanDto dto) {
		try {
			em.persist(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePerusahaanDto(PerusahaanDto dto) {
		try {
			em.merge(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePerusahaanDto(PerusahaanDto dto) {
		try {
			PerusahaanDto dto2= em.find(PerusahaanDto.class, dto.getId_perusahaan());
			em.remove(dto2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PerusahaanDto selectPerusahaanDto(String id) {
		try {
			return (PerusahaanDto) em.find(PerusahaanDto.class, id);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PerusahaanDto> listPerusahaanDto() {
		try {
//			return (List<PerusahaanDto>) em.createQuery("from PerusahaanDto")
//					.getResultList();
			Query query = em.createQuery("from PerusahaanDto"); 
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
