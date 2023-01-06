package day13;

import java.util.ArrayList;
import java.util.List;

public class Packet {

    private List<Packet> packetList = new ArrayList<>();
    private int value = - 1;

    public Packet() {}
    public Packet (int value) {
        this.value = value;
    }

    public void addToPacketList(Packet item) {
        packetList.add(item);
    }

    public List<Packet> getPacketList() {
        return packetList;
    }

    public void setPacketList(List<Packet> packetList) {
        this.packetList = packetList;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
