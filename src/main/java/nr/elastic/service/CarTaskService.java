package nr.elastic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nr.elastic.document.CarTask;
import nr.elastic.repository.CarTaskRepository;

@Service
public class CarTaskService {
    private final CarTaskRepository repository;

    @Autowired
    public CarTaskService(CarTaskRepository repository) {
        this.repository = repository;
    }

    public void save(final CarTask carTask) {
        repository.save(carTask);
    }

    public CarTask findById(final String id) {
        return repository.findById(id).orElse(null);
    }
}
