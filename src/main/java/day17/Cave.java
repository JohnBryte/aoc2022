package day17;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class Cave {
    private static final byte[][] rockShapes = {
            {
                    0b0011110
            },
            {
                    0b0001000,
                    0b0011100,
                    0b0001000
            },
            {
                    0b0000100,
                    0b0000100,
                    0b0011100,
            },
            {
                    0b0010000,
                    0b0010000,
                    0b0010000,
                    0b0010000
            },
            {
                    0b0011000,
                    0b0011000
            }
    };


    private final String instructions;
    private final boolean debugMode;
    private final long rounds;
    private int currentRockShape = 0;
    private int currentInstructionIdx = 0;
    private byte[] cave = new byte[4096];
    private int topOfCave = 0;
    private int fullLine = -1;
    private long previousScore = 0;
    private Map<String, CaveState> map = new HashMap<>();

    private static Base64.Encoder encoder = Base64.getEncoder();

    public Cave(String instructions, boolean debugMode, long rounds) {
        this.instructions = instructions;
        this.debugMode = debugMode;
        this.rounds = rounds;
    }

    public long simulateRockFall() {

        for (long round = 0; round < rounds; round++) {
            CaveState state = checkForCycle(round);
            if (state != null) {
                final var cycleLength = round - state.getRounds();
                final var skippedCycles = (rounds - round) / cycleLength;
                round += cycleLength * skippedCycles;

                final var scoreCycle = previousScore + topOfCave - state.getScore();
                previousScore += scoreCycle * skippedCycles;
            }
            simulateRock();
            if (debugMode) {
                System.out.printf("== %d ==\n", round);
                printCave();
            }
        }
        return previousScore + topOfCave;
    }

    private CaveState checkForCycle(long round) {
        int len = topOfCave - (fullLine + 1);
        ByteBuffer byteBuffer = ByteBuffer.allocate(len + 8);
        byteBuffer.put(cave, fullLine + 1, len);
        byteBuffer.putInt(currentRockShape);
        byteBuffer.putInt(currentInstructionIdx);

        final var str = encoder.encodeToString(byteBuffer.array());

        final var previous = map.get(str);
        if (previous != null) {
            return previous;
        }
        map.put(str, new CaveState(round, previousScore + topOfCave));
        return null;
    }

    private void printCave() {
        for (int i = topOfCave - 1; i >= 0; i--) {
            System.out.println(
                    String.format("%7s", Integer.toBinaryString(cave[i]))
                            .replaceAll("[0\\s]", "·")
                            .replaceAll("1", "#"));
        }
    }

    private void simulateRock() {
        byte[] rock = Arrays.copyOf(rockShapes[currentRockShape], rockShapes[currentRockShape].length);
        currentRockShape = (currentRockShape + 1) % rockShapes.length;

        int start = topOfCave + 3;
        int currentPosition = start;

        while(true) {
            char instruction = instructions.charAt(currentInstructionIdx);
            currentInstructionIdx = (currentInstructionIdx + 1) % instructions.length();

            calculateMovement(instruction, rock, currentPosition);
            if (isPositionValid(rock, currentPosition - 1)) {
                currentPosition--;
            } else {
                break;
            }
        }
        if (placeRock(rock, currentPosition)) {
            previousScore += fullLine + 1;
            final var tempCave = new byte[cave.length];
            System.arraycopy(cave, fullLine + 1, tempCave, 0, cave.length - fullLine - 1);
            cave = tempCave;
            topOfCave -= (fullLine + 1);
            fullLine = -1;
        }
    }

    private boolean placeRock(byte[] rock, int lowestPointOfRock) {
        topOfCave = Integer.max(topOfCave, lowestPointOfRock + rock.length);
        boolean fullLineFound = false;
        for (int i = 0; i < rock.length; i++) {
            cave[lowestPointOfRock + i] |= rock[rock.length - i - 1];
            if (cave[lowestPointOfRock + i] == 0b1111111) {
//            if (i == 60) {
                fullLine = lowestPointOfRock + i;
                fullLineFound = true;
            }
        }
        return fullLineFound;
    }

    private boolean isPositionValid(byte[] rock, int currentPosition) {
        if (currentPosition < 0) {
            return false;
        } else {
            for (var i = 0; i < rock.length; i++) {
                int layerIdx = rock.length - i;
                if ((cave[currentPosition + i] & rock[layerIdx - 1]) != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private void calculateMovement(char instruction, byte[] rock, int currentPosition) {
        switch (instruction) {
            case '<':
                for (int i = 0; i < rock.length; i++) {
                    int layerIdx = rock.length - i;
                    if ((rock[layerIdx - 1] & 0b1000000) != 0) {
                        return;
                    }
                    // |0011110|
                    // |0000000|
                    if ((cave[currentPosition + i] & rock[layerIdx - 1] << 1) != 0) {
                        return;
                    }
                }
                for (int i = 0; i < rock.length; i++) {
                    rock[i] <<= 1;
                }
                break;
            case '>':
                for (int i = 0; i < rock.length; i++) {
                    int layerIdx = rock.length - i;
                    if ((rock[layerIdx - 1] & 0b0000001) != 0) {
                        return;
                    }
                    // |0011110|
                    // |0000000|
                    if ((cave[currentPosition + i] & rock[layerIdx - 1] >> 1) != 0) {
                        return;
                    }
                }
                for (int i = 0; i < rock.length; i++) {
                    rock[i] >>= 1;
                }
                break;
        }
    }
}
