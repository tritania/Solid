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
import java.util.Iterator;
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
import java.util.ArrayList;

import org.tritania.solid.Solid;

public class Storage implements Serializable
{

    public Solid solid;
    public String dir = "plugins/Solid";

    public Storage(Solid solid)
    {
        this.solid = solid;
        new File(dir).mkdirs();
    }

    public void saveHomes(HashMap toBeSaved, String fileName)
    {
        try
        {
            File data =  new File(dir + "/" + fileName);
            FileOutputStream fos   = new FileOutputStream(data);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(toBeSaved);
            oos.flush();
            oos.close();
            fos.close();

        }
        catch(Exception ex)
        {
            //need log system
        }
    }

    public HashMap loadHomes(String fileName)
    {
        HashMap dataLoaded = new HashMap();
        try
        {
            File data            = new File(dir + "/" + fileName);
            FileInputStream fis  = new FileInputStream(data);
            ObjectInputStream ois= new ObjectInputStream(fis);

            dataLoaded = (HashMap)ois.readObject();

            ois.close();
            fis.close();
        }
        catch(Exception ex)
        {
             //need log system
        }
        return dataLoaded;
    }
}
