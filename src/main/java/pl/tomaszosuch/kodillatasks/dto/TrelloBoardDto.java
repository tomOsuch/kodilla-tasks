package pl.tomaszosuch.kodillatasks.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import pl.tomaszosuch.kodillatasks.dto.TrelloListDto;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrelloBoardDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;
}
