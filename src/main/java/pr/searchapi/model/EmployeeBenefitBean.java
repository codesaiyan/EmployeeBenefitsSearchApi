package pr.searchapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeBenefitBean {

	@JsonProperty(value = "ACK_ID")
	private String ackId;

	@JsonProperty(value = "PLAN_NAME")
	private String planName;

	@JsonProperty(value = "SPONSOR_DFE_NAME")
	private String sponsorName;

	@JsonProperty(value = "SPONS_DFE_MAIL_US_STATE")
	private String sponsorState;

	public EmployeeBenefitBean() {
	}

	public EmployeeBenefitBean(String ackId, String planName, String sponsorName, String sponsorState) {
		this.ackId = ackId;
		this.planName = planName;
		this.sponsorName = sponsorName;
		this.sponsorState = sponsorState;
	}

	public String getAckId() {
		return ackId;
	}

	public void setAckId(String ackId) {
		this.ackId = ackId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getSponsorState() {
		return sponsorState;
	}

	public void setSponsorState(String sponsorState) {
		this.sponsorState = sponsorState;
	}

}
