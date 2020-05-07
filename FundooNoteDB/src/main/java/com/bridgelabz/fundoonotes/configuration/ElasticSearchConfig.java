package com.bridgelabz.fundoonotes.configuration;

import org.springframework.context.annotation.Bean;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
/**
 * providing elastic search config
 * @author chaithra B N
 *
 */
public class ElasticSearchConfig {
	@Bean(destroyMethod = "close")
	public RestHighLevelClient client() {
		RestHighLevelClient restclient = new RestHighLevelClient(
				RestClient.builder(new HttpHost("localhost", 9200, "http")));
		return restclient;
	}
}

