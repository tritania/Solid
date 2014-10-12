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

import java.io.File;

import org.granitemc.granite.api.Granite;
import org.granitemc.granite.api.Server;
import org.granitemc.granite.api.API;
import org.granitemc.granite.api.plugin.Plugin;
import org.granitemc.granite.api.plugin.PluginContainer;

import org.tritania.solid.commands.*;

@Plugin(name = "Solid", id = "solid", version = "0.0.1")
public class Solid {
	
    public Players players;
    public Storage store;
    public String datalocal;
	
	public Solid(){
		PluginContainer plugin = Granite.getPluginContainer(this);
		plugin.registerCommandHandler(new Teleport(this));
		plugin.registerCommandHandler(new Homes(this));
        
        datalocal = Granite.getServer().getDataDirectory().getAbsolutePath();
        
        players = new Players(this);
        store = new Storage(this);
	}
	
	public static String formatInfo(String message){
		return message;
	}
	
	public static String formatError(String message){
		return message;
	}
	
	public static String formatAlert(String message){
		return message;
	}
    
}
