//import javax.swing.tree.TreeNode;

import sun.reflect.generics.tree.Tree;

import java.util.Random;

/**
 * Created by perilon on 9/27/15.
 */
public class Solution11 {

    public static void main(String[] args) {


        /*I'm trying to implement this solution based on the book's solution but the reason why it's not working is
        eluding me.  It has something to do with the flags?  I set a node "pig" with a value, but then when I add
        new nodes with that as the root, it doesn't register that "pig" has any value.  I wish I understood
        this better.*/

        TreeNode pig = new TreeNode(6);

        System.out.println(pig.value);

        pig.addANode(78);
        pig.addANode(90);
        pig.addANode(3);

        TreeNode random = pig.pickARandomNode();

        System.out.println(random.getValue());

    }


    static class TreeNode {
        public int value;
        public int sizeOfSubTree = 0;
        public TreeNode left;
        public TreeNode right;


        public TreeNode(int val) {
            int value = val;
            int sizeOfSubTree = 1;
        }

        public int getSizeOfSubTree() {
            return sizeOfSubTree;
        }

        public int getValue() {
            return value;
        }

        public void addANode(int newNodeValue) {

            if (newNodeValue <= value) {
                if (left == null) {
                    left = new TreeNode(newNodeValue);
                } else {
                    left.addANode(newNodeValue);
                }
            } else {
                if (right == null) {
                    right = new TreeNode(newNodeValue);
                } else {
                    right.addANode(newNodeValue);
                }
            }

            sizeOfSubTree++;
        }


        public TreeNode pickARandomNode() {
            int sizeOfLeftSubtree;
            if (left == null) {
                sizeOfLeftSubtree = 0;
            } else {
                sizeOfLeftSubtree = left.sizeOfSubTree;
            }

            Random random = new Random();
            int randomInt = random.nextInt(sizeOfSubTree);

            if (randomInt < sizeOfSubTree) {
                return left.pickARandomNode();
            } else if (randomInt == sizeOfSubTree) {
                return this;
            } else {
                return right.pickARandomNode();
            }
        }

    }



}