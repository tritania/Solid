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

public class Teleport {
    
    @Command(name = "tpa", info = "Sends a tp request to a player", aliases = {"tp"})
    public void onCommandTpa(CommandInfo info) {
        //send a request to another player
        //set teleport condition on players
    }
    
    @Command(name = "tpahere", info = "Sends a tpahere request to a player", aliases = {"tphere"})
    public void onCommandTpa(CommandInfo info) {
        //send a request to another player
        //set teleport condition on players
    }
    
    @Command(name = "tpaccept", info = "Accepts pending tp requests", aliases = {"ta"})
    public void onCommandTpa(CommandInfo info) {
        //teleport players
        //set teleport condition on players
    }
    
    @Command(name = "tpdeny", info = "Sends a tp request to a player", aliases = {"td"})
    public void onCommandTpa(CommandInfo info) {
        //set teleport condition on players
    }
}
