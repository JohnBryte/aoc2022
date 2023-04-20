package day16;

import utils.Day;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day16 extends Day {
    public final List<Valve> valves = new ArrayList<>();
    private Map<State, Integer> memoization = new HashMap<>();

    public Day16(List<String> input) {
        super(input);
        Pattern namePattern = Pattern.compile("([A-Z]{2})");
        Pattern flowPattern = Pattern.compile("\\d+");
        for (String line : input) {
            Matcher flowRate = flowPattern.matcher(line);
            flowRate.find();
            int flow = Integer.parseInt(flowRate.group());

            Matcher nameMatcher = namePattern.matcher(line);
            nameMatcher.find();
            String name = nameMatcher.group();
            Valve valve = new Valve(name, flow);
            while (nameMatcher.find()) {
                String neighbourName = nameMatcher.group();
                valve.addNeighbourName(neighbourName);
            }
            valves.add(valve);
        }
    }

    @Override
    public String solvePart1() {
        Valve start = valves.stream().filter(f -> f.getName().equals("AA")).findFirst()
                .orElseThrow(NoSuchElementException::new);
        memoization = new HashMap<>();
        return String.valueOf(calculatePressure(start, 30, new ArrayList<>(), valves, 0));
    }

    @Override
    public String solvePart2() {
        Valve start = valves.stream().filter(f -> f.getName().equals("AA")).findFirst()
                .orElseThrow(NoSuchElementException::new);
        memoization = new HashMap<>();
        return String.valueOf(calculatePressure(start, 26, new ArrayList<>(), valves, 1));

    }

    public int calculatePressure(Valve start, int minute, List<Valve> opened, List<Valve> valves, int nrOfOtherPlayers) {
        if (minute == 0) {
            Valve aa = valves.stream().filter(f -> f.getName().equals("AA")).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return nrOfOtherPlayers > 0 ? calculatePressure(aa, 26, opened, valves, nrOfOtherPlayers - 1) : 0;
        }

        State state = new State(start, minute, opened, nrOfOtherPlayers);
        if (memoization.containsKey(state)) {
            return memoization.get(state);
        }

        int max = 0;
        if (start.getFlowRate() > 0 && !opened.contains(start)) {
            opened.add(start);
            Collections.sort(opened);
            int val = (minute - 1) * start.getFlowRate()
                    + calculatePressure(start, minute - 1, opened, valves, nrOfOtherPlayers);
            opened.remove(start);
            max = val;
        }

        for (String n : start.getNeighbourNames()) {
            Valve neighbour = valves.stream().filter(v -> v.getName().equals(n)).findFirst()
                    .orElseThrow(NoSuchElementException::new);
            max = Math.max(max, calculatePressure(neighbour, minute - 1, opened, valves, nrOfOtherPlayers));
        }
        memoization.put(state, max);

        return max;

    }
}
