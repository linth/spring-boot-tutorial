package nr.crud.entity;

class StreamBase {
    protected int code;
    protected String msg = "";

    public int getCode() {
        return code;
    }

    public StreamBase setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public StreamBase setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}

public class Streaming extends StreamBase {
    private String streamName;
    private boolean isSchedule;
    private String inputUrl;
    private String outputUrl;
    private String streamKey;

    public String getStreamName() {
        return streamName;
    }

    public Streaming setStreamName(String streamName) {
        this.streamName = streamName;
        return this;
    }

    public boolean getIsSchedule() {
        return isSchedule;
    }

    public Streaming setIsSchedule(Boolean isSchedule) {
        this.isSchedule = isSchedule;
        return this;
    }

    public String getInputUrl() {
        return inputUrl;
    }

    public void setInputUrl(String inputUrl) {
        this.inputUrl = inputUrl;
    }

    public String getOutputUrl() {
        return outputUrl;
    }

    public void setOutputUrl(String outputUrl) {
        this.outputUrl = outputUrl;
    }

    public String getStreamKey() {
        return streamKey;
    }

    public void setStreamKey(String streamKey) {
        this.streamKey = streamKey;
    }
}
