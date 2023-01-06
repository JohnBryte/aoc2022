package day07;

import java.util.ArrayList;
import java.util.List;

public class DirectoryNode {
    public String directoryName;
    public DirectoryNode parent;
    public List<DirectoryNode> children = new ArrayList<>();

    public long filesTotal = 0;

    public DirectoryNode(String name) {
        this.directoryName = name;
    }
}
