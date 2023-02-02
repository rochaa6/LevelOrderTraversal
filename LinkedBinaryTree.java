/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 * 
 * @author Lewis and Chase
 * @version 4.0
 * 
 * Modified by Jiayin Wang for CSIT212 Lab 4
 */
import java.util.ArrayList;
import java.util.Iterator;


public class LinkedBinaryTree<T> implements BinaryTreeADT<T>
{
   protected int count;
   protected BinaryTreeNode<T> root; 

   /**
    * Creates an empty binary tree.
    */
   public LinkedBinaryTree() 
   {
      count = 0;
      root = null;
   }

   /**
    * Creates a binary tree with the specified element as its root.
    *
    * @param element the element that will become the root of the binary tree
    */
   public LinkedBinaryTree (T element) 
   {
      count = 1;
      root = new BinaryTreeNode<T> (element);
   }

   /**
    * Creates a binary tree with the specified element as its root and the 
    * given trees as its left child and right child
    *
    * @param element the element that will become the root of the binary tree
    * @param left the left subtree of this tree
    * @param right the right subtree of this tree
    */
   public LinkedBinaryTree (T element, LinkedBinaryTree<T> leftSubtree,
                            LinkedBinaryTree<T> rightSubtree) 
   {
      root = new BinaryTreeNode<T> (element);
      count = 1;
      
      if (leftSubtree != null)
      {
         count = count + leftSubtree.size();
         root.left = leftSubtree.root;
      }
      else
         root.left = null;
      
      if (rightSubtree !=null)
      {
         count = count + rightSubtree.size();
         root.right = rightSubtree.root;
      }
      else
         root.right = null;
   }
   
   /**
    * Returns a reference to the node at the root
    *
    * @return a reference to the specified node
    * @throws EmptyCollectionException if the tree is empty
    */
   public BinaryTreeNode<T> getRootNode(){
	   return root;
   }
   
   /**
    * Removes the left subtree of this binary tree.
    */
   public void removeLeftSubtree() 
   {
      if (root.left != null)
         count = count - root.left.numChildren() - 1;
      root.left = null;
   }
   
   /**
    * Removes the right subtree of this binary tree.
    */
   public void removeRightSubtree() 
   {

   }
   
   /**
    * Removes all elements of this binary tree.
    */
   public void removeAllElements() 
   {
   }
   
   /**
    * Returns true if this binary tree is empty and false otherwise.
    *
    * @return true if this binary tree is empty, false otherwise
    */
   public boolean isEmpty() 
   {
	   return count != 0;
   }

   /**
    * Returns the integer size of this tree.
    *
    * @return the integer size of the tree
    */
   public int size() 
   {
	   return count;
   }
   
   /**
    * Returns true if this tree contains an element that matches the
    * specified target element and false otherwise.
    *
    * @param targetElement the element being sought in this tree
    * @return true if the element in is this tree, false otherwise
    */
   public boolean contains (T targetElement) 
   {
	   return false;
   }

    /**
    * Returns a reference to the specified target element if it is
    * found in this binary tree.
    *
    * @return a reference to the specified target
    * @throws ElementNotFoundException if the element is not in the tree
    */

    /**
    * Returns a reference to the specified target element if it is
    * found in this binary tree.
    *
    * @param targetElement the element being sought in this tree
    * @return a reference to the specified target
    * @throws ElementNotFoundException if the element is not in the tree
    */
   public T find(T targetElement)
   {
      BinaryTreeNode<T> current = findNode( targetElement, root );
      if (current != null)
        return (current.element);
      return null;
   }
   
   /**
    * Returns a reference to the node of specified target element if it is
    * found in this binary tree.
    *
    * @param targetElement the element being sought in this tree
    * @param next the element to begin searching from
    */
   private BinaryTreeNode<T> findNode(T targetElement, 
                                       BinaryTreeNode<T> next)
   {
      if (next == null)
         return null;
      
      if (next.element.equals(targetElement))
         return next;
      
      BinaryTreeNode<T> temp = findNode(targetElement, next.left);
      
      if (temp == null)
         temp = findNode(targetElement, next.right);
      
      return temp;
   }
   
   /**
    * Returns a string representation of this binary tree showing
    * the nodes in an inorder fashion.
    *
    * @return a string representation of this binary tree
    */
   public String toString() 
   {
     return "NYI";
   }

   /**
    * Performs an inorder traversal on this binary tree by calling an
    * overloaded, recursive inorder method that starts with
    * the root.
    *
    * @return an in order iterator over this binary tree
    */
   public Iterator<T> iteratorInOrder()
   {
       ArrayList<T> list = new ArrayList<T>();
       inOrder(root, list);
       
       return list.iterator();
   }

   /**
    * Performs a recursive inorder traversal.
    *
    * @param node the node to be used as the root for this traversal
    * @param tempList the temporary list for use in this traversal
    */
   protected void inOrder(BinaryTreeNode<T> node, 
                          ArrayList<T> list) 
   {
       if (node != null)
       {
           inOrder(node.getLeft(), list);
           list.add(node.getElement());
           inOrder(node.getRight(), list);
       }
   }


   /**
    * Performs an preorder traversal on this binary tree by calling 
    * an overloaded, recursive preorder method that starts with
    * the root.
    *
    * @return a pre order iterator over this tree
    */
   public Iterator<T> iteratorPreOrder() 
   {
	   return null;
   }	

   /**
    * Performs an postorder traversal on this binary tree by calling
    * an overloaded, recursive postorder method that starts
    * with the root.
    *
    * @return a post order iterator over this tree
    */
   public Iterator<T> iteratorPostOrder() 
   {
	   return null;
   }

   /**
    * Performs a levelorder traversal on this binary tree, using a
    * templist.
    *
    * @return a levelorder iterator over this binary tree
    */
   public Iterator<T> iteratorLevelOrder() 
   {
      ArrayList<T> results = new ArrayList<T>();
      LinkedQueue<BinaryTreeNode<T>> nodes = new LinkedQueue<BinaryTreeNode<T>>();
      nodes.enqueue(root);
      
         while (!nodes.isEmpty()) {
            BinaryTreeNode<T> node = nodes.dequeue();
         
         if (node != null) {
            results.add(node.getElement());
            nodes.enqueue(node.getLeft());
            nodes.enqueue(node.getRight());
         } 
         else {
            results.add(null);
         }
         }
         return results.iterator();
   }

 public void rotateRight()
    {
        BinaryTreeNode<T> newRoot = root.getLeftChild();
        BinaryTreeNode<T> tempLeftRight = newRoot.getRightChild();
        newRoot.setRightChild(root);
        root.setLeftChild(tempLeftRight);
        root = newRoot;
    }

    public void rotateLeft()
    {
        BinaryTreeNode<T> newRoot = root.getRightChild();
        BinaryTreeNode<T> tempLeftRight = newRoot.getLeftChild();
        newRoot.setLeftChild(root);
        root.setRightChild(tempLeftRight);
        root = newRoot;
    }
}