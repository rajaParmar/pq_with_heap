import java.util.*;
class node{
	public int data,priority;
	public node(int data,int priority){
		this.data=data;
		this.priority=priority;
	}
}


public class pq{

	public static void max_heapify(node nodes[],int parent_pos){
		int l=(parent_pos)*2;
		int r=(parent_pos)*2+1;
		int n=nodes.length;
		int largest=parent_pos;
		if( l<n && nodes[l].priority>nodes[parent_pos].priority)
			largest=l;
		if(r < n && nodes[r].priority>nodes[parent_pos].priority && nodes[r].priority > nodes[largest].priority)
			largest=r;

		if (largest!=parent_pos) {
			swap(nodes,largest,parent_pos);
			max_heapify(nodes,largest);
		}
	}
	public static node extract_max(node nodes[]){
		node temp=nodes[1];
		swap(nodes,1,nodes.length-1);
		
		//node new_nodes=Arrays.copyOf(nodes,nodes.length-1);
		nodes[nodes.length-1].priority=-1;
		max_heapify(nodes,1);
		return temp;
	}

	public static void swap(node nodes[],int p1,int p2){
		node temp=nodes[p1];
		nodes[p1]=nodes[p2];
		nodes[p2]=temp;
	}
	public static void build_max_heap(node nodes[]){
		for(int i=(nodes.length-1)/2;i>=1;i--)
			max_heapify(nodes,i);
	}

	public static void print_heap(node nodes[]){
		for(int i=1;i<=nodes.length-1;i++){
			System.out.print(nodes[i].data+" ");
		}
	}
	public static void main(String args[]){
		Scanner scr=new Scanner(System.in);
		int n;
		System.out.print("Number of nodes:");
		n=scr.nextInt();
		node nodes[]=new node[n+1];

		for(int i=1;i<=n;i++)
			nodes[i]=new node(scr.nextInt(),scr.nextInt());
			
		build_max_heap(nodes);
		
		System.out.println(extract_max(nodes).data);
		print_heap(nodes);
	}
}