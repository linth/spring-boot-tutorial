package nr.elastic.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import nr.elastic.document.CarTask;

public interface CarTaskRepository extends ElasticsearchRepository<CarTask, String> {

}
