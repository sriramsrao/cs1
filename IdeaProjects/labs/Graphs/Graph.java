
/******************************************************************************
 *
 *  Name:
 *
 *  Description: Undirected graph data type implemented using a symbol table
 *  whose keys are vertices (String) and whose values are sets
 *  of neighbors (SET of Strings).
 *
 *
 *  Remarks
 *  -------
 *   - Parallel edges are not allowed
 *   - Self-loop are allowed
 *   - Adjacency lists store many different copies of the same
 *     String. You can use less memory by interning the strings.
 *
 *  % java Graph < tinyGraph.txt
 *  A: B C G H
 *  B: A C H
 *  C: A B G
 *  G: A C
 *  H: A B
 *
 *  A: B C G H
 *  B: A C H
 *  C: A B G
 *  G: A C
 *  H: A B
 *
 ******************************************************************************/



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  The {@code Graph} class represents an undirected graph of vertices
 *  with string names.
 *  It supports the following operations: add an edge, add a vertex,
 *  get all of the vertices, iterate over all of the neighbors adjacent
 *  to a vertex, is there a vertex, is there an edge between two vertices.
 *  Self-loops are permitted; parallel edges are discarded.
 */
public class Graph {

  // symbol table: key = string vertex, value = set of neighboring vertices


  // number of edges
  private int E;

  /**
   * Initializes an empty graph with no vertices or edges.
   */
  public Graph() {
    // TODO: Initialize your Graph.
  }

  /**
   * Initializes a graph from the specified file, using the specified delimiter.
   *
   * @param filename the name of the file
   * @param delimiter the delimiter
   */
  public Graph(String filename, String delimiter) throws FileNotFoundException {
    this();
    Scanner in = new Scanner(new File(filename));
    while (in.hasNextLine()) {
      String line = in.nextLine();
      String[] names = line.split(delimiter);
      for (int i = 1; i < names.length; i++) {
        addEdge(names[0], names[i]);
      }
    }
  }

  /**
   * Returns the number of vertices in this graph.
   *
   * @return the number of vertices in this graph
   */
  public int V() {

  }

  /**
   * Returns the number of edges in this graph.
   *
   * @return the number of edges in this graph
   */
  public int E() {

  }

  // throw an exception if v is not a vertex
  private void validateVertex(String v) {
    if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
  }

  /**
   * Returns the degree of vertex v in this graph.
   *
   * @param  v the vertex
   * @return the degree of {@code v} in this graph
   * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
   */
  public int degree(String v) {
    validateVertex(v);
    // TODO: what is the degree?
    return ___;
  }

  /**
   * Adds the edge v-w to this graph (if it is not already an edge).
   *
   * @param  v one vertex in the edge
   * @param  w the other vertex in the edge
   */
  public void addEdge(String v, String w) {
    if (!hasVertex(v)) addVertex(v);
    if (!hasVertex(w)) addVertex(w);
    if (!hasEdge(v, w)) E++;
    // TODO: Add the edge to symbol table: add from v -> w and w -> v
  }

  /**
   * Adds vertex v to this graph (if it is not already a vertex).
   *
   * @param  v the vertex
   */
  public void addVertex(String v) {
    // TODO: fill me in
  }


  /**
   * Returns the vertices in this graph.
   *
   * @return the set of vertices in this graph
   */
  public Iterable<String> vertices() {
    // TODO: fill me in
    return ___;
  }

  /**
   * Returns the set of vertices adjacent to v in this graph.
   *
   * @param  v the vertex
   * @return the set of vertices adjacent to vertex {@code v} in this graph
   * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
   */
  public Iterable<String> adjacentTo(String v) {
    // TODO: fill me in
  }

  /**
   * Returns true if v is a vertex in this graph.
   *
   * @param  v the vertex
   * @return {@code true} if {@code v} is a vertex in this graph,
   *         {@code false} otherwise
   */
  public boolean hasVertex(String v) {
    // TODO: fill me in
  }

  /**
   * Returns true if v-w is an edge in this graph.
   *
   * @param  v one vertex in the edge
   * @param  w the other vertex in the edge
   * @return {@code true} if {@code v-w} is a vertex in this graph,
   *         {@code false} otherwise
   * @throws IllegalArgumentException if either {@code v} or {@code w}
   *         is not a vertex in this graph
   */
  public boolean hasEdge(String v, String w) {
    validateVertex(v);
    validateVertex(w);
    // TODO: fill me in

  }

  /**
   * Returns a string representation of this graph.
   *
   * @return string representation of this graph
   */
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (String v : st) {
      s.append(v + ": ");
      for (String w : st.get(v)) {
        s.append(w + " ");
      }
      s.append('\n');
    }
    return s.toString();
  }

  /**
   * Unit tests the {@code Graph} data type.
   */
  public static void main(String[] args) {

    // create graph
    Graph graph = new Graph();
    while (!StdIn.isEmpty()) {
      String v = StdIn.readString();
      String w = StdIn.readString();
      graph.addEdge(v, w);
    }

    // print out graph
    StdOut.println(graph);

    // print out graph again by iterating over vertices and edges
    for (String v : graph.vertices()) {
      StdOut.print(v + ": ");
      for (String w : graph.adjacentTo(v)) {
        StdOut.print(w + " ");
      }
      StdOut.println();
    }

  }

}
