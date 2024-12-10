package com.w3foxes.sarah.Year2023.Day05;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AlmanacMap {
    String from;
    String to;
    List<Range> ranges = new ArrayList<Range>();

    AlmanacMap(String header){
        // Header is in the form <from>-to-<to> map:
        StringTokenizer st = new StringTokenizer(header.replace(" map:", ""), "-", false);
        from = st.nextToken();
        st.nextToken();
        to = st.nextToken();
    }

    public String getFrom() { return from;}
    public String getTo() { return to;}
    public List<Range> getRanges() { return ranges;}

    public void addRange(String line){
        // Expected format <start of destination range> <start of source range> <range length>
        StringTokenizer st = new StringTokenizer(line, " ", false);
        long toStart = Long.parseLong(st.nextToken());
        long fromStart = Long.parseLong(st.nextToken());
        long rangeLength = Long.parseLong(st.nextToken());
        ranges.add(new Range(fromStart, toStart, rangeLength));
    }

    public long convertPoint(long point){
        long converted = -1;
        for(Range r : ranges){
            if(r.isInRange(point)){
                converted = r.convertPoint(point);
            }
        }

        // Any points not mapped convert to the same number
        if(converted == -1){
            converted = point;
        }

        return converted;
    }
}
