package pl.pijok.simpleChatServer;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.google.gson.Gson;

public class PacketListener extends Listener {

    private final Gson gson;

    public PacketListener() {
        gson = new Gson();
    }

    @Override
    public void received(Connection connection, Object object) {
        super.received(connection, object);
        processMessage(connection, object);
    }

    public void processMessage(Connection connection, Object object) {
        Packet packet = (Packet) object;

        System.out.println(packet.getSenderID() + " > " + packet.getPayload());
        Main.getServer().sendToAllExceptTCP(connection.getID(), packet);

    }

}
