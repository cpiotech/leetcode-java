package com.cp.interview.graph;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by curry on 9/3/17.
 */
public class GolfTree {
    public static class Node {
        int row;
        int column;

        Node(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
    static int levelField(int numRows, int numColumns, List<List<Integer>> field) {

        //find the trees and sort by height
        List<Integer> trees = new ArrayList<>();
        field.forEach(row -> row.forEach(node -> {
                    if (node > 1) {
                        trees.add(node);
                    }
                }
        ));
        Collections.sort(trees);

        // prepare the arrays of field
        Integer[][] fields = new Integer[numRows][numColumns];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                fields[i][j] = field.get(i).get(j);
            }
        }

        int distance = 0;
        Node start = new Node(0, 0);
        for (Integer tree : trees) {
            if (distance == -1) {
                break;
            }
            distance = distance + findShortest(numRows, numColumns, fields, start, tree);
        }

        return distance;
    }

    private static int findShortest(int numRows, int numColumns, Integer[][] fields, Node start, Integer tree) {
        int[][] distances = new int[numRows][numColumns];
        distances[start.row][start.column] = 1;

        Queue<Node> queue = new LinkedList<>();

        List<Pair<Integer, Integer>> adjacencies = Arrays.asList(new Pair<>(1, 0), new Pair<>(-1, 0),
                new Pair<>(0, 1), new Pair<>(0, -1));

        queue.add(start);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (Pair<Integer, Integer> pair : adjacencies) {
                int newRow = now.row + pair.getKey().intValue();
                int newColumn = now.column + pair.getValue().intValue();
                if (newRow >= 0 && newColumn >= 0
                        && newRow < numRows && newColumn < numColumns
                        && fields[newRow][newColumn] > 0
                        && distances[newRow][newColumn] == 0) {
                    distances[newRow][newColumn] = distances[now.row][now.column] + 1;
                    if (fields[newRow][newColumn] > 1
                            && fields[newRow][newColumn] != tree) {
                        continue;
                    }
                    if (fields[newRow][newColumn] == tree) {
                        start.row = newRow;
                        start.column = newColumn;
                        return distances[newRow][newColumn] - 1;
                    }
                    queue.add(new Node(newRow, newColumn));
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> field = new ArrayList<>();
        field.add(Arrays.asList(1,1,1,2));
        field.add(Arrays.asList(3,1,1,1));
        System.out.println(levelField(2, 4, field));
    }
}
