package pl.pijok.simpleChatServer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import lombok.Getter;

import java.io.IOException;

public class Main {

    @Getter
    private static Server server;
    @Getter
    private static PacketSender packetSender;
    public static void main(String[] args) {
        server = new Server(51200, 51200);

        server.start();
        try {
            server.bind(2137);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Kryo kryo = server.getKryo();
        kryo.register(Packet.class);

        server.addListener(new PacketListener());
        packetSender = new PacketSender(server);
    }

}
