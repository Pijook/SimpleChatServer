package pl.pijok.simpleChatServer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class Packet {

    private String senderID;
    private String title;
    private String payload;

    public Packet() {
    }
}
