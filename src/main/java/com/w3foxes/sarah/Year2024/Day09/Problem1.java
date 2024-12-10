package com.w3foxes.sarah.Year2024.Day09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem1 {

    public static void main(String[] args) throws IOException {
        // Find the data file and read it in
        List<String> lines = FileReaderUtil.readLines(Problem1.class, "Problem1.txt");
        long total = compactAndFindChecksum(lines.get(0));

        System.out.println(total);
    }

    public static long compactAndFindChecksum(String line) {
        List<Block> uncompacted = parseBlocks(line);
        //printBlocks(uncompacted);
        List<Block> compacted = compactBlocks(uncompacted);
        //printBlocks(compacted);
        return calculateChecksum(compacted);
    }

    public static void printBlocks(List<Block> blocks){
        StringBuffer sb = new StringBuffer();
        for(Block block : blocks){
            if(block.isFree()){
                sb.append(".");
            }
            else {
                sb.append(block.id());
            }
        }
        System.out.println(sb.toString());
    }

    public static List<Block> parseBlocks(String line){
        List<Block> blocks = new ArrayList<>();

        for(int i = 0; i < line.length(); i++){
            int size = Integer.parseInt("" + line.charAt(i));
            int id = i / 2;
            for(int j = 0; j < size; j++){
               blocks.add(new Block(id, i % 2 == 1));
            }
        }
        return blocks;
    }

    public static List<Block> compactBlocks(List<Block> blocks) {
        int start = 0;
        int end = blocks.size() - 1;

        while(start < end){
            // Iterate until blocks[start] is a free spot and blocks[end] has a used block
            // Then swap them
            if(blocks.get(start).isFree() && !blocks.get(end).isFree()){
                Collections.swap(blocks, start, end);
                start++;
                end--;
            }
            if(!blocks.get(start).isFree()){
                start++;
            }
            if(blocks.get(end).isFree()){
                end--;
            }
        }

        return blocks;
    }

    public static long calculateChecksum(List<Block> compacted) {
        long checksum = 0;

        for (int i = 0; i < compacted.size(); i++) {
            if (!compacted.get(i).isFree()) {
                checksum += i * compacted.get(i).id();
            }
        }

        return checksum;
    }

    public record Block(long id, boolean isFree) {
    }

}
