package day13;

import utils.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day13 extends Day {
    List<Packet> allPackets = new ArrayList<>();
    public Day13(List<String> input) {
        super(input);
    }

    @Override
    public String solvePart1() {
        List<Integer> result = traversePackets();

        return String.valueOf(result.stream().mapToInt(val -> val).sum());
    }

    @Override
    public String solvePart2() {
        traversePackets();
        Packet two = new Packet();
        two.addToPacketList(new Packet(2));

        Packet six = new Packet();
        six.addToPacketList(new Packet(6));

        allPackets.add(two);
        allPackets.add(six);
        allPackets.sort(this::comparePackets);
        Collections.reverse(allPackets);
        int index = 1;
        List<Integer> resultP2 = new ArrayList<>();
        for (Packet packet : allPackets) {
            if (packet.getPacketList().size() == 1 && (packet.getPacketList().get(0).getValue() == 2 || packet.getPacketList().get(0).getValue() == 6)) {
                resultP2.add(index);
            }
            index++;
        }
        return String.valueOf(resultP2.stream().reduce(1, (a, b) -> a * b));
    }

    private List<Integer> traversePackets() {
        String leftSide = "";
        String rightSide = "";
        Packet leftPacket = new Packet();
        Packet rightPacket = new Packet();
//        List<Packet> allPackets = new ArrayList<>();
        int idx = 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).equals("")) {
                idx++;
                leftSide = "";
                rightSide = "";
                continue;
            }

            if (leftSide.equals("")) {
                leftSide = input.get(i);
                leftPacket = parsePacket(leftSide);
                allPackets.add(leftPacket);
            } else {
                rightSide = input.get(i);
                rightPacket = parsePacket(rightSide);
                allPackets.add(rightPacket);
            }
            if (!leftSide.equals("") && !rightSide.equals("")) {
                int compare = comparePackets(leftPacket, rightPacket);
                if (compare == 1) {
                    result.add(idx);
                }
            }
        }
        return result;
    }

    private int comparePackets(Packet leftPacket, Packet rightPacket) {
        int compareIdx = 0;
        while (compareIdx < leftPacket.getPacketList().size() || compareIdx < rightPacket.getPacketList().size()) {
            if (leftPacket.getPacketList().size() <= compareIdx) {
                return 1;
            }
            if (rightPacket.getPacketList().size() <= compareIdx) {
                return -1;
            }

            Packet leftCurrentPacket = leftPacket.getPacketList().get(compareIdx);
            Packet rightCurrentPacket = rightPacket.getPacketList().get(compareIdx);

            //only integer on right but list on left
            if (leftCurrentPacket.getPacketList().size() > 0 && rightCurrentPacket.getValue() != -1) {
                Packet dummy = new Packet();
                dummy.addToPacketList(rightCurrentPacket);
                int compare = comparePackets(leftCurrentPacket, dummy);
                if (compare == 0) {
                    compareIdx++;
                    continue;
                }
                return compare;
            }

            //only integer on left but list on right
            if (rightCurrentPacket.getPacketList().size() > 0 && leftCurrentPacket.getValue() != -1) {
                Packet dummy = new Packet();
                dummy.addToPacketList(leftCurrentPacket);
                int compare = comparePackets(dummy, rightCurrentPacket);
                if (compare == 0) {
                    compareIdx++;
                    continue;
                }
                return compare;
            }

            //both sides still have lists
            if (leftCurrentPacket.getValue() == -1 && rightCurrentPacket.getValue() == -1) {
                int compare = comparePackets(leftCurrentPacket, rightCurrentPacket);
                if (compare == 0) {
                    compareIdx++;
                    continue;
                }
                return compare;
            }

            if (leftCurrentPacket.getValue() < rightCurrentPacket.getValue()) {
                return 1;
            } else if (leftCurrentPacket.getValue() > rightCurrentPacket.getValue()) {
                return -1;
            }
            compareIdx++;
        }
        return 0;
    }

    private Packet parsePacket(String packetString) {
        int idx = 1;
        Packet outerPacket = new Packet();
        while (idx < packetString.length()) {
            // search for end of packetString
            if (packetString.charAt(idx) == '[') {
                int packetDepth = 1;
                int innerIdx = idx + 1;
                while (packetDepth > 0) {
                    if (packetString.charAt(innerIdx) == '[') {
                        packetDepth++;
                    } else if (packetString.charAt(innerIdx) == ']') {
                        packetDepth--;
                    }
                    innerIdx++;
                }
                outerPacket.addToPacketList(parsePacket(packetString.substring(idx, innerIdx)));
                idx = innerIdx;
            } else {
                int nextCommaIdx = packetString.indexOf(",", idx);
                if (nextCommaIdx == -1) {
                    nextCommaIdx = packetString.indexOf("]", idx);
                }
                String number = packetString.substring(idx, nextCommaIdx);
                Packet innerPacket = new Packet();
                try {
                    innerPacket.setValue(Integer.parseInt(number));
                    outerPacket.addToPacketList(innerPacket);

                } catch (NumberFormatException nfe) {
                    //empty packet - don't add as a sublist
                }
                idx = nextCommaIdx;
            }
            idx++;
        }
        return outerPacket;
    }
}
