package pr.searchapi.utils;

import java.util.Collections;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import pr.searchapi.model.BomAmazonEsResponse;

@Component
public class AmazonEsRestInvocator {

	@Autowired
	RestTemplate restTemplate;

	@Value("${domain.endpoint}")
	private String DOMAIN_ENDPOINT;

	@Value("${domain.index}")
	private String DOMAIN_INDEX;

	private static final String SEARCH = "_search";

	private String fullyFormedUrl;

	@PostConstruct
	public void constructAmazonEsUrl() {
		if (StringUtils.isBlank(fullyFormedUrl)) {
			StringBuilder url = new StringBuilder();
			url.append(DOMAIN_ENDPOINT).append("/").append(DOMAIN_INDEX).append("/").append(SEARCH);
			fullyFormedUrl = url.toString();
		}
	}

	public BomAmazonEsResponse invokeAmazonEsEndPoint(String query) {
		HttpHeaders headers = getHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(query, headers);
		return restTemplate.exchange(fullyFormedUrl, HttpMethod.POST, entity, BomAmazonEsResponse.class).getBody();
	}

	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}
