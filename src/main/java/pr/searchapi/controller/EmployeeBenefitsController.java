package pr.searchapi.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pr.searchapi.model.BomSearchResult;
import pr.searchapi.model.BomSearchResults;
import pr.searchapi.service.IEmployeeBenefitsService;

@RestController
public class EmployeeBenefitsController {

	@Autowired
	private IEmployeeBenefitsService employeeBenefitsService;

	@GetMapping("/employeebenefitplan")
	public BomSearchResults getEmployeeBenefits(@RequestParam(name = "planName", required = false) String planName,
			@RequestParam(name = "sponsorName", required = false) String sponsorName,
			@RequestParam(name = "sponsorState", required = false) String sponsorState) {

		if (StringUtils.isBlank(planName) && StringUtils.isBlank(sponsorName) && StringUtils.isBlank(sponsorState)) {
			throw new InvalidRequestException(
					"Please provide atleast one search parameter among planName, sponsorName, sponsorState");
		}

		List<BomSearchResult> results = employeeBenefitsService.searchByPlanNameAndSponsorNameAndSponsorState(planName,
				sponsorName, sponsorState);
		return new BomSearchResults(results, results.size());
	}

}
