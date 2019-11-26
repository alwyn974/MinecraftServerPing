package re.alwyn974.minecraftserverping;

import java.util.List;

/**
 * Informations of Minecraft Server
 * 
 * @author <a href="https://github.com/alwyn974"> Alwyn974 </a>
 * @since 1.0.0
 * @version 1.0.0
 */
public class MinecraftServerPingInfos {

	/**
	 * Server Informations for 1.9.X version and higher !
	 */
	public class V1_9_HIGHER {
		private Description description;
		private Players players;
		private Version version;
		private String favicon;
		private long latency;

		/**
		 * @return the MOTD
		 */
		public Description getDescription() {
			return description;
		}

		/**
		 * @return {@link Player}
		 */
		public Players getPlayers() {
			return players;
		}

		/**
		 * @return {@link Version}
		 */
		public Version getVersion() {
			return version;
		}

		/**
		 * @return Base64 encoded favicon image
		 */
		public String getFavicon() {
			return favicon;
		}
		

		/**
		 * @return the latency
		 */
		public long getLatency() {
			return latency;
		}

		/**
		 * @param latency the latency to set
		 */
		public void setLatency(long latency) {
			this.latency = latency;
		}

		public class Description {
			private String text;

			public String getText() {
				return text;
			}
		}

		public class Players {
			private int max;
			private int online;
			private List<Player> sample;

			public int getMax() {
				return max;
			}

			public int getOnline() {
				return online;
			}

			public List<Player> getSample() {
				return sample;
			}
		}

		public class Player {
			private String name;
			private String id;

			public String getName() {
				return name;
			}

			public String getId() {
				return id;
			}

		}

		public class Version {
			private String name;
			private String protocol;

			public String getName() {
				return name;
			}

			public String getProtocol() {
				return protocol;
			}
		}
	}

	/**
	 * Server Informations for 1.7.X version and higher !
	 */
	public class V1_7_HIGHER {
		private String description;
		private Players players;
		private Version version;
		private String favicon;
		private long latency;

		/**
		 * @return the latency
		 */
		public long getLatency() {
			return latency;
		}

		/**
		 * @param latency the latency to set
		 */
		public void setLatency(long latency) {
			this.latency = latency;
		}

		/**
		 * @return the MOTD
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @return {@link Player}
		 */
		public Players getPlayers() {
			return players;
		}

		/**
		 * @return {@link Version}
		 */
		public Version getVersion() {
			return version;
		}

		/**
		 * @return Base64 encoded favicon image
		 */
		public String getFavicon() {
			return favicon;
		}

		public class Players {
			private int max;
			private int online;
			private List<Player> sample;

			public int getMax() {
				return max;
			}

			public int getOnline() {
				return online;
			}

			public List<Player> getSample() {
				return sample;
			}
		}

		public class Player {
			private String name;
			private String id;

			public String getName() {
				return name;
			}

			public String getId() {
				return id;
			}

		}

		public class Version {
			private String name;
			private String protocol;

			public String getName() {
				return name;
			}

			public String getProtocol() {
				return protocol;
			}
		}
	}

}
