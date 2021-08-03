package nr.crud.service;

import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nr.crud.entity.Streaming;

@Service
public class StreamingService {
    // private final Streaming repository;

    // @Autowired
    // public StreamingService(Streaming repository) {
    // this.repository = repository;
    // }
    private ArrayList<String> topics = new ArrayList();

    public ArrayList<String> initList() {
        topics.clear();
        topics.add("Google");
        topics.add("HTC");
        topics.add("Apple");
        topics.add("MS");
        return topics;
    }

    public Streaming getStream() {
        Streaming stream = new Streaming();
        // stream.setCode(200);
        stream.setCode(200);
        stream.setMsg("msg");

        // stream.setStreamName("stream 1");
        // stream.setIsSchedule(false);
        stream.setStreamName("stream 1").setIsSchedule(false);
        stream.setInputUrl("http://localhost/live/");
        stream.setOutputUrl("http://localhost/ai/");
        stream.setStreamKey("1111");

        ArrayList<String> res = initList();
        System.out.println("res: " + res);
        return stream;
    }
}
