package nr.elastic.document;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import nonapi.io.github.classgraph.json.Id;
import nr.elastic.helper.Indices;

@TypeAlias("cartask")
@Document(indexName = Indices.CARTASK_INDEX)
public class CarTask {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String taskName;

    @Field(type = FieldType.Text)
    private String carNumber;

    // @Field(type = FieldType.Date)
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    // private Date autoSchedule;

    // @Field(type = FieldType.Text)
    // private String taskStatus;

    // @Field(type = FieldType.Text)
    // private String videoUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}