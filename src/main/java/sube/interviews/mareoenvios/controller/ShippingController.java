package sube.interviews.mareoenvios.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sube.interviews.mareoenvios.entity.Shipping;
import sube.interviews.mareoenvios.service.shipping.ShippingService;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
	
	@Autowired
	private ShippingService shippingService;
	
	@GetMapping("/info/{shippingid}")
	public ResponseEntity<?> getShippingById(@PathVariable Integer shippingid) {
		Optional<Shipping> oShipping = shippingService.findById(shippingid);
		if(!oShipping.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oShipping);
	}
	
	@PutMapping("/transition/sendToMail/{shippingid}")
	public ResponseEntity<?> updateStateTosendToMail(@PathVariable Integer shippingid) {
		Optional<Shipping> oShipping = shippingService.findById(shippingid);
		if(!oShipping.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		try {
				Shipping shipping = oShipping.get();
				return ResponseEntity.ok(shippingService.updateStateTosendToMail(shipping));
			}
			catch(Exception e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
	}
	
	@PutMapping("/transition/cancelled/{shippingid}")
	public ResponseEntity<?> updateStateToCancelled(@PathVariable Integer shippingid) {
		Optional<Shipping> oShipping = shippingService.findById(shippingid);
		if(!oShipping.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			Shipping shipping = oShipping.get();
			return ResponseEntity.ok(shippingService.updateStateToCancelled(shipping));
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/transition/inTravel/{shippingid}")
	public ResponseEntity<?> updateStateToInTravel(@PathVariable Integer shippingid) {
		Optional<Shipping> oShipping = shippingService.findById(shippingid);
		if(!oShipping.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			Shipping shipping = oShipping.get();
			return ResponseEntity.ok(shippingService.updateStateToInTravel(shipping));
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/transition/delivered/{shippingid}")
	public ResponseEntity<?> updateStateToDelivered(@PathVariable Integer shippingid) {
		Optional<Shipping> oShipping = shippingService.findById(shippingid);
		if(!oShipping.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			Shipping shipping = oShipping.get();
			return ResponseEntity.ok(shippingService.updateStateToDelivered(shipping));
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
