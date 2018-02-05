package pr.searchapi.DAO;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeBenefitsSearchDAOImpl implements IEmployeeBenefitsSearchDAO {

	@Value("${startIndex}")
	private int START_INDEX;

	@Value("${maxResultSetSize}")
	private int MAX_RESULT_SET_SIZE;

	private static final String PLAN_NAME = "PLAN_NAME";
	private static final String SPONSOR_DFE_NAME = "SPONSOR_DFE_NAME";
	private static final String SPONS_DFE_MAIL_US_STATE = "SPONS_DFE_MAIL_US_STATE";

	@Override
	public String searchByPlanNameAndSponsorNameAndSponsorState(String planName, String sponsorName,
			String sponsorState) {

		BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
		if (StringUtils.isNotBlank(planName)) {
			boolQueryBuilder.must(new MatchQueryBuilder(PLAN_NAME, planName));
		}
		if (StringUtils.isNotBlank(sponsorName)) {
			boolQueryBuilder.must(new MatchQueryBuilder(SPONSOR_DFE_NAME, sponsorName));
		}
		if (StringUtils.isNotBlank(sponsorState)) {
			boolQueryBuilder.must(new MatchQueryBuilder(SPONS_DFE_MAIL_US_STATE, sponsorState));
		}

		return new SearchSourceBuilder().query(boolQueryBuilder).from(START_INDEX).size(MAX_RESULT_SET_SIZE).toString();
	}

}
