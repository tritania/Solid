/*
 * License (MIT)
 * -------
 * Copyright (c) 2014 Erik Wilson
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.tritania.solid;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import org.granitemc.granite.api.utils.Location;
import org.granitemc.granite.api.entity.player.Player;

import org.tritania.solid.Solid;

public class Players {
    
    public Solid solid;
    private HashMap<String, String> homes = new HashMap<String, String>();
    private HashMap<UUID, UUID> teleports = new HashMap<UUID, UUID>();

    public Players(Solid solid)
    {
        this.solid = solid;
    }

    
    public void loadPlayerHomes() {
        homes = solid.store.loadHomes("homes.data");
    }
    
    public Player getTeleportDestination(String playerName) {
        Player player = null; //debug
        return player;
    }
    
    public Location getHomeLocation(Player player) {
        String id = player.getName();
        String local[] = homes.get(id).split(","); 
        if (player.getWorld().getLevelName().equals(local[0])) { //until Granite offers multiworld support
            Location location = new Location(player.getWorld(),Double.parseDouble(local[1]),Double.parseDouble(local[2]),Double.parseDouble(local[3]));
            return location;
        } else {
            return player.getLocation();
        }
    }
    
    public void setHomeLocation(Player player) {
        String id = player.getName();
        UUID ids = player.getUniqueID(); 
        Location location = player.getLocation();
        String local = String.valueOf(location.getWorld().getLevelName()) + "," + String.valueOf(location.getX()) + "," + String.valueOf(location.getY()) + "," + String.valueOf(location.getZ()); //???
        homes.put(id, local);
        saveHomes();
    }
    
    public void saveHomes() { //going to be called everytime a new home is created
        solid.store.saveHomes(homes, "homes.data");
    }
    
}
