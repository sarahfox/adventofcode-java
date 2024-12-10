package com.w3foxes.sarah.Year2024.Day09;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.w3foxes.sarah.util.FileReaderUtil;

public class Problem2 {
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

    public static void printBlocks(List<Block> blocks) {
        StringBuffer sb = new StringBuffer();
        for (Block block : blocks) {
            for(int i = 0; i < block.getFree(); i++){
                sb.append(".");
            } 
            for(int j = 0; j < block.getBlocks(); j++){
                sb.append(block.getId());
            }
        }
        System.out.println(sb.toString());
    }

    public static List<Block> parseBlocks(String line) {
        List<Block> blocks = new ArrayList<>();
        int free = 0;
        for (int i = 0; i < line.length(); i++) {
            if(i % 2 == 0){
                blocks.add(new Block(i / 2, free, line.charAt(i) - '0'));
            }
            else {
                free = line.charAt(i) - '0';
            }
        }
        return blocks;
    }

    public static List<Block> compactBlocks(List<Block> blocks) {
        List<Block> reversed = new ArrayList<>();
        for(int i = blocks.size() - 1; i >= 0; i--){
            reversed.add(blocks.get(i));
        }

        // Starting from the end of the list
        for(Block b : reversed){
            // Find the first free spot that can fit that block.
            int freeIndex = findFreeIndex(blocks, b.getId(), b.getBlocks());

            // If no free spot, go to the next block
            if(freeIndex == -1){
                continue;
            }
            // If there is a free spot, move the block up
            else {
                // Find where this block is currently
                int currentIndex = blocks.indexOf(b);

                // Special case - the block is going back into the free space of it's own spot
                // Then we decrement it's own free space, and increment the space behind only by the space used
                if(currentIndex == freeIndex){
                    b.setFree(0);
                    if(currentIndex < blocks.size() - 1){
                        Block blockBehindCurrent = blocks.get(currentIndex + 1);
                        blockBehindCurrent.setFree(blockBehindCurrent.getFree() + b.getBlocks());
                    }
                   
                }
                else {
                    // Increment the amount of free space of the block behind where this block originally was.
                    if(currentIndex < blocks.size() - 1){
                        Block blockBehindCurrent = blocks.get(currentIndex + 1);
                        blockBehindCurrent.setFree(blockBehindCurrent.getFree() + b.getBlocks() + b.getFree());
                    }
                    // Decrement the amount of free space by the size of the block
                    Block blockWithFreeSpace = blocks.get(freeIndex);
                    blockWithFreeSpace.setFree(blockWithFreeSpace.getFree() - b.getBlocks());

                    blocks.remove(b);
                    // Mark the free space on this block as zero
                    b.setFree(0);

                    // Move this block to before where the free space is
                    blocks.add(freeIndex, b);
                }
            }
            //printBlocks(blocks);
        }

        return blocks;
    }

    public static int findFreeIndex(List<Block> blocks, long id, int spaceNeeded){
        for(int i = 0; i < blocks.size(); i++){
            if(blocks.get(i).getFree() >= spaceNeeded){
                return i;
            }
            // If haven't found space before where the block currently is, don't move it
            if(blocks.get(i).getId() == id){
                return -1;
            }
        }

        return -1;
    }

    public static long calculateChecksum(List<Block> blocks) {
        long checksum = 0;
        // First block always has blank free space, lower i to compensate
        int i = -1;
        for(Block b : blocks){
            // Skip the free spaces
            i += b.getFree();
            //System.out.println("Skip free, i = " + i);
            for(int j = 0; j < b.getBlocks(); j++){
                i++;
                checksum += i * b.getId();
                //System.out.println("In block, adding i * id: " + i + " * " + b.getId() + " = " + (i * b.getId()));
            }
        }

        return checksum;
    }

}
