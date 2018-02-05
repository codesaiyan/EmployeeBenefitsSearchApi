package pr.searchapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pr.searchapi.model.BomSearchResult;

@Service
public interface IEmployeeBenefitsService {
	public List<BomSearchResult> searchByPlanNameAndSponsorNameAndSponsorState(String planName, String sponsorName,
			String sponsorState);

}
