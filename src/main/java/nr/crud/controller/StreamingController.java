package nr.crud.controller;

import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import nr.crud.entity.Streaming;
import nr.crud.service.StreamingService;

@RestController
@RequestMapping("api/stream")
public class StreamingController {
    private final StreamingService service;

    @Autowired
    public StreamingController(StreamingService service) {
        this.service = service;
    }

    @GetMapping()
    @Operation(summary = "目前串流資訊")
    @Parameter(description = "目前串流資訊")
    public Streaming getStream() {
        return service.getStream();
    }

    @GetMapping("initList")
    @Operation(summary = "get a list.")
    @Parameter(description = "A list")
    public ArrayList<String> getAList() {
        return service.initList();
    }

    // 1. 回覆RTMP串流狀態 (getRtmpInfo)
    // 2. 丟出目前串流資訊 (getStream)
    @GetMapping("hello")
    @Operation(summary = "Hello")
    @Parameter(description = "Hello example.")
    public void getHello() {

    }
}

@RestController
@RequestMapping("api/test")
class TestHello {
    @GetMapping("initList")
    @Operation(summary = "get a list.")
    @Parameter(description = "A list")
    public void getAList() {

    }
}
