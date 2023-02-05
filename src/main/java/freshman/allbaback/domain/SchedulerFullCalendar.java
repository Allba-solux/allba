package freshman.allbaback.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Getter
@Setter
public class SchedulerFullCalendar {
    private String start;
    private String end;
    private String title;

    @Builder
    public SchedulerFullCalendar(String start, String end, String title) {
        this.start = start;
        this.end = end;
        this.title = title;
    }
}
