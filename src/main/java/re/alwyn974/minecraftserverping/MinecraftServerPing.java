package re.alwyn974.minecraftserverping;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import com.google.gson.Gson;

/**
 * The main class of the Minecraft Server Ping !
 * 
 * @author <a href="https://github.com/alwyn974"> Alwyn974 </a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class MinecraftServerPing {

	public MinecraftServerPingInfos.V1_7_HIGHER getPing_V1_7_HIGHER(final String hostname) throws IOException {
		return this.getPing_V1_7_HIGHER(new MinecraftServerPingOptions().setHostname(hostname));
	}
	
	public MinecraftServerPingInfos.V1_9_HIGHER getPing_V1_9_HIGHER(final String hostname) throws IOException {
		return this.getPing_V1_9_HIGHER(new MinecraftServerPingOptions().setHostname(hostname));
	}

	public MinecraftServerPingInfos.V1_7_HIGHER getPing_V1_7_HIGHER(final MinecraftServerPingOptions options) throws IOException {
		MinecraftServerPingUtil.validate(options.getHostname(), "Hostname cannot be null");
		MinecraftServerPingUtil.validate(options.getPort(), "Port cannot be null.");
		
		final Socket socket = new Socket();
		socket.connect(new InetSocketAddress(options.getHostname(), options.getPort()), options.getTimeout());
		final long startTime = System.currentTimeMillis();
		final DataInputStream in = new DataInputStream(socket.getInputStream());
        final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        //-> Handshake
        
        ByteArrayOutputStream handshake_bytes = new ByteArrayOutputStream();
        DataOutputStream handshake = new DataOutputStream(handshake_bytes);
        
        handshake.writeByte(MinecraftServerPingUtil.PACKET_HANDSHAKE);
        MinecraftServerPingUtil.writeVarInt(handshake, MinecraftServerPingUtil.PROTOCOL_VERSION);
        MinecraftServerPingUtil.writeVarInt(handshake, options.getHostname().length());
        handshake.writeBytes(options.getHostname());
        handshake.writeShort(options.getPort());
        MinecraftServerPingUtil.writeVarInt(handshake, MinecraftServerPingUtil.STATUS_HANDSHAKE);
		
        MinecraftServerPingUtil.writeVarInt(out, handshake_bytes.size());
        out.write(handshake_bytes.toByteArray());
        
        //-> Status request

        out.writeByte(0x01); // Size of packet
        out.writeByte(MinecraftServerPingUtil.PACKET_STATUSREQUEST);
        
        //<- Status response
        
        MinecraftServerPingUtil.readVarInt(in); // Size
        int id = MinecraftServerPingUtil.readVarInt(in);
        
        MinecraftServerPingUtil.io(id == -1, "Server prematurely ended stream.");
        MinecraftServerPingUtil.io(id != MinecraftServerPingUtil.PACKET_STATUSREQUEST, "Server returned invalid packet id.");

        int length = MinecraftServerPingUtil.readVarInt(in);
        MinecraftServerPingUtil.io(length == -1, "Server prematurely ended stream.");
        MinecraftServerPingUtil.io(length == 0, "Server returned unexpected value.");

        byte[] data = new byte[length];
        in.readFully(data);
        String json = new String(data, options.getCharset());
        
        //-> Ping
        long now = System.currentTimeMillis();
        out.writeByte(0x09); // Size of packet
        out.writeByte(MinecraftServerPingUtil.PACKET_PING);
        out.writeLong(now);

        //<- Ping
        
        MinecraftServerPingUtil.readVarInt(in); // Size
        id = MinecraftServerPingUtil.readVarInt(in);
        MinecraftServerPingUtil.io(id == -1, "Server prematurely ended stream.");
        MinecraftServerPingUtil.io(id != MinecraftServerPingUtil.PACKET_PING, "Server returned invalid packet id.");
        
        MinecraftServerPingInfos.V1_7_HIGHER infos = new Gson().fromJson(json, MinecraftServerPingInfos.V1_7_HIGHER.class);
        infos.setLatency(now - startTime);
        
        //<- Close

        handshake.close();
        handshake_bytes.close();
        out.close();
        in.close();
        socket.close();
        
        return infos;
	}
	
	public MinecraftServerPingInfos.V1_9_HIGHER getPing_V1_9_HIGHER(final MinecraftServerPingOptions options) throws IOException {
		MinecraftServerPingUtil.validate(options.getHostname(), "Hostname cannot be null");
		MinecraftServerPingUtil.validate(options.getPort(), "Port cannot be null.");
		
		final Socket socket = new Socket();
		socket.connect(new InetSocketAddress(options.getHostname(), options.getPort()), options.getTimeout());
		final long startTime = System.currentTimeMillis();
		final DataInputStream in = new DataInputStream(socket.getInputStream());
        final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        //-> Handshake
        
        ByteArrayOutputStream handshake_bytes = new ByteArrayOutputStream();
        DataOutputStream handshake = new DataOutputStream(handshake_bytes);
        
        handshake.writeByte(MinecraftServerPingUtil.PACKET_HANDSHAKE);
        MinecraftServerPingUtil.writeVarInt(handshake, MinecraftServerPingUtil.PROTOCOL_VERSION);
        MinecraftServerPingUtil.writeVarInt(handshake, options.getHostname().length());
        handshake.writeBytes(options.getHostname());
        handshake.writeShort(options.getPort());
        MinecraftServerPingUtil.writeVarInt(handshake, MinecraftServerPingUtil.STATUS_HANDSHAKE);
		
        MinecraftServerPingUtil.writeVarInt(out, handshake_bytes.size());
        out.write(handshake_bytes.toByteArray());
        
        //-> Status request

        out.writeByte(0x01); // Size of packet
        out.writeByte(MinecraftServerPingUtil.PACKET_STATUSREQUEST);

        //<- Status response
        
        MinecraftServerPingUtil.readVarInt(in); // Size
        int id = MinecraftServerPingUtil.readVarInt(in);
        
        MinecraftServerPingUtil.io(id == -1, "Server prematurely ended stream.");
        MinecraftServerPingUtil.io(id != MinecraftServerPingUtil.PACKET_STATUSREQUEST, "Server returned invalid packet id.");

        int length = MinecraftServerPingUtil.readVarInt(in);
        MinecraftServerPingUtil.io(length == -1, "Server prematurely ended stream.");
        MinecraftServerPingUtil.io(length == 0, "Server returned unexpected value.");

        byte[] data = new byte[length];
        in.readFully(data);
        String json = new String(data, options.getCharset());
        
        //-> Ping
        long now = System.currentTimeMillis();
        out.writeByte(0x09); // Size of packet
        out.writeByte(MinecraftServerPingUtil.PACKET_PING);
        out.writeLong(now);

        //<- Ping
        
        MinecraftServerPingUtil.readVarInt(in); // Size
        id = MinecraftServerPingUtil.readVarInt(in);
        MinecraftServerPingUtil.io(id == -1, "Server prematurely ended stream.");
        MinecraftServerPingUtil.io(id != MinecraftServerPingUtil.PACKET_PING, "Server returned invalid packet id.");
        
        MinecraftServerPingInfos.V1_9_HIGHER infos = new Gson().fromJson(json, MinecraftServerPingInfos.V1_9_HIGHER.class);
        infos.setLatency(now - startTime);
        
        //<- Close

        handshake.close();
        handshake_bytes.close();
        out.close();
        in.close();
        socket.close();
        
        return infos;
	}
}