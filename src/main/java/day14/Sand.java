package day14;

import java.util.List;

public class Sand implements IMaterial {

    private List<Integer> position;
    private Integer sandNummber;

    public Sand(Integer sandNumber) {
        this.sandNummber = sandNumber;
    }

    public void setPosition(List<Integer> position) {
        this.position = position;
    }

    public Integer getSandNummber() {
        return sandNummber;
    }

    public void setSandNummber(Integer sandNummber) {
        this.sandNummber = sandNummber;
    }

    @Override
    public String drawMaterial() {
        return "o";
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
