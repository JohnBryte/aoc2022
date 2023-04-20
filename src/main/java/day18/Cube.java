package day18;

public class Cube {
    private int front = 1;
    private int back = 1;
    private int up = 1;
    private int down = 1;
    private int left = 1;
    private int right = 1;

    private final int x;
    private final int y;
    private final int z;

    public Cube(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void checkEdges(Cube other) {
        if (other.getX() == this.x && other.getY() == this.y && other.getZ() != this.z) {
            if (this.z == other.getZ() - 1 ) {
                this.back = 0;
            } else if (this.z == other.getZ() + 1) {
                this.front = 0;
            }
        } else if(other.getX() != this.x && other.getY() == this.y && other.getZ() == this.z) {
            if (this.x == other.getX() - 1 ) {
                this.right = 0;
            } else if (this.x == other.getX() + 1) {
                this.left = 0;
            }
        } else if(other.getX() == this.x && other.getY() != this.y && other.getZ() == this.z) {
            if (this.y == other.getY() - 1 ) {
                this.up = 0;
            } else if (this.y == other.getY() + 1) {
                this.down = 0;
            }
        } else {
//            throw new IllegalArgumentException("FOO");
        }
    }

    public int getFreeEdges() {
        return front + back + down + up + left + right;
    }

    public Cube getFrontNeighbour() {
        return new Cube(this.x, this.y, this.z - 1);
    }

    public Cube getBackNeighbour() {
        return new Cube(this.x, this.y, this.z + 1);
    }

    public Cube getUpNeighbour() {
        return new Cube(this.x, this.y + 1, this.z);
    }

    public Cube getDownNeighbour() {
        return new Cube(this.x, this.y - 1, this.z);
    }

    public Cube getLeftNeighbour() {
        return new Cube(this.x - 1, this.y, this.z);
    }

    public Cube getRightNeighbour() {
        return new Cube(this.x + 1, this.y, this.z);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cube)) return false;

        Cube cube = (Cube) o;

        if (x != cube.x) return false;
        if (y != cube.y) return false;
        return z == cube.z;
    }

    @Override
    public int hashCode() {
        int result = front;
        result = 31 * result + back;
        result = 31 * result + up;
        result = 31 * result + down;
        result = 31 * result + left;
        result = 31 * result + right;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }
}
