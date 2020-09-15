/**
 * Copyright Alwyn974 2019-2020
 * 
 * @author Developed By <a href="https://github.com/alwyn974"> Alwyn974</a>
 */

package re.alwyn974.test.minecraftserverping;

import java.io.IOException;

import re.alwyn974.minecraftserverping.MinecraftServerPing;
import re.alwyn974.minecraftserverping.MinecraftServerPingInfos;
import re.alwyn974.minecraftserverping.MinecraftServerPingOptions;

public class Main {

	public static void main(String[] args) throws IOException {
		MinecraftServerPingInfos data = new MinecraftServerPing().getPing(new MinecraftServerPingOptions().setHostname("play.hypixel.net").setPort(25565));
		System.out.println(data.getDescription() + "\n" + data.getStrippedDescription() + "\n" + data.getVersion().getName() + "\n" + data.getLatency() + "ms\n" + data.getPlayers().getOnline() + "/" + data.getPlayers().getMax());
	}

}
