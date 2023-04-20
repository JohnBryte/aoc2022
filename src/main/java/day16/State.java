package day16;

import java.util.List;
import java.util.Objects;

public class State {
    private Valve valve;
    private int minute;
    private List<Valve> openValves;
    private int nrOfOtherPlayers;

    public State(Valve valve, int minute, List<Valve> openValves, int nrOfOtherPlayers) {
        this.valve = valve;
        this.minute = minute;
        this.openValves = openValves;
        this.nrOfOtherPlayers = nrOfOtherPlayers;
    }

    public Valve getValve() {
        return valve;
    }

    public void setValve(Valve valve) {
        this.valve = valve;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public List<Valve> getOpenValves() {
        return openValves;
    }

    public void setOpenValves(List<Valve> openValves) {
        this.openValves = openValves;
    }

    public int getNrOfOtherPlayers() {
        return nrOfOtherPlayers;
    }

    public void setNrOfOtherPlayers(int nrOfOtherPlayers) {
        this.nrOfOtherPlayers = nrOfOtherPlayers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return minute == state.minute && nrOfOtherPlayers == state.nrOfOtherPlayers && Objects.equals(valve, state.valve) && Objects.equals(openValves, state.openValves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valve, minute, openValves, nrOfOtherPlayers);
    }
}
