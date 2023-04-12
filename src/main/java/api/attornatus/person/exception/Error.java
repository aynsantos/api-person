package api.attornatus.person.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {
    private Integer status;
    private LocalDate timeStamp;
    private String title;
    private List<Fields> field;

    @AllArgsConstructor
    @Getter
    public static class Fields {
        private String name;
        private String message;
    }

}
