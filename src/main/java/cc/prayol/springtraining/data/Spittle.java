package cc.prayol.springtraining.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author hjx
 * @date 2020/8/14
 */
@Data
public class Spittle {
    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, Date time) {
        this(null, message, time, null, null);
    }

    public Spittle(Long id, String message, Date time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
