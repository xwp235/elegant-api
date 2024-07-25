package jp.onehr.elegantapi.sse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sse")
public class NotificationController {

    private final SseHelper sseHelper;

    @GetMapping("{type}/open")
    public SseEmitter open(@PathVariable String type) {
        return sseHelper.open(type);
    }

    @PostMapping("broadcast")
    public void send2AllClients(@Valid @RequestBody BroadcastMessage message) {
        sseHelper.send2AllClients(message);
    }

    @PostMapping("send-message")
    public void send2Client(@Valid @RequestBody SseMessage message) {
        sseHelper.send2Client(message);
    }

    @GetMapping("{type}/close")
    public void closeConnect(@PathVariable String type) {
        sseHelper.close(type);
    }

}
