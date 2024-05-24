package lld.snakeLadder;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;


    Board(int snakeCnt, int ladderCnt, int rowCnt) {
        cells = new Cell[rowCnt][rowCnt];
        for (int i = 0; i < rowCnt; i++) {
            for (int j = 0; j < rowCnt; j++) {
                cells[i][j] = new Cell();
            }
        }
        initializeJump(snakeCnt, ladderCnt);
    }

    private void initializeJump(int snakeCnt, int ladderCnt) {
        Set<Integer> st = new HashSet<>();
        while (ladderCnt > 0 || snakeCnt > 0) {

            int start = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
            int end = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

            if (!st.contains(start) && start > end && snakeCnt > 0) {
                st.add(start);
                Cell cell = getCell(start);
                cell.jump = new Jump(start, end, Type.SNAKE);
                System.out.println(STR."\{cell.jump.type} jump created from \{start} to \{end}");
                snakeCnt--;
            }
            if (!st.contains(start) && start < end && ladderCnt > 0) {
                st.add(start);
                Cell cell = getCell(start);
                cell.jump = new Jump(start, end, Type.LADDER);
                System.out.println(STR."\{cell.jump.type} jump created from \{start} to \{end}");
                ladderCnt--;
            }


        }

    }

    public Cell getCell(int position) {
        return cells[position / cells.length][position % cells.length];
    }
}
