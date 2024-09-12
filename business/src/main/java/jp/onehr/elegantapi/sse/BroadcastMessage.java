package jp.onehr.elegantapi.sse;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BroadcastMessage {

    private String group;
    @NotBlank
    private String message;
    private String eventName;

}
