import java.util.Scanner;
import java.util.Vector;
 
class Node
{
    int             name; // node ID, started from 0 to n-1
    Vector<Integer> preds; // predecessors (String)
    Vector<Integer> neibs; // neighbors (String)
    Vector<Integer> backs; // backward edges -node is end vertex (Integer)
    Vector<Integer> fors; // forward edges -node is start vertex (Integer)
    int             pNode; // previous node on the augmenting path
    int             pEdge; // from which edge this node comes on the augmenting
                           // path
 
    public Node(int id)
    {
        name = id;
        backs = new Vector<Integer>();
        fors = new Vector<Integer>();
        pNode = -1;
        pEdge = -1;
    }
}
 
public class PathDAG
{
    int    n;                      
    int    dest;                 
    int    minLength;              
    Node[] v;                      
    Edge[] e;                      
    int[]  path;                   
    int    length       = 0;       
    int    distance     = 0;       
    int[]  optimPath;               
    int    optimLgth   = 0;       
    int    optimDstc = -1000000; 
    int[]  visited;                
 
    public PathDAG()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many of vertices: ");
        n = sc.nextInt();
        System.out.println("How many of edges: ");
        int m = sc.nextInt();
        v = new Node[n];
        e = new Edge[m];
        System.out.println(n + " nodes and " + m + " edges.");
        for (int i = 0; i < n; i++)
            v[i] = new Node(i);
        int i = 0;
        while (i < e.length)
        {
            Edge edge = new Edge(i);
            int sVal = sc.nextInt();
            edge.start = sVal;// sc.nextInt();
            int eVal = sc.nextInt();
            edge.end = eVal;// sc.nextInt();
            edge.capacity = sc.nextInt();
            System.out.println(" edge: " + edge.start + " - " + edge.end
                    + " : " + edge.capacity);
            edge.flow = 0;
            e[i] = edge;
            v[sVal].fors.add(i);
            v[eVal].backs.add(i);
            i++;
            if (i == m)
                break;
        }
        visited = new int[v.length];
        path = new int[v.length];
        optimPath = new int[v.length];
        sc.close();
    }
 
    public boolean findLongestPath(int begin, int end, int minLen)
    {
        dest = end;
        optimDstc = -100000000;
        minLength = minLen;
        dfsLongestPath(begin);
        if (optimDstc == -100000000)
            return false;
        else
            return true;
    }
 
    private void dfsLongestPath(int current)
    {
        visited[current] = 1;
        path[length++] = current;
        if (current == dest && length >= minLength)
        {
            if (distance > optimDstc)
            {
                for (int i = 0; i < length; i++)
                    optimPath[i] = path[i];
                optimLgth = length;
                optimDstc = distance;
            }
        }
        else
        {
            Vector<Integer> fors = v[current].fors;
            for (int i = 0; i < fors.size(); i++)
            {
                Integer edge_obj = (Integer) fors.elementAt(i);
                int edge = edge_obj.intValue();
                if (visited[e[edge].end] == 0)
                {
                    distance += e[edge].capacity;
                    dfsLongestPath(e[edge].end);
                    distance -= e[edge].capacity;
                }
            }
        }
        visited[current] = 0;
        length--;
    }
 

    public static void main(String arg[])
    {
        PathDAG lp = new PathDAG();
        
        if (lp.findLongestPath(0, lp.n - 1, 1))
            System.out.println("The Path is " + lp
                    + " The distance is " + lp.optimDstc);
        else
            System.out.println("No path from v0 to v" + (lp.n - 1));
        
        if (lp.findLongestPath(3, 5, 1))
            System.out.println("The Path is " + lp
                    + " The distance is " + lp.optimDstc);
        else
            System.out.println("No path from v3 to v5");
        
        if (lp.findLongestPath(lp.n - 1, 3, 1))
            System.out.println("The Path is " + lp
                    + " The distance is " + lp.optimDstc);
        else
            System.out.println("No path from v5 to v3");
    }
	
	public String toString()
    {
        String output = "v" + optimPath[0];
        for (int i = 1; i < optimLgth; i++)
            output = output + " -> v" + optimPath[i];
        return output;
    }
 
}

class Edge
{
    int name;    
    int start;   
    int end;     
    int direct;  
                 
    int capacity; 
    int flow;    
 
    public Edge(int id)
    {
        name = id;
        start = -1;
        end = -1;
        direct = 0; 
        capacity = 0;
        flow = 0;
    }
 
    public String toString()
    {
        return name + ": s=" + start + " e=" + end + " d=" + direct;
    }
}