package pl.pijok.simpleChatServer;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;

public class PacketSender {

    private final Server server;

    public PacketSender(Server server) {
        this.server = server;
    }

    private void sendPacket(Packet packet, Connection connection) {
        try {
            connection.sendTCP(packet);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
