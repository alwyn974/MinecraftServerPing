### Minecraft Server Ping

Minecraft Server Ping est une API permettant de récupérer les informations d'un Serveur Minecraft grâce au [Ping](https://wiki.vg/Server_List_Ping).

Actuellement vous pouvez récuperez :

    ➳ Le favicon (Base64 encoded)
    ➳ Le nombre de joueurs
    ➳ La description du serveur (MOTD)
    ➳ La version du serveur
    ➳ La latence vers le serveur

Minecraft Server Ping est compilé avec [Gson-2.3.1](https://github.com/google/gson)<br>
Minecraft Server Ping est basé principalement sur le travail de [zh32](https://gist.github.com/zh32/7190955)

### Configuration

Il y a actuellement 2 version du ping, la version ``1.7.X_HIGHER`` et la ``1.9.X_HIGHER``<br>
Vous devez utiliser la classe ``MinecraftServerPingOptions`` les options disponibles sont : <br>
<ul>
<li> <code>String</code> hostname (hostname du serveur, <b>obligatoire</b>)
<li> <code>int</code> port (port du serveur, <b>optionnel</b> par défaut <code>25565</code>)
<li> <code>int</code> timeout (socket timeout, <b>optionnel</b> par défaut <code>2000</code>)
<li> <code>String</code> charset (charset pour le MOTD, <b>optionnel</b> par défaut <code>UTF-8</code>)
</ul>

### Exemples

Version ``1.7.X_HIGHER``

```java
MinecraftServerPingInfos.V1_7_HIGHER data = new MinecraftServerPing().getPing_V1_7_HIGHER(new MinecraftServerPingOptions().setHostname("127.0.0.1").setPort(25565));
System.out.println(data.getDescription() + " " + data.getVersion().getName() + " " + data.getLatency() + " " + data.getPlayers().getOnline() + "/" + data.getPlayers().getMax());
```
Version ``1.9.X_HIGHER``

```java
MinecraftServerPingInfos.V1_9_HIGHER data = new MinecraftServerPing().getPing_V1_9_HIGHER(new MinecraftServerPingOptions().setHostname("127.0.0.1").setPort(25565));
System.out.println(data.getDescription() + " " + data.getVersion().getName() + " " + data.getLatency() + " " + data.getPlayers().getOnline() + "/" + data.getPlayers().getMax());
```

