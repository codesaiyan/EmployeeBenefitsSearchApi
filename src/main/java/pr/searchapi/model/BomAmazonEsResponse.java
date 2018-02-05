package pr.searchapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BomAmazonEsResponse {

	private BomSearchResults hits;
	private long took;

	public BomAmazonEsResponse() {
	}

	public BomAmazonEsResponse(BomSearchResults hits, long took) {
		this.hits = hits;
		this.took = took;
	}

	public BomSearchResults getHits() {
		return hits;
	}

	public void setHits(BomSearchResults hits) {
		this.hits = hits;
	}

	public long getTook() {
		return took;
	}

	public void setTook(long took) {
		this.took = took;
	}

}
