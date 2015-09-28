//import javax.swing.tree.TreeNode;

/**
 * Created by perilon on 9/27/15.
 */
public class Solution02 {

    public static void main(String[] args) {

        int[] Pig = {1, 5, 7, 8, 18, 155, 199, 209, 2000, 2888, 30009, 30010};

        TreeNode pig = makeMinHeightBST(Pig);

        /*Proof of concept.*/

        System.out.println(pig.value);
        System.out.println(pig.left.value);
        System.out.println(pig.right.value);

    }

    /*This method is for the base case of the recursive call, where the only input is the array, as stipulated.*/

    public static TreeNode makeMinHeightBST(int array[]) {
        return makeMinHeightBST(array, 0, array.length - 1);
    }

    /*This is for the non–base cases, which at first takes in the array and the indices of its first and last elements,
    and for subsequent calls passes itself the indices for the first and last elements of whichever half (left or
    right it's working on splitting.)*/

    public static TreeNode makeMinHeightBST(int array[], int arrayBeginIndex, int arrayEndIndex) {

        /*This catches the case when the tree is winnowed down as far as it can go.*/

        if (arrayEndIndex < arrayBeginIndex) {
            return null;
        }

        /*This operates similarly to binary search…*/

        int midpoint = (arrayBeginIndex + arrayEndIndex) / 2;

        TreeNode newNode = new TreeNode(array[midpoint]);

        newNode.value = array[midpoint];
        newNode.left = makeMinHeightBST(array, arrayBeginIndex, midpoint - 1);
        newNode.right = makeMinHeightBST(array, midpoint + 1, arrayEndIndex);

        return newNode;

    }

    /*Create a class for TreeNode that has "left" and "right" elements, and two constructors, one that sets L and R and
    a value, and one that just sets a value.*/

    static class TreeNode<T> {
        public T value;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T val, TreeNode L, TreeNode R) {
            TreeNode left = L;
            TreeNode right = R;
            T value = val;
        }

        public TreeNode(T val) {
            TreeNode left;
            TreeNode right;
            T value = val;
        }

    }



}