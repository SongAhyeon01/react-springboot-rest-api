package toyproject.interpark.show.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CreateShowRequest {
    private String showName;
    private String showDate;
    private int showPrice;
    private int theaterId;
    private float showPoster;
}
