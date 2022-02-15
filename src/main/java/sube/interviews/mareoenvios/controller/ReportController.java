package sube.interviews.mareoenvios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sube.interviews.mareoenvios.service.report.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	ReportService reportService;
	
	@GetMapping("/topSended")
	public ResponseEntity<?> topSended() {
		return ResponseEntity.ok(reportService.topSended());
	}
}
