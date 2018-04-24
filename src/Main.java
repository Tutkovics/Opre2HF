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
//        pages.add(1);
//        pages.add(2);
//        pages.add(3);
//        pages.add(4);
//        pages.add(1);
//        pages.add(5);
//        pages.add(6);

        FIFO_swap.algorithm(pages,frames);
        LRU_swap.algorithm(pages, frames);
        LRU_PL_swap.algorithm(pages, frames);

//        ArrayList<Integer> asd = new ArrayList<Integer>();
//
//        asd.add(1);
//        asd.add(2);
//        asd.add(3);
//        System.out.println("" + asd.remove(0) +asd.remove(0) + asd.remove(0));
    }
}
