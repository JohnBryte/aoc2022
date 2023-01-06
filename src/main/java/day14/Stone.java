package day14;

import java.util.List;

public class Stone implements IMaterial {

    private List<Integer> position;

    public Stone() {}

    public Stone(List<Integer> position) {
        this.position = position;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

    @Override
    public String drawMaterial() {
        return "#";
    }

    @Override
    public List<Integer> getPosition() {
        return this.position;
    }

    @Override
    public int getX() {
        return this.position.get(0);
    }

    @Override
    public int getY() {
        return this.position.get(1);
    }
}
