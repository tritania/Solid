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

package org.tritania.solid.commands;

import org.granitemc.granite.api.Granite;
import org.granitemc.granite.api.command.Command;
import org.granitemc.granite.api.command.CommandInfo;
import org.granitemc.granite.api.entity.player.Player;
import org.granitemc.granite.api.utils.Location;

import org.tritania.solid.Solid;

public class Homes {
    
    public Solid solid;
    
    public Homes(Solid solid) {
        this.solid = solid;
    }
    
    @Command(name = "sethome", info = "Sets a home", aliases = {})
    public void onCommandSetHome(CommandInfo info) {
        Player player = (Player) info.getCommandSender();
        solid.players.setHomeLocation(player);
        player.sendMessage("Home set!");
    }
    
    @Command(name = "home", info = "teleports a player home", aliases = {})
    public void onCommandHome(CommandInfo info) {
        Player player = (Player) info.getCommandSender();
        solid.players.getHomeLocation(player);
    }
}
