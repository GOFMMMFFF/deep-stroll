package ap.deepstroll.vo.response;

import ap.deepstroll.bo.BackMenuBO;
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
@ToString
@Builder
public class AdminLogInVO implements ViewObject {

    private String token;
    private BackMenuBO[] menu;
    
}
