package com.demo.java.entity;

import java.io.*;

/**
 * 深拷贝
 * A class whose clone method uses serialization.
 */
public class SerialCloneable implements Cloneable, Serializable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        try {
            // save the object to a byte array
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try (ObjectOutputStream out = new ObjectOutputStream(bout)) {
                out.writeObject(this);
            }

            // read a clone of the object from the byte array
            try (InputStream bin = new ByteArrayInputStream(bout.toByteArray())) {
                ObjectInputStream in = new ObjectInputStream(bin);
                return in.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            CloneNotSupportedException e2 = new CloneNotSupportedException();
            e2.initCause(e);
            throw e2;
        }
    }
}