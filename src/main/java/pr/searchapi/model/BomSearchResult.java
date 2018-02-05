package pr.searchapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "hits")
public class BomSearchResult {

	@JsonProperty(value = "_source")
	private EmployeeBenefitBean employeeBenefit;

	public BomSearchResult() {
	}

	public BomSearchResult(EmployeeBenefitBean employeeBenefit) {
		this.employeeBenefit = employeeBenefit;
	}

	public EmployeeBenefitBean getEmployeeBenefit() {
		return employeeBenefit;
	}

	public void setEmployeeBenefit(EmployeeBenefitBean employeeBenefit) {
		this.employeeBenefit = employeeBenefit;
	}

}
