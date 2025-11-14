import java.util.Iterator;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Test 1: Create a BST with integers using natural ordering
        System.out.println("=== Test 1: Basic Integer BST ===");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        
        // Add elements
        System.out.println("Adding elements: 50, 30, 70, 20, 40, 60, 80");
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(60);
        bst.add(80);
        
        // Test basic properties
        System.out.println("Size: " + bst.size());
        System.out.println("Is Empty: " + bst.isEmpty());
        System.out.println("Min: " + bst.min());
        System.out.println("Max: " + bst.max());
        System.out.println("Is Balanced: " + bst.isBalanced());
        System.out.println();
        
        // Test contains
        System.out.println("=== Test 2: Contains ===");
        System.out.println("Contains 40: " + bst.contains(40));
        System.out.println("Contains 100: " + bst.contains(100));
        System.out.println();
        
        // Test get
        System.out.println("=== Test 3: Get ===");
        System.out.println("Get 60: " + bst.get(60));
        System.out.println("Get 99: " + bst.get(99));
        System.out.println();
        
        // Test traversals
        System.out.println("=== Test 4: Traversals ===");
        
        System.out.print("Inorder (should be sorted): ");
    Iterator<Integer> inorder = bst.getIterator(BSTInterface.Traversal.InOrder);
        while(inorder.hasNext()){
            System.out.print(inorder.next() + " ");
        }
        System.out.println();
        
        System.out.print("Preorder: ");
    Iterator<Integer> preorder = bst.getIterator(BSTInterface.Traversal.PreOrder);
        while(preorder.hasNext()){
            System.out.print(preorder.next() + " ");
        }
        System.out.println();
        
        System.out.print("Postorder: ");
    Iterator<Integer> postorder = bst.getIterator(BSTInterface.Traversal.PostOrder);
        while(postorder.hasNext()){
            System.out.print(postorder.next() + " ");
        }
        System.out.println("\n");

        // Test remove
        System.out.println("=== Test 5: Remove ===");
        System.out.println("Removing 20 (leaf node): " + bst.remove(20));
        System.out.println("Size after removal: " + bst.size());
        
        System.out.println("Removing 30 (node with two children): " + bst.remove(30));
        System.out.println("Size after removal: " + bst.size());
        
        System.out.println("Removing 100 (non-existent): " + bst.remove(100));
        System.out.println("Size after removal: " + bst.size());
        
        System.out.print("Inorder after removals: ");
        Iterator<Integer> afterRemove = bst.iterator();
        while(afterRemove.hasNext()){
            System.out.print(afterRemove.next() + " ");
        }
        System.out.println("\n");


        // New Stuff I Added

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------- Testing all the new stuff I had to implement ---------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("\n");


        System.out.println("Testing minValue: " + bst.minValue());
        System.out.println("Testing max depth: " + bst.maxDepth());
        bst.add(90);
        System.out.println("Testing max depth after adding an element/node: " + bst.maxDepth());


        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
        bst2.add(2);
        bst2.add(1);
        bst2.add(3);

        System.out.print("\nBefore doubleTree: ");
        printPostOrder(bst2);

        bst2.doubleTree();

        System.out.print("After doubleTree: ");
        printPostOrder(bst2);


        boolean test = bst.sameTree(bst2);
        if (test == true)
        {
            System.out.println("Both trees are equal:");
        }
        else
        {
            System.out.println("Trees are not equal:");
        }

        System.out.print("Tree 1: ");
        printInOrder(bst);
        System.out.print("Tree 2: ");
        printInOrder(bst2);


        BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();
        bst3.add(2);
        bst3.add(1);
        bst3.add(3);

        bst3.doubleTree();

        test = bst2.sameTree(bst3);
        
        System.out.println();

        if (test == true)
        {
            System.out.println("Both trees are equal:");
        }
        else
        {
            System.out.println("Trees are not equal:");
        }

        System.out.print("Tree 2: ");
        printInOrder(bst2);
        System.out.print("Tree 3: ");
        printInOrder(bst3);

    }


    // This is here to print out the entries/elements in each tree without typing this every time.

    public static void printInOrder(BinarySearchTree<Integer> bst)
    {
        System.out.print("Inorder (should be sorted): ");
        Iterator<Integer> inorder = bst.getIterator(BSTInterface.Traversal.InOrder);
        while(inorder.hasNext()){
            System.out.print(inorder.next() + " ");
        }
        System.out.println();
    }

    public static void printPostOrder(BinarySearchTree<Integer> bst)
    {
        System.out.print("Postorder: ");
        Iterator<Integer> postorder = bst.getIterator(BSTInterface.Traversal.PostOrder);
        while(postorder.hasNext()){
            System.out.print(postorder.next() + " ");
        }
        System.out.println("\n");
    }

}
