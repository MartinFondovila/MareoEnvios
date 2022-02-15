package sube.interviews.mareoenvios.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ReportRepositoryImpl implements ReportRepository{

	@PersistenceContext
	EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> topSended() {
		
		return this.manager.createNativeQuery("SELECT description, SUM(product_count) as total_count \r\n"
				+ "FROM Product\r\n"
				+ "INNER JOIN Shipping_item\r\n"
				+ "ON Product.id=Shipping_item.product_id\r\n"
				+ "GROUP BY description\r\n"
				+ "ORDER BY total_count DESC\r\n"
				+ "LIMIT 3;").getResultList();
	}

}
