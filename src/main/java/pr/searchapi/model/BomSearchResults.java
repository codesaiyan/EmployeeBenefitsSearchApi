package pr.searchapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "hits")
public class BomSearchResults {

	private List<BomSearchResult> hits;

	private long total;

	public BomSearchResults() {
	}

	public BomSearchResults(List<BomSearchResult> hits, long total) {
		this.hits = hits;
		this.total = total;
	}

	public List<BomSearchResult> getHits() {
		return hits;
	}

	public void setHits(List<BomSearchResult> hits) {
		this.hits = hits;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
