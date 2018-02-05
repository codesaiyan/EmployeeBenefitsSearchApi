package pr.searchapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pr.searchapi.DAO.IEmployeeBenefitsSearchDAO;
import pr.searchapi.model.BomAmazonEsResponse;
import pr.searchapi.model.BomSearchResult;
import pr.searchapi.utils.AmazonEsRestInvocator;

@Service
public class EmployeeBenefitsServiceImpl implements IEmployeeBenefitsService {

	@Autowired
	private IEmployeeBenefitsSearchDAO employeeBenefitSearchDAO;

	@Autowired
	AmazonEsRestInvocator amazonEsRestInvocator;

	@Override
	public List<BomSearchResult> searchByPlanNameAndSponsorNameAndSponsorState(String planName, String sponsorName,
			String sponsorState) {
		String query = employeeBenefitSearchDAO.searchByPlanNameAndSponsorNameAndSponsorState(planName, sponsorName,
				sponsorState);
		BomAmazonEsResponse amzEsResponse = amazonEsRestInvocator.invokeAmazonEsEndPoint(query);
		return amzEsResponse.getHits().getHits();
	}

}
