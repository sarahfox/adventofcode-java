package com.w3foxes.sarah.Year2024.Day15;

import java.util.ArrayList;
import java.util.List;

public class Path {
    List<PathElement> path;

    Path(List<String> lines){
        path = new ArrayList<>();

        for(String line : lines){
            if(!line.startsWith("#") && !line.isBlank()){
                for(char c : line.toCharArray()){
                    PathElement p = PathElement.get(c);
                    path.add(p);
                }
            }
        }
    }

    public List<PathElement> getPath(){
        return path;
    }
}
