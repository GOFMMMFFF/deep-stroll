package ap.deepstroll.entity;

import java.sql.Timestamp;

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
public class ThemeEntity {
    
    private Integer id;
    private String name;
    private String backgroundUrl;
    private String bgmUrl;
    private Integer isDefault;
    private Timestamp createTime;

}
