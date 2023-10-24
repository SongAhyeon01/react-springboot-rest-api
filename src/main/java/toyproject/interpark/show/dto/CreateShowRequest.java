package toyproject.interpark.show.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateShowRequest {
    private String showName;
    private String showDate;
    private int showPrice;
    private String showPoster;
}
