import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LRU_swap {
    public static void algorithm(ArrayList<Integer> pages, Character[] frames){

        // frame "name", Page, When was Used
        Map<Character, Integer> inMemory = new HashMap< Character, Integer>();

        ArrayList<Character> fifo =new ArrayList<Character>();
        fifo.add(frames[0]);
        fifo.add(frames[1]);
        fifo.add(frames[2]);
        fifo.add(frames[3]);

        int errors = 0;
        boolean wasInMemory;

        inMemory.put(frames[0],0);
        inMemory.put(frames[1],0);
        inMemory.put(frames[2],0);
        inMemory.put(frames[3],0);

        for (Integer page: pages) {
            wasInMemory = false;
            // is in the memory?
            for (Character frame: inMemory.keySet()) {
                if(inMemory.get(frame).equals(page)){
                    // update the fifo
                    fifo.remove(frame);
                    fifo.add(frame);

                    System.out.print("-");
                    wasInMemory = true;
                }
            }

            if(!wasInMemory){
                errors++;

                // update the fifo
                Character useFrame = fifo.remove(0);
                fifo.add(useFrame);

                // update the page of frame
                for (Character c: inMemory.keySet()) {
                    if(c == useFrame){
                        inMemory.put(c, page);
                    }
                }

                System.out.print("" + useFrame);
            }
        }

        // print number of errors
        System.out.print("\n" + errors + "\n");

    }
}
