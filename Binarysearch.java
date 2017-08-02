package hw6;
//Name:ChaitanyaThathireddy
//ID:14182
public class BST {

    private Node ROOT = null;
 public BST(int[] values) 
 {
     for(int i=0;i<values.length;i++)
     {
         insert(ROOT,new Node(values[i]));
     }
 }
private Node search(Node p,int q)
{
     if(p == null || q == p.data)
         return p;
     if(q < p.data)
         return search(p.left, q);
     else
         return search(p.right, q);        
 }
 private void insert(Node node, Node r)
 {
     Node n= null;
     Node s = node;
     while(s!=null)
     {
         n = s;
         if(r.data<s.data)
             s=s.left;
         else
             s = s.right;
     }
     r.parent = n;
     if(n == null)
         ROOT =r;
     else if(r.data<n.data)
         n.left = r;
     else
         n.right = r;
    
 }
 
 
 private Node successor(Node node)
 {
     if(node.right!=null)
         return mini(node.right);
     Node s = node.parent;
     while(s!=null && node ==s.right)
     {
         node=s;
         s = s.parent;
     }
     return s;
 }
 
 private Node mini(Node mini) 
 {
    while(mini.left!=null)
    {
        mini = mini.left;
    }
    return mini;
 }
 
 private void inorderTreeWalk(Node node)
 {
     if(node!=null)
     {
         inorderTreeWalk(node.left);
         System.out.print(node.data+" ");
         inorderTreeWalk(node.right);
     }
 }
 
 public static void main(String[] args) 
 {
     int[] array = {10, 15, 12, 7, 8, 5, 6, 9, 20, 18, 22} ;
     BST bst = new BST(array);
     System.out.print("Inorder tree walk : ");
     bst.inorderTreeWalk(bst.ROOT);
     Node min = bst.mini(bst.search(bst.ROOT, 10));
     System.out.println("\nMinimum from node 10 is "+min.data);
     Node s1 = bst.successor(bst.ROOT);
     Node s2 = bst.successor(bst.search(bst.ROOT, 9));
     System.out.println("Successor to the root node is "+s1.data);        
     System.out.println("Successor to the node with key=9 is "+s2.data);

	}

}
