# BSkyBlockTopTen

BSkyBlockTopTen is a plugin for BSkyBlock which allows you to create TopTen signs. You can also place a player head over the sign which will update with the sign.

### Installation
1. Place the jar in your plugins folder
2. Restart the server
3. Set `skyblock-world-name` in config.yml to the name of your BSkyBlock world from which the top ten should be loaded
4. Enter `/bsbtopten reload` to reload the config file

### Create TopTen sign
1. Set a sign
2. Type in the first line: [bsbtopten]
3. Enter in the second line the number of the place which should be displayed (1-10)

### Remove TopTen sign
Hold down the shift key and remove the sign

### Placing down a player head
This step is optional. You can place down a player head on top of the sign or on top of the block that the sign is connected to. The player head will update at the next sign update.

### Commands
* `/bsbtopten reload` - Reloads the files

### Permissions
* `bskyblocktopten.*` - Gives access to all BSkyBlockTopTen permissions
* `bskyblocktopten.reload` - Allows the user to reload the files
* `bskyblocktopten.create` - Allows the user to create a TopTen sign
* `bskyblocktopten.remove` - Allows the user to remove a TopTen sign