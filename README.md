<div align="center">
    <h1>Minecraft Server Ping</h1>

![](https://img.shields.io/badge/Available%20for-1.7.10--1.17.X-brightgreen.svg?style=for-the-badge)
[![](https://img.shields.io/github/downloads/alwyn974/MinecraftServerPing/v1.0.0/total?color=brightgreen&logo=github&style=for-the-badge)](https://github.com/alwyn974/MinecraftServerPing/releases)
[![](https://img.shields.io/github/downloads/alwyn974/MinecraftServerPing/v2.0.0/total?color=brightgreen&logo=github&style=for-the-badge)](https://github.com/alwyn974/MinecraftServerPing/releases)
[![](https://img.shields.io/badge/License-GPL--3.0-brightgreen.svg?style=for-the-badge)](https://github.com/alwyn974/MinecraftServerPing/blob/v2/LICENSE)
[![](https://img.shields.io/badge/Gradle-5.6.1-brightgreen.svg?style=for-the-badge&logo=gradle)](https://docs.gradle.org/5.6.1/release-notes.html)

</div>  

Minecraft Server Ping est une API permettant de récupérer les informations d'un Serveur Minecraft grâce au [Ping](https://wiki.vg/Server_List_Ping).

Actuellement vous pouvez récuperez :

    ➳ Le favicon (Base64 encoded)
    ➳ Le nombre de joueurs
    ➳ La description du serveur (MOTD)
    ➳ La version du serveur
    ➳ La latence vers le serveur

Minecraft Server Ping est compilé avec [Gson-2.8.6](https://github.com/google/gson)<br>
Minecraft Server Ping est basé principalement sur le travail de [zh32](https://gist.github.com/zh32/7190955)

### Configuration

Vous devez utiliser la classe ``MinecraftServerPingOptions`` les options disponibles sont : <br>
<ul>
<li> <code>String</code> hostname (hostname du serveur, <b>obligatoire</b>)
<li> <code>int</code> port (port du serveur, <b>optionnel</b> par défaut <code>25565</code>)
<li> <code>int</code> timeout (socket timeout, <b>optionnel</b> par défaut <code>2000</code>)
<li> <code>String</code> charset (charset pour le MOTD, <b>optionnel</b> par défaut <code>UTF-8</code>)
</ul>

### Exemple

```java
MinecraftServerPingInfos data = new MinecraftServerPing().getPing(new MinecraftServerPingOptions().setHostname("play.hypixel.net").setPort(25565));
System.out.println(data.getDescription() + "\n" + data.getStrippedDescription() + "\n" + data.getVersion().getName() + "\n" + data.getLatency() + "ms\n" + data.getPlayers().getOnline() + "/" + data.getPlayers().getMax());
```

## Documentation

Vous pouvez aller voir la javadoc qui se trouve [ici](https://alwyn974.github.io/javadoc/minecraftserverping/). <br>
Un exemple est disponible [ici](https://github.com/alwyn974/MinecraftServerPing/blob/master/src/test/java/re/alwyn974/test/minecraftserverping/Main.java).

## Installation

Remplacez `%VERSION%` avec les versions disponibles (1.0.0 & 2.0.0)

### Gradle

```gradle
repositories {
    mavenCentral() 
    maven {
        url "https://alwyn974.github.io/maven/"
    }
}

dependencies {
    compile 're.alwyn974.minecraftserverping:MinecraftServerPing:%VERSION%'
}
```
