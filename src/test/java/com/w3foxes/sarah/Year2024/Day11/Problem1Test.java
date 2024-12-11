package com.w3foxes.sarah.Year2024.Day11;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Problem1Test {
    @Test
    public void testIterateStones1(){
        String input = "0 1 10 99 999";
        List<Long> expected = Arrays.asList(1l, 2024l, 1l, 0l, 9l, 9l, 2021976l);
        List<Long> outputs = Problem1.iterateStones(input, 1);

        assertEquals(expected.size(), outputs.size());
        for(int i = 0; i < expected.size(); i++){
            assertEquals(expected.get(i), outputs.get(i));
        }
    }

    @Test
    public void testIterateStones2(){
        String input = "125 17";
        List<Long> expected = Arrays.asList(253000l, 1l, 7l);
        List<Long> outputs = Problem1.iterateStones(input, 1);

        assertEquals(expected.size(), outputs.size());
        for(int i = 0; i < expected.size(); i++){
            assertEquals(expected.get(i), outputs.get(i));
        }
     }
     @Test
     public void testIterateStones3(){
         String input = "125 17";
         List<Long> expected = Arrays.asList(253l, 0l, 2024l, 14168l);
         List<Long> outputs = Problem1.iterateStones(input, 2);
 
         assertEquals(expected.size(), outputs.size());
         for(int i = 0; i < expected.size(); i++){
             assertEquals(expected.get(i), outputs.get(i));
         }
      }
      @Test
      public void testIterateStones4(){
          String input = "125 17";
          List<Long> expected = Arrays.asList(512072l, 1l, 20l, 24l, 28676032l);
          List<Long> outputs = Problem1.iterateStones(input, 3);
  
          assertEquals(expected.size(), outputs.size());
          for(int i = 0; i < expected.size(); i++){
              assertEquals(expected.get(i), outputs.get(i));
          }
       }
       @Test
       public void testIterateStones5(){
           String input = "125 17";
           List<Long> expected = Arrays.asList(512l, 72l, 2024l, 2l, 0l, 2l, 4l, 2867l, 6032l);
           List<Long> outputs = Problem1.iterateStones(input, 4);
   
           assertEquals(expected.size(), outputs.size());
           for(int i = 0; i < expected.size(); i++){
               assertEquals(expected.get(i), outputs.get(i));
           }
        }
        @Test
    public void testIterateStones6(){
        String input = "125 17";
        List<Long> expected = Arrays.asList(1036288l, 7l, 2l, 20l, 24l, 4048l, 1l, 4048l, 8096l, 28l, 67l, 60l, 32l);
        List<Long> outputs = Problem1.iterateStones(input, 5);

        assertEquals(expected.size(), outputs.size());
        for(int i = 0; i < expected.size(); i++){
            assertEquals(expected.get(i), outputs.get(i));
        }
     }
     @Test
     public void testIterateStones7(){
         String input = "125 17";
         List<Long> expected = Arrays.asList(2097446912l, 14168l, 4048l, 2l, 0l, 2l, 4l, 40l, 48l, 2024l, 40l, 48l, 80l, 96l, 2l, 8l, 6l, 7l, 6l, 0l, 3l, 2l);
         List<Long> outputs = Problem1.iterateStones(input, 6);
 
         assertEquals(expected.size(), outputs.size());
         for(int i = 0; i < expected.size(); i++){
             assertEquals(expected.get(i), outputs.get(i));
         }
      }
}
