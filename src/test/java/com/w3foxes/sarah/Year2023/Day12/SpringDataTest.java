package com.w3foxes.sarah.Year2023.Day12;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpringDataTest {
    @Test
    public void testSpringData1(){
        SpringData spring = new SpringData("???.### 1,1,3");

        assertEquals(1, spring.findNumberOfArrangements());
    }

    @Test
    public void testSpringData2(){
        SpringData spring = new SpringData(".??..??...?##. 1,1,3");

        assertEquals(16384, spring.findNumberOfArrangements());
    }

    @Test
    public void testSpringData3(){
        SpringData spring = new SpringData("?#?#?#?#?#?#?#? 1,3,1,6");

        assertEquals(1, spring.findNumberOfArrangements());
    }

    @Test
    public void testSpringData4(){
        SpringData spring = new SpringData("????.#...#... 4,1,1");

        assertEquals(16, spring.findNumberOfArrangements());
    }

    @Test
    public void testSpringData5(){
        SpringData spring = new SpringData("????.######..#####. 1,6,5");

        assertEquals(2500, spring.findNumberOfArrangements());
    }

    @Test
    public void testSpringData6(){
        SpringData spring = new SpringData("?###???????? 3,2,1");

        assertEquals(506250, spring.findNumberOfArrangements());
    }

    @Test
    public void testSummingSpringData() {
        List<SpringData> springList = new ArrayList<>();
        springList.add(new SpringData("???.### 1,1,3"));
        springList.add(new SpringData(".??..??...?##. 1,1,3"));
        springList.add(new SpringData("?#?#?#?#?#?#?#? 1,3,1,6"));
        springList.add(new SpringData("????.#...#... 4,1,1"));
        springList.add(new SpringData("????.######..#####. 1,6,5"));
        springList.add(new SpringData("?###???????? 3,2,1"));

        long sum = springList.stream().mapToLong(SpringData::findNumberOfArrangements).reduce(Long::sum).getAsLong();

        assertEquals(525152, sum);
    }
}
