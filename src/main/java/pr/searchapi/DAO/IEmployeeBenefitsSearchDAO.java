package pr.searchapi.DAO;

import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeBenefitsSearchDAO {

	public String searchByPlanNameAndSponsorNameAndSponsorState(String planName, String sponsorName, String sponsorState);

}
