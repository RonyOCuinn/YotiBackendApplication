package com.ronan.yotibackendtest;

import com.ronan.yotibackendtest.model.Input;
import com.ronan.yotibackendtest.model.Output;
import com.ronan.yotibackendtest.repository.InputRepository;
import com.ronan.yotibackendtest.repository.OutputRepository;
import com.ronan.yotibackendtest.service.CleanerService;
import com.ronan.yotibackendtest.service.PersistService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class YotibackendtestApplicationTests {

    @Autowired
    private CleanerService cleanerService;

    @Autowired
    private PersistService persistService;

    @Autowired
    private InputRepository inputRepository;

    @Autowired
    private OutputRepository outputRepository;

    @Test(expected = NullPointerException.class)
    public void testCleanerServiceWithNull(){
        cleanerService.start(null);
    }

    @Test
    public void testCoordinatesWithValidInput(){
        Input testInput = new Input();
        testInput.setRoomSize(new int[] {5, 5});
        testInput.setCoords(new int[] {1, 2});
        testInput.setPatches(new int[][] {{1,0}, {2,2}, {2,3}});
        testInput.setInstructions("NNESEESWNWW");

        Output output = cleanerService.start(testInput);
        int[] coords = output.getCoords();
        Assert.assertArrayEquals(coords, new int[] {1, 3});
    }

    @Test
    public void testPatchesWithValidInput(){
        Input testInput = new Input();
        testInput.setRoomSize(new int[] {5, 5});
        testInput.setCoords(new int[] {1, 2});
        testInput.setPatches(new int[][] {{1,0}, {2,2}, {2,3}});
        testInput.setInstructions("NNESEESWNWW");

        Output output = cleanerService.start(testInput);
        int patches = output.getPatches();
        Assert.assertEquals(patches, 1);
    }

    @Test
    public void testInputPersistence(){
        Input testInput = new Input();
        testInput.setRoomSize(new int[] {5, 5});
        testInput.setCoords(new int[] {1, 2});
        testInput.setPatches(new int[][] {{1,0}, {2,2}, {2,3}});
        testInput.setInstructions("NNESEESWNWW");

        persistService.persist(testInput);
        Iterable<Input> input = inputRepository.findAll();

        Assert.assertTrue(input.spliterator().getExactSizeIfKnown() > 0);
    }

    @Test
    public void testOutputPersistence(){
        Output testOutput = new Output(1, 1, 1);

        persistService.persist(testOutput);
        Iterable<Output> output = outputRepository.findAll();
        Assert.assertTrue(output.spliterator().getExactSizeIfKnown() > 0);
    }
}
