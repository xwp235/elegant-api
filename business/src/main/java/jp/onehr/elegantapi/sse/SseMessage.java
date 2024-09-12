package jp.onehr.elegantapi.sse;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SseMessage {

    private String group;
    @NotBlank
    private String clientId;
    @NotBlank
    private String message;
    private String eventName;

}
