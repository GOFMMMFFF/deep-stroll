package ap.deepstroll.vo.response;

import ap.deepstroll.bo.Result;
import ap.deepstroll.vo.ViewObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ResponseVO implements ViewObject {
    
    private ViewObject data;
    private Result result;
    
}
