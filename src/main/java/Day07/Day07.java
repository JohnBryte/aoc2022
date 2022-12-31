package Day07;

import utils.Day;

import java.util.ArrayList;
import java.util.List;

public class Day07 extends Day {
    private final DirectoryNode root = new DirectoryNode("root");

    public Day07(List<String> input) {
        super(input);
        DirectoryNode currentNode = root;
        for (String line : input) {
            if (line.split(" ")[1].equals("cd")) {
                if (line.equals("$ cd /")) {
                    currentNode = root;
                } else if (line.split(" ")[2].equals("..")) {
                    currentNode = currentNode.parent;
                } else {
                    // line = $ cd xyz
                    for (DirectoryNode node : currentNode.children) {
                        if (node.directoryName.equals(line.split(" ")[2])) {
                            currentNode = node;
                            break;
                        }
                    }
                }
            } else if (!line.split(" ")[1].equals("ls")) {
                // file or dir
                if (isNumeric(line.split(" ")[0])) {
                    currentNode.filesTotal += Long.parseLong(line.split(" ")[0]);
                } else {
                    DirectoryNode node = new DirectoryNode(line.split(" ")[1]);
                    node.parent = currentNode;
                    currentNode.children.add(node);
                }
            }
        }
    }

    private boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @Override
    public String solvePart1() {
        List<Long> directorySizes = getDirectorySizes();
        Long result = directorySizes.stream().filter(value -> value <= 100000).reduce(0L, Long::sum);

        return String.valueOf(result);
    }

    @Override
    public String solvePart2() {
        List<Long> directorySizes = getDirectorySizes();
        Long totalFileSIze = 70000000L;
        long availableSpace = totalFileSIze - (directorySizes.get(directorySizes.size()-1));
        Long spaceNeeded = 30000000 - availableSpace;
        return String.valueOf(directorySizes.stream().filter(value -> value >= spaceNeeded).min(Long::compareTo).orElse(-1L));
    }

    private List<Long> getDirectorySizes() {
        List<Long> directorySizes = new ArrayList<>();
        DirectoryNode dummyOuterDirectory = new DirectoryNode("Dummy");
        root.parent = dummyOuterDirectory;
        dummyOuterDirectory.children.add(root);
        for (DirectoryNode node : dummyOuterDirectory.children) {
            checkDirectories(node, directorySizes);
        }
        return directorySizes;
    }

    private Long checkDirectories(DirectoryNode node, List<Long> directorySizes) {
        long count = 0L;
        for (DirectoryNode child : node.children) {
            count += checkDirectories(child, directorySizes);
        }
        long filesTotal = node.filesTotal;
        directorySizes.add(filesTotal + count);
        return filesTotal + count;
    }
}
