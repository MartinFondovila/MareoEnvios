package sube.interviews.mareoenvios.service.shipping;

import java.util.Optional;

import sube.interviews.mareoenvios.entity.Shipping;

public interface ShippingService {

	public Optional<Shipping> findById(Integer id);
	
	public Shipping save(Shipping shipping);
	
	public Shipping updateStateTosendToMail(Shipping shipping) throws Exception;
	
	public Shipping updateStateToCancelled(Shipping shipping) throws Exception;
	
	public Shipping updateStateToInTravel(Shipping shipping) throws Exception;
	
	public Shipping updateStateToDelivered(Shipping shipping) throws Exception;
	
}
