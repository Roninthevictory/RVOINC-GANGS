# Gangz X Plugin
Author: Ronin Victory

## Overview
Gangz X is a powerful, customizable Minecraft plugin that allows players to create and manage their own gangs within the server. The plugin supports gang creation, inviting players, accepting/denying invites, and managing gang members with roles like owner, officer, and member.

Gangz X enables gang wars, territory management, and more, providing a comprehensive solution for server owners who want to integrate competitive and cooperative gang dynamics into their gameplay.

## Features
Gang Creation: Players can create a gang, and only one gang can be created per player.  

Gang Roles: Gang members can have various roles like leader, officer, or member.  

Gang Invites: Only gang owners can invite players to join their gang.  

> Gang War & Territories (Future): Features to be added for more competitive gameplay.  

> Gang Funds/Properties (Future): Manage funds and properties for each gang.  

### Installation
Download Gangz X Plugin JAR:  

Download the latest version of the Gangz X plugin JAR file from your distribution platform (e.g., GitHub, your server, or the provided download link).
Install on Server:  

Place the GangzX.jar file in your server’s plugins folder.  

Restart your Minecraft server to load the plugin.

### Configuration
Once the plugin is installed, you may want to configure it to suit your needs. The plugin will generate a config.yml file in the plugins/GangzX/ directory.

You can adjust various settings in this file, such as:

**Gang Names**: Restrictions on gang names (length, special characters, etc.).
**Invite Timeout**: Time before an invite expires.
**Max Gangs per Player**: Limit the number of gangs a player can join.
**Territory Settings** (Future Update): Configure territory management options.
Note: If you wish to customize the configuration, simply edit the config.yml file after starting the server for the first time.

## Commands
> /gang create <name>  
Usage: /gang create <name>  
Description: Creates a new gang with the specified name. The player becomes the owner of the gang.  
Permissions Required: None  
Example: /gang create AwesomeGang  

> /gang invite <player>  
Usage: /gang invite <player>  
Description: Sends an invitation to a player to join the gang. Only the gang owner can use this command.  
Permissions Required: gangsplugin.owner  
Example: /gang invite PlayerOne  

> /gang accept <gangname>  
Usage: /gang accept <gangname>  
Description: Accept an invite to join a gang. The player must have a pending invite to the specified gang.  
Permissions Required: None  
Example: /gang accept AwesomeGang  

> /gang deny <gangname>  
Usage: /gang deny <gangname>  
Description: Deny a pending invite to a gang.  
Permissions Required: None  
Example: /gang deny AwesomeGang  


### Permissions
gangsplugin.use: Allows players to use gang-related commands like create, invite, accept, and deny.  

gangsplugin.owner: Allows the gang owner to invite players to the gang.  

gangsplugin.member: Allows players to be added as members of the gang after an invite is accepted.  



## License
Copyright (c) 2025 RVO inc.

All rights reserved.

By using this plugin, you agree to the following terms:

1. **Permitted Use**: 
   - You are permitted to use the plugin on your personal and Public Minecraft server.
   - The plugin is intended for personal, non-commercial use only.

2. **Restrictions**:
   - You **may not modify** the plugin's source code or any part of it in any way.
   - You **may not distribute, sell, or share** the plugin, either in its original form or modified, to any third party.
   - You **may not decompile, reverse engineer, or attempt to extract the source code** of the plugin.
   - You **may not use the plugin** for any commercial purposes, including but not limited to using it on servers that charge players for access or features.
   - You **may not host, resell, or redistribute** the plugin in any manner without explicit written consent from the author.
   
3. **No Warranty**:
   - The plugin is provided "as is", without any warranty of any kind, either express or implied, including but not limited to the warranties of merchantability, fitness for a particular purpose, or non-infringement.
   - The author shall not be liable for any damages or issues arising from the use of this plugin.

4. **Author Credit**:
   - The plugin must retain the original author credit, **Ronin Victory**, and cannot be removed or altered in any way.

5. **Termination**:
   - The author reserves the right to revoke your permission to use the plugin at any time, for any reason, without notice.

By using this plugin, you acknowledge and agree to abide by all of the above terms.

For any inquiries, questions, or requests for permission, please contact:

**Email**: roninvictoryofficial@gmail.com
