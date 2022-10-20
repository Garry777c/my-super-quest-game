package app.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Model {

    private static Model instance = new Model();

    private final HashMap<Integer, List<String>> model;
    private int stepLevel = 1;
    private int count=0;

    public static Model getInstance() {
        if (instance==null) {
            instance = new Model();
        }
        return instance;
    }

    private Model() {
        model = new HashMap<>();
        model.put(1, new ArrayList<>(Arrays.asList("You have lost your memory. Do you accept UFO challenge?", "Accept challenge", "Decline challenge")));
        model.put(2, new ArrayList<>(Arrays.asList("You accepted the challenge. Do you want to go to the deck to see captain?", "Go to the deck", "Don't want to")));
        model.put(3, new ArrayList<>(Arrays.asList("You are at the deck. How are are? Tell true?", "Tell true", "Lie them")));
        model.put(4, new ArrayList<>(List.of("You have been returned home. Victory!")));
    }

    public HashMap<Integer, List<String>> getModel() {
        return model;
    }

    public int getStepLevel() {
        return stepLevel;
    }

    public int getCount() {
        return count;
    }

    public void zeroCount() {
        this.count = 0;
    }

    public void countPlus(){
        this.count++;
    }
}
