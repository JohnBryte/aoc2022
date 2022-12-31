package day08;

import utils.Day;

import java.util.Arrays;
import java.util.List;

public class Day08 extends Day {
    public Day08(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        int count = 0;

        for (int row = 0; row < input.get(0).length(); row++) {
            for (int col = 0; col < input.size(); col++) {
                int tree = Integer.parseInt(String.valueOf(input.get(row).charAt(col)));
                boolean isVisibleFromRow = checkVisibilityFromRow(row, col, tree, input);
                boolean isVisibleFromCol = checkVisibilityFromCol(row, col, tree, input);
                if (isVisibleFromCol || isVisibleFromRow) {
                    count++;
                }
            }
        }

        return String.valueOf(count);
    }

    @Override
    public String solvePart2() {
        int max = 0;

        for (int row = 0; row < input.get(0).length(); row++) {
            for (int col = 0; col < input.size(); col++) {
                int tree = Integer.parseInt(String.valueOf(input.get(row).charAt(col)));

                int rowScore = checkScenicScoreFromRow(row, col, tree, input);
                int colscore = checkScenicScoreFromCol(row, col, tree, input);
                int target = rowScore * colscore;
                if (target >= max) {
                    max = target;
                }
            }
        }

        return String.valueOf(max);
    }

    private int checkScenicScoreFromCol(int row, int col, int tree, List<String> input) {
        int[] treeCol = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            treeCol[i] = Integer.parseInt(String.valueOf(input.get(i).charAt(col)));
        }
        int[] beforeTargetTree = Arrays.copyOfRange(treeCol, 0, row);
        int[] afterTargetTree = Arrays.copyOfRange(treeCol, row+1, treeCol.length);

        int beforeVisible = 0;
        for (int i = beforeTargetTree.length-1; i >= 0; i--) {
            if (beforeTargetTree[i] >= tree) {
                beforeVisible++;
                break;
            } else if (tree >= beforeTargetTree[i]) {
                beforeVisible++;
            } else {
                break;
            }
        }
        int afterVisible = 0;
        if (afterTargetTree.length > 0) {
            for (int j : afterTargetTree) {
                if (j >= tree) {
                    afterVisible++;
                    break;
                } else {
                    afterVisible++;
                }
            }
        }
        return beforeVisible * afterVisible;
    }

    private int checkScenicScoreFromRow(int row, int col, int tree, List<String> input) {
        int[] treeRow = Arrays.stream(input.get(row).split("")).mapToInt(Integer::parseInt).toArray();
        //split array where target tree is
        int[] beforeTargetTree = Arrays.copyOfRange(treeRow, 0, col);
        int[] afterTargetTree = Arrays.copyOfRange(treeRow, col+1, treeRow.length);
        int beforeVisible = 0;
        if (beforeTargetTree.length > 0) {
            for (int i = beforeTargetTree.length-1; i >= 0; i--) {
                if (beforeTargetTree[i] >= tree) {
                    beforeVisible++;
                    break;
                } else if (tree >= beforeTargetTree[i]) {
                    beforeVisible++;
                } else {
                    break;
                }
            }
        }
        int afterVisible = 0;
        if (afterTargetTree.length > 0) {
            for (int j : afterTargetTree) {
                if (j >= tree) {
                    afterVisible++;
                    break;
                } else {
                    afterVisible++;
                }
            }
        }
        return beforeVisible * afterVisible;
    }

    private boolean checkVisibilityFromRow(int row, int col, int tree, List<String> input) {
        int[] treeRow = Arrays.stream(input.get(row).split("")).mapToInt(Integer::parseInt).toArray();

        int[] beforeTargetTree = Arrays.copyOfRange(treeRow, 0, col);
        int[] afterTargetTree = Arrays.copyOfRange(treeRow, col+1, treeRow.length);
        if (beforeTargetTree.length == 0 || afterTargetTree.length == 0) {
            //is edge
            return true;
        }
        boolean beforeVisible = Arrays.stream(beforeTargetTree).allMatch(t -> t < tree);
        boolean afterVisible = Arrays.stream(afterTargetTree).allMatch(t -> t < tree);
        return beforeVisible || afterVisible;
    }

    private boolean checkVisibilityFromCol(int row, int col, int tree, List<String> input) {
        int[] treeCol = new int[input.size()];
        for (int i = 0; i < input.size(); i++) {
            treeCol[i] = Integer.parseInt(String.valueOf(input.get(i).charAt(col)));
        }


        int[] beforeTargetTree = Arrays.copyOfRange(treeCol, 0, row);
        int[] afterTargetTree = Arrays.copyOfRange(treeCol, row+1, treeCol.length);
        if (beforeTargetTree.length == 0 || afterTargetTree.length == 0) {
            //is edge
            return true;
        }
        boolean beforeVisible = Arrays.stream(beforeTargetTree).allMatch(t -> t < tree);
        boolean afterVisible = Arrays.stream(afterTargetTree).allMatch(t -> t < tree);
        return beforeVisible || afterVisible;
    }
}
