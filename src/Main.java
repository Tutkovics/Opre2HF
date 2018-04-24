import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> pages = new ArrayList();
        Character[] frames = {'A', 'B', 'C', 'D'};

        // get the pages in correct order
        Scanner sc = new Scanner(System.in).useDelimiter("[,\\s]");
        while(sc.hasNextInt()) {
            int i = sc.nextInt();

            pages.add(i);
        }

        FIFO_swap.algorithm(pages,frames);
        LRU_swap.algorithm(pages, frames);
        LRU_PL_swap.algorithm(pages, frames);
    }
}
