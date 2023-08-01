import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ShortestPathAlgorithm 
{
    public static void main(String[] args) 
    {
        try {
            // Getting file input
            Scanner FileInput = new Scanner(System.in);

            System.out.print("Enter file name: ");
            File file = new File(FileInput.nextLine());
            Scanner Input = new Scanner(file);
            
            // Getting the number of vertices and edges from the input
            int Vertices = Input.nextInt();
            int Edges = Input.nextInt();

            System.out.println("Total number of Vertices: " + Vertices);
            System.out.println("Total number of Edges: " + Edges);

            // Array of vertices
            Vertex[] VertexArray = new Vertex[Vertices];
            
            // Looping through each vertex (each line in the input file) and storing them in the array of vertices
            for (int i = 0; i < Vertices; i++) 
            {
                VertexArray[i] = new Vertex(Input.nextInt(),Input.nextDouble(),Input.nextDouble());
            }

            // Matrix holding edges connecting to each vertex
            double EdgeMatrix[][] = new double[Vertices + 1][Vertices + 1];

            // Adding each edge to the edge matrix
            for (int i = 0; i < Edges; i++) 
            {
                int fV = Input.nextInt();
                int tV = Input.nextInt();
                double w = Input.nextDouble();
                EdgeMatrix[fV][tV] = w;
            }

            // Setting start vertex and goal vertex
            int startVertex = Input.nextInt();
            int goalVertex = Input.nextInt();

            System.out.println("\nStart Vertex: " + startVertex);
            System.out.println("Goal Vertex: " + goalVertex);

            System.out.println("\nEuclidean Distance between Start Vertex and Goal Vertex: ");
            findEuclideanDistance(startVertex, goalVertex, VertexArray);
            
            // Path Tree
            int[][] PathTree = new int[Vertices + 1][2];

            // Calculating and printing the shortest path
            System.out.println("Shortest Path:");
            calcShortestPath(EdgeMatrix, startVertex, Vertices + 1, goalVertex, PathTree);
            System.out.println("\n");

            // Getting the longest path
            int nVertex = goalVertex;
            while(PathTree[nVertex][0] != -1)
            {
                EdgeMatrix[PathTree[nVertex][0]][nVertex] = Double.MAX_VALUE;
                nVertex = PathTree[nVertex][0];
            }
            
            // Calculating and printing the longest path
            System.out.println("Longest Path: ");
            calcShortestPath(EdgeMatrix, startVertex, Vertices + 1, goalVertex, PathTree);

            FileInput.close();
            Input.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void calcShortestPath(double[][] EdgeMatrix, int startVertex, int Vertices, int goalVertex, int[][] PathTree) 
    {
        double[] shortestDistance = new double[Vertices];

        boolean[] pathsToAdd = new boolean[Vertices];

        for (int i = 1; i < Vertices; i++)
        {
            shortestDistance[i] = Double.MAX_VALUE;
            pathsToAdd[i] = false;
        }
        
        shortestDistance[startVertex] = 0;
       
        PathTree[startVertex][0] = -1;
        PathTree[startVertex][1] = 0;

        // Each vertex
        for (int i = 1; i < Vertices; i++)
        {
            int nextVertex = -1;
            double ShortDist = Double.MAX_VALUE;

            // Checking if not adding current path
            for(int j = 1; j < Vertices; j++)
            {
                if(!pathsToAdd[j] && shortestDistance[j] < ShortDist)
                {
                    nextVertex = j;
                    ShortDist = shortestDistance[j];
                }
            }

            pathsToAdd[nextVertex] = true;
            PathTree[i][1] = PathTree[nextVertex][1] + 1;

            // Each vertex
            for (int j = 1; j < Vertices; j++) 
            {
                double EdgeDist = EdgeMatrix[nextVertex][j];

                // Changing shortest distance
                if (EdgeDist > 0 && ((ShortDist + EdgeDist) < shortestDistance[j])) 
                {
                    PathTree[j][0] = nextVertex;
                    PathTree[j][1] = PathTree[nextVertex][1] + 1;
                    shortestDistance[j] = ShortDist + EdgeDist;
                }
            }
        }

        // Output
        System.out.print("Path from " + startVertex + " to " + goalVertex + ": Start --> ");
        printPath(goalVertex, PathTree);
        System.out.println("End");

        System.out.print("Distance = " + shortestDistance[goalVertex]);
    }

    private static void printPath(int nVertex, int[][] PathTree) 
    {
        // Exit recursion
        if (nVertex == -1) 
        {
            return;
        }

        printPath(PathTree[nVertex][0], PathTree);
        System.out.print(nVertex + " --> ");
    }

    private static void findEuclideanDistance(int startVertex, int goalVertex, Vertex[] Vertices) 
    {
        double xStart = 0.0;
        double yStart = 0.0;
        double xEnd = 0.0;
        double yEnd = 0.0;

        // Each vertex
        for( int i = 0; i < Vertices.length; i++)
        {
            if(startVertex == Vertices[i].VertexCount)
            {
                xStart = Vertices[i].XCoord;
                yStart = Vertices[i].YCoord;
            }

            if(goalVertex == Vertices[i].VertexCount) {
                xEnd = Vertices[i].XCoord;
                yEnd = Vertices[i].YCoord;
            }
        }

        System.out.println("Formula: √[(" + xEnd + " - " + xStart + ")²" + " + (" + yEnd + " - " + yStart + ")²]");
        System.out.println("Result: " +Math.sqrt(Math.pow((xEnd - xStart), 2) + Math.pow((yEnd - yStart), 2)) + "\n");
    }

    static class Vertex 
    {
        double XCoord;
        double YCoord;
        int VertexCount;

        public Vertex(int VertexCount, double XCoord, double YCoord) 
        {
            this.XCoord = XCoord;
            this.YCoord = YCoord;
            this.VertexCount = VertexCount;
        }
    }
}
