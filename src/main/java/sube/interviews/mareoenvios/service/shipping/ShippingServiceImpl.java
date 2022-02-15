package sube.interviews.mareoenvios.service.shipping;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sube.interviews.mareoenvios.entity.Shipping;
import sube.interviews.mareoenvios.repository.ShippingRepository;

@Service
public class ShippingServiceImpl implements ShippingService{
	
	@Autowired
	private ShippingRepository shippingRepository;

	@Override
	@Transactional(readOnly = true)
	public Optional<Shipping> findById(Integer id) {
		return shippingRepository.findById(id);
	}

	@Override
	@Transactional
	public Shipping save(Shipping shipping) {
		return shippingRepository.save(shipping);
	}

	@Override
	@Transactional
	public Shipping updateStateTosendToMail(Shipping shipping) throws Exception {
		String shippingState = shipping.getState();
		
		if(shippingState.equals("Inicial")) {
			shipping.setState("Entregado al correo");
			return shippingRepository.save(shipping);
		}else{
			throw new Exception("El estado del envío no era Inicial, por lo que no se pudo actualizarlo a Entregado al correo");
		}
	}

	@Override
	@Transactional
	public Shipping updateStateToCancelled(Shipping shipping) throws Exception {
		String shippingState = shipping.getState();
		
		if(shippingState.equals("Inicial") || shippingState.equals("Entregado al correo")) {
			shipping.setState("Cancelado");
			return shippingRepository.save(shipping);
		}else{
			throw new Exception("El estado del envío no era Inicial o Entregado al correo,"
					+ " por lo que no se pudo actualizarlo a Cancelado");
		}
	}

	@Override
	@Transactional
	public Shipping updateStateToInTravel(Shipping shipping) throws Exception {
		String shippingState = shipping.getState();
		
		if(shippingState.equals("Entregado al correo")) {
			shipping.setState("En camino");
			return shippingRepository.save(shipping);
		}else{
			throw new Exception("El estado del envío no era Entegado al correo,"
					+ " por lo que no se pudo actualizarlo a En camino");
		}
	}

	@Override
	@Transactional
	public Shipping updateStateToDelivered(Shipping shipping) throws Exception {
		String shippingState = shipping.getState();
		
		if(shippingState.equals("En camino")) {
			shipping.setState("Entregado");
			return shippingRepository.save(shipping);
		}else{
			throw new Exception("El estado del envío no era En camino,"
					+ " por lo que no se pudo actualizarlo a Entregado");
		}
	}
}
