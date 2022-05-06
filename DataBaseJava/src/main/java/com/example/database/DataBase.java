package com.example.database;

import javafx.collections.ObservableList;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public ArrayList<Person> objects;

    DataBase(){
        objects = new ArrayList<Person>();
    }
    public void readFile(String fileName) throws IOException {
        Person s = new Person();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(", ");
                s.setParams(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                objects.add(s);
                line = reader.readLine();
                split = line.split(", ");
                s.setParams(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
                objects.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(String fileName){
        try(FileWriter writer = new FileWriter(fileName, false)) {
            for(int i = 0; i < objects.size(); i++) {
                String text = objects.get(i).toString() + "\n";
                writer.write(text);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void addObject(Person person){
        objects.add(person);
    }

    public void delObject(int index){
        objects.remove(index);
    }

    public Person getObject(int index){
        return objects.get(index);
    }

    public String[] getTable(int i){
        return objects.get(i).toString().split(", ");
    }
}
