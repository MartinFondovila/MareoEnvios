package sube.interviews.mareoenvios.service.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sube.interviews.mareoenvios.reportModel.Report;
import sube.interviews.mareoenvios.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportRepository reportRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Report> topSended() {
		List<Object[]> objectList = reportRepository.topSended();
		List<Report> reportList = new ArrayList<>();
		objectList.forEach(o ->{
			Report report = new Report();
			report.setDescription((String) o[0]);
			report.setCount(((BigDecimal) o[1]).intValue());
			reportList.add(report);
		});
		
		return reportList;
	}
}
