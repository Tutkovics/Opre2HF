import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LRU_PL_swap {
    public static void algorithm(ArrayList<Integer> pages, Character[] frames){
        int errors = 0;
        boolean wasInMemory;

        // frame "name", Page, When was Used
        Map<Character, Integer> locks = new HashMap< Character, Integer>();
        locks.put(frames[0],0);
        locks.put(frames[1],0);
        locks.put(frames[2],0);
        locks.put(frames[3],0);

        ArrayList<Character> fifo = new ArrayList<Character>();
        fifo.add(frames[0]);
        fifo.add(frames[1]);
        fifo.add(frames[2]);
        fifo.add(frames[3]);



        Map<Character, Integer> inMemory = new HashMap< Character, Integer>();
        inMemory.put(frames[0],0);
        inMemory.put(frames[1],0);
        inMemory.put(frames[2],0);
        inMemory.put(frames[3],0);

        for (Integer page: pages) {
            //step down all lock number
            for (Character c: locks.keySet()) {
                locks.put(c, locks.get(c)-1);
            }


            wasInMemory = false;
            // is in the memory?
            for (Character frame: inMemory.keySet()) {
                if(inMemory.get(frame).equals(page)){
                    // update the fifo
                    fifo.remove(frame);
                    fifo.add(frame);

                    //remove lock
                    locks.put(frame, 0);

                    System.out.print("-");
                    wasInMemory = true;
                }
            }

            if(!wasInMemory){
                boolean success = false;
                errors++;

                // update the fifo
                Character useFrame = fifo.get(0);


                for(Character c: locks.keySet()){
                    // there isn't lock
                    if(c.equals(useFrame) && locks.get(c) <= 0){
                        fifo.remove(0);
                        fifo.add(useFrame);

                        // update the page of frame
                        for (Character key: inMemory.keySet()) {
                            if(key == useFrame){
                                inMemory.put(key, page);
                            }
                        }

                        success = true;

                        System.out.print("" + useFrame);
                    }
                }

                if(!success){
                    System.out.print("*");
                }
            }
        }

        // print number of errors
        System.out.print("\n" + errors + "\n");

    }

}
