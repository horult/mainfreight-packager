package nl.pepijnschildkamp.packer.packing;

public class Space extends Dimension {

    private transient Space parent;
    private transient Space remainder;

    protected int x;
    protected int y;
    protected int z;

    public Space() {
        super();
    }

    public void copyFrom(Space space) {
        parent = space.parent;
        x = space.x;
        y = space.y;
        z = space.z;

        width = space.width;
        depth = space.depth;
        height = space.height;
    }

    public void copyFrom(int w, int d, int h, int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

        width = w;
        depth = d;
        height = h;
    }

    public Space getParent() {
        return this.parent;
    }

    public Space getRemainder() {
        return this.remainder;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public void setParent(Space parent) {
        this.parent = parent;
    }

    public void setRemainder(Space remainder) {
        this.remainder = remainder;
    }
}
