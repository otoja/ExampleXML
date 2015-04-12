/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readxmlexample;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kama <kamila.przychodzen@gmail.com>
 */
public class ReadXMLExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Person p = new Person(1, "Test", 15);
            write(p, "person.xml");
            
            Person newPerson = read("person.xml");
            System.out.println(newPerson.toString());
            
        } catch (Exception ex) {
            Logger.getLogger(ReadXMLExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void write(Person p, String filename) throws Exception {
        try (XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(filename)))) {
            encoder.writeObject(p);
        }
    }

    public static Person read(String filename) throws Exception {
        Person p;
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(
                new FileInputStream(filename)))) {
            p = (Person) decoder.readObject();
        }
        return p;
    }

}
