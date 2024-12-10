package com.w3foxes.sarah.Year2023.Day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class CityGrid {
    private int[][] cityGrid;
    private int maxX;
    private int maxY;
    // How many blocks can we go before we have to change direction?
    private static final int changeDirectionBlocks = 2;

    CityGrid(List<String> lines) {
        maxX = lines.get(0).length();
        maxY = lines.size();
        cityGrid = new int[maxX][maxY];

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                cityGrid[j][i] = Integer.parseInt(line.substring(j, j + 1));
                //System.out.println("cityGrid[" + j + "][" + i + "] = " + cityGrid[j][i]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cityGrid[0].length; i++) {
            for (int j = 0; j < cityGrid.length; j++) {
                sb.append(cityGrid[j][i]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int findShortestPath() {
        HashMap<Node, Integer> unsettledNodes = new HashMap<>();
        TreeSet<Node> sortedNodes = new TreeSet<>();
        List<Node> settledNodes = new ArrayList<>();

        // Start out a 0,0
        Point start = new Point(0, 0);
        Point destination = new Point(maxX - 1, maxY - 1);
        Node startNode = new Node(start, Direction.START, 0, 0);
        unsettledNodes.put(startNode, 0);
        sortedNodes.add(startNode);

        while (sortedNodes.size() > 0) {
            // Get the node with the lowest distance from the unsettled list.
            Node current = getClosestUnsettledNode(sortedNodes);
            //System.out.println("Examining node: " + current);
            // Shortcut - is this the destination? Return that distance.
            // Maybe take out the shortcut
            if (current.point.equals(destination)) {
                return current.tempDistance;
            }

            // Otherwise -
            // Get the list of possible next points from this node
            List<Node> nextNodes = getNextSteps(current);

            // Go through each of these next points
            for (Node nextNode : nextNodes) {
                // Calculate the distance from this node to the next point.
                int distanceToNextPoint = current.tempDistance + cityGrid[nextNode.point.x][nextNode.point.y];
                nextNode.tempDistance = distanceToNextPoint;

                //System.out.println("Next node: " + nextNode);
                // If nextNode already exists in the settled list, do nothing more. We don't
                // reexamine settled nodes
                if (!settledNodes.contains(nextNode)) {
                    // If this node exists in the unsettled list, update the distance to it if it's
                    // less than the current temp distance
                    if (unsettledNodes.containsKey(nextNode)) {
                        int oldDistance = unsettledNodes.get(nextNode);
                        if (distanceToNextPoint < oldDistance) {
                            Node oldVersion = new Node(nextNode.point, nextNode.direction, nextNode.blocks, oldDistance);
                            sortedNodes.remove(oldVersion);
                            oldVersion.tempDistance = distanceToNextPoint;
                            sortedNodes.add(oldVersion);
                            //System.out.println("Updating distance");
                        }
                    }
                    // If it doesn't exist in the unsettled list, make it, using this distance.
                    else {
                        unsettledNodes.put(nextNode, distanceToNextPoint);
                        sortedNodes.add(nextNode);
                        //System.out.println("Adding to unsettled nodes");
                    }
                }
            }

            // Settle the current node - move it from unsettled to settled
            unsettledNodes.remove(current);
            sortedNodes.remove(current);
            settledNodes.add(current);
        }

        // We should have his the destination at some point - if we settle all the nodes
        // without having hit the destination, there is no path to it.
        // Check the settled nodes for the destination point
        // Find the shortest path of the ones that reach the destination
        int shortestDistance = Integer.MAX_VALUE;
        for (Node node : settledNodes) {
            if (node.point.equals(destination) && node.tempDistance < shortestDistance) {
                shortestDistance = node.tempDistance;
            }
        }

        return shortestDistance;
    }

    public Node getClosestUnsettledNode(TreeSet<Node> unsettledNodes) {
        return unsettledNodes.first();
    }

    // Path should contain the current point
    public List<Node> getNextSteps(Node currentNode) {
        // Next steps could either be up/down/left/right
        // But can't take more than 3 steps in a row in any one direction
        List<Node> nextSteps = new ArrayList<>();
        if (isValidStep(currentNode, Direction.RIGHT)) {
            nextSteps.add(buildNextStep(currentNode, Direction.RIGHT));
        }
        if (isValidStep(currentNode, Direction.LEFT)) {
            nextSteps.add(buildNextStep(currentNode, Direction.LEFT));
        }
        if (isValidStep(currentNode, Direction.DOWN)) {
            nextSteps.add(buildNextStep(currentNode, Direction.DOWN));
        }
        if (isValidStep(currentNode, Direction.UP)) {
            nextSteps.add(buildNextStep(currentNode, Direction.UP));
        }
        return nextSteps;
    }

    public Node buildNextStep(Node currentNode, Direction heading){
        int newX = currentNode.point.x + (heading == Direction.LEFT ? -1 : heading == Direction.RIGHT ? 1 : 0);
        int newY = currentNode.point.y + (heading == Direction.UP ? -1 : heading == Direction.DOWN ? 1 : 0);
        Point nextPoint = new Point(newX, newY);
        int newBlocks = 0;
        if(currentNode.direction == heading){
            newBlocks = currentNode.blocks + 1;
        }

        return new Node(nextPoint, heading, newBlocks, Integer.MAX_VALUE);
    }

    public boolean isValidStep(Node currentNode, Direction heading) {
        int possibleX = currentNode.point.x + (heading == Direction.LEFT ? -1 : heading == Direction.RIGHT ? 1 : 0);
        int possibleY = currentNode.point.y + (heading == Direction.UP ? -1 : heading == Direction.DOWN ? 1 : 0);

        // System.out.println("Checking " + possibleX + ", " + possibleY + " against
        // path: " + path);
        // Bounds check - x and y have to be on the grid
        if (possibleX < 0 || possibleX >= maxX) {
            // System.out.println("X invalid");
            return false;
        }
        if (possibleY < 0 || possibleY >= maxY) {
            // System.out.println("Y invalid");
            return false;
        }
        // Does this immediately double back on the path? Don't allow that
        // It's ok to hit the same point again, but can't reverse direction
        if(currentNode.isDoublingBack(heading)){
            // System.out.println("Doubling back");
            return false;
        }
        // If the proposed heading is the same as the current one, do we need to change direction?
        if(currentNode.direction == heading){
            return currentNode.blocks < changeDirectionBlocks;
        }

        // System.out.println("Ok");
        return true;
    }
}
