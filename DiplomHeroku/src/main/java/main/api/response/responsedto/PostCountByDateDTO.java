package main.api.response.responsedto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostCountByDateDTO {
    private String date;
    private long count;
}