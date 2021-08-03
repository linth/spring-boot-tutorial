package nr.elastic.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "nr.elastic.repository")
@ComponentScan(basePackages = "nr.elastic")
public class Config extends AbstractElasticsearchConfiguration {

    public String elasticsearchUrl = "localhost:9200";

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration config = ClientConfiguration.builder().connectedTo(elasticsearchUrl).build();

        return RestClients.create(config).rest();
    }
}
