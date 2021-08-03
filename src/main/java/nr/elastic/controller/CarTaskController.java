package nr.elastic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import nr.elastic.document.CarTask;
import nr.elastic.service.CarTaskService;

@RestController
@RequestMapping("api/carTask")
public class CarTaskController {
    private final CarTaskService service;

    @Autowired
    public CarTaskController(CarTaskService service) {
        this.service = service;
    }

    @PostMapping
    public void save(@RequestBody final CarTask carTask) {
        service.save(carTask);
    }

    @GetMapping("/{id}")
    public CarTask findById(@PathVariable String id) {
        return service.findById(id);
    }
}
