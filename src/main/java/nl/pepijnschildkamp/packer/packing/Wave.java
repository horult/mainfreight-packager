package nl.pepijnschildkamp.packer.packing;

import java.util.ArrayList;
import java.util.List;

public class Wave extends Item {

    private int stackHeight = 0;

    public List<Level> getLevels() {
        return levels;
    }

    private List<Level> levels = new ArrayList<>();

    public Wave(Dimension dimension) {
        super(dimension.getName(), dimension.getWidth(), dimension.getDepth(), dimension.getHeight());
    }

    public boolean add(Level element) {
        if (!levels.isEmpty()) {
            stackHeight += currentLevelStackHeight();
        }

        return levels.add(element);
    }

    public int getStackHeight() {
        return stackHeight + currentLevelStackHeight();
    }

    public int currentLevelStackHeight() {
        if (levels.isEmpty()) {
            return 0;
        }
        return levels.get(levels.size() - 1)
                .getHeight();
    }

    public void add(Placement placement) {
        levels.get(levels.size() - 1)
                .add(placement);
    }

    public void addLevel() {
        add(new Level());
    }

    public Dimension getFreeSpace() {
        int spaceHeight = height - getStackHeight();
        if (spaceHeight < 0) {
            throw new IllegalArgumentException("Remaining free space is negative at " + spaceHeight);
        }
        return new Dimension(width, depth, spaceHeight);
    }

    public void clear() {
        levels.clear();
        stackHeight = 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((levels == null) ? 0 : levels.hashCode());
        result = prime * result + stackHeight;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Wave other = (Wave) obj;
        if (levels == null) {
            if (other.levels != null)
                return false;
        } else if (!levels.equals(other.levels))
            return false;
        if (stackHeight != other.stackHeight)
            return false;
        return true;
    }
}