package com.laioffer.staybooking.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {
    @Value("${elasticsearch.address}") //read from application.properties
    private String elasticsearchAddress;

    @Value("${elasticsearch.username}") //read from application.properties
    private String elasticsearchUsername;

    @Value("${elasticsearch.password}") //read from application.properties
    private String elasticsearchPassword;

    @Bean
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo(elasticsearchAddress)
                .withBasicAuth(elasticsearchUsername, elasticsearchPassword)
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
