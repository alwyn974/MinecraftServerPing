/**
 * Copyright (C) 2019 Alwyn974 <https://github.com/alwyn974>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * The Minecraft Server Ping
 * 
 * <p>get Server information.
 * It allows you to access information sent to the client to display on the server list. 
 * Currently, information available is:</p>
 * 
 * 		- Favicon (Base64 encode)
 * 		- Players and samples
 * 		- Latency
 * 		- Version and more
 * 
 * <p>There are <b>2</b> different version of Server Ping. <br>
 * One version for 1.7.X and higher 
 * and the other for the 1.9.X and higher Version
 * </p>
 * 
 * It's very simple to use it, you have an exemple below
 * <blockquote><code> 
 * 		MinecraftServerPingInfos.V1_7_HIGHER data = new MinecraftServerPing().getPing_V1_7_HIGHER(new MinecraftServerPingOptions().setHostname("127.0.0.1").setPort(25565)); <br>
 * 		System.out.println(data.getDescription() + " " + data.getVersion().getName() + " " + data.getLatency() + " " + data.getPlayers().getOnline() + "/" + data.getPlayers().getMax());
 * </code></blockquote>
 * 
 * There are some difference for the V1_9_HIGHER Version check my <a href="https://github.com/alwyn974/MinecraftServerPing">github</a> repo for that.
 * 
 * @author <a href="https://github.com/alwyn974"> Alwyn974</a>
 * @since 1.0.0
 * @version 1.0.0
 */
package re.alwyn974.minecraftserverping;