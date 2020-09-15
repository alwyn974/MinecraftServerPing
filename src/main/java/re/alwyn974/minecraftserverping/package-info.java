/**
 * Copyright (C) 2019-2020 Alwyn974 <https://github.com/alwyn974>
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
 * <p>
 * get Server information.
 * It allows you to access information sent to the client to display on the server list.
 * Currently, information available is:
 * </p>	
 * <ul>
 * 		<li> Favicon (Base64 encode) </li>
 * 		<li> Players and samples </li>
 * 		<li> Latency </li>
 * 		<li> Version </li>
 *      <li> Description and more </li>
 * </ul>
 * <br>
 * It's very simple to use it, you have an exemple below			
 * <blockquote><code> 
 * 		MinecraftServerPingInfos data = new MinecraftServerPing().getPing(new MinecraftServerPingOptions().setHostname("play.hypixel.net").setPort(25565)); <br>
 * 		System.out.println(data.getDescription() + "\n" + data.getStrippedDescription() + "\n" + data.getVersion().getName() + "\n" + data.getLatency() + "ms\n" + data.getPlayers().getOnline() + "/" + data.getPlayers().getMax());
 * </code></blockquote>
 * 
 * @author <a href="https://github.com/alwyn974"> Alwyn974</a>
 * @since 1.0.0
 * @version 2.0.0
 */
package re.alwyn974.minecraftserverping;