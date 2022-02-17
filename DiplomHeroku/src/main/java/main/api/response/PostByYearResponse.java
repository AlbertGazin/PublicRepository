package main.api.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PostByYearResponse {
    private List<String> years;
    private Map<String, Long> posts;
}
