package test;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://github.com/yaboong/datastructures-algorithms-study/blob/master/src/cc/yaboong/ds/tree/BinarySearchTree.java
 * Created by yaboong on 2017. 7. 29..
 *
 *         EXAMPLE
 *           50
 *         /    \
 *        25    75
 *       / \    / \
 *     15  30  70 85
 *    /\   / \
 *   2 18 26 32
 */
public class BinarySearchTree {
    private Node root;
    private class Node {
        int key;

        Node leftChild;
        Node rightChild;

        Node(int key) {
            this.key = key;
        }

        public String toString() {
            return "key:" + this.key;
        }
    }

    public Node getRoot() {
        return this.root;
    }

    public void addNode(int key) {
        if (findNode(key) != null) return;

        Node newNode = new Node(key);

        if (root == null) {
            root = newNode; // Ʈ���� ��������� root �� ����
        } else {
            Node focusNode = root;  //  Ž���� ���
            Node parent;            //  Ž���� ����� �θ� ���

            while(true) {
                parent = focusNode; //  �̵�

                if (key < parent.key) {             //  �����Ϸ��� Ű�� ���� ��庸�� ������
                    focusNode = parent.leftChild;   //  �������� �̵�

                    if (focusNode == null) {        //  ���� ��尡 ���������
                        parent.leftChild = newNode; //  ���� ��忡 ����
                        return;
                    }
                } else {                            //  �����Ϸ��� Ű�� ���� ��庸�� ũ�ٸ�
                    focusNode = parent.rightChild;  //  ���������� �̵�

                    if (focusNode == null) {        //  ������ ��尡 ���������
                        parent.rightChild = newNode;//  ������ ��忡 ����
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int key) {
        // focusNode �� parent �� ���� �� �ִ� ���� ã������ key �� root �� ���
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        // while ���� ������ ���� focusNode �� ������ ��带 ����Ű��, parent �� ������ ����� �θ��带 ����Ű�� �ǰ�, ������ ��尡 �θ����� left ���� right ������ ���� ������ ������ �ȴ�
        while(focusNode.key != key) {
            parent = focusNode;

            if(key < focusNode.key) {
                isLeftChild = true;             // ������� ��尡 ���ʿ� �ִ� ���� ��Ͽ�
                focusNode = parent.leftChild;
            } else {
                isLeftChild = false;            // ������� ��尡 �����ʿ� �ִ� ���� ��Ͽ�
                focusNode = parent.rightChild;
            }

            // ã������ ��尡 ���� ���
            if(focusNode == null) {
                return false;
            }
        }


        Node replacementNode;
        // ������� ����� �ڽ� ��尡 ���� ���
        if(focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }
        // ������� ����� ������ �ڽĳ�尡 ���� ��� (���� �ڽ� ��常 �ִ� ���)
        else if(focusNode.rightChild == null) {
            replacementNode = focusNode.leftChild;

            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;
        }
        // ������� ����� ���� �ڽĳ�尡 ���� ��� (������ �ڽ� ��常 �ִ� ���)
        else if (focusNode.leftChild == null) {
            replacementNode = focusNode.rightChild;
            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;
        }
        // ������� ����� ���� �ڽĳ�尡 ��� �ִ� ���
        // ������ �ڽ� ����� sub tree ���� ���� ���� ��带 ã�Ƽ� ������� ��尡 �ִ� �ڸ��� ��ġ��Ų��
        else {
            Node rightSubTree = focusNode.rightChild;                   // ������ ����� ������ sub tree �� �����صд�
            replacementNode = getRightMinNode(focusNode.rightChild);    // ������ ��� �ڸ��� ���� �� ���ο� ��� (������ sub tree ���� ���� ���� ���� ���� ���). �� ���� ���� child �� ����� �Ѵ� (���� ���� ���̱� ������)

            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;

            replacementNode.rightChild = rightSubTree;
            if (replacementNode == rightSubTree)                // ������� ����� ������ sub tree �� ��尡 �ϳ��ۿ� ���� ���
                replacementNode.rightChild = null;

            replacementNode.leftChild = focusNode.leftChild;    // ������� ����� ���� sub tree �� �����Ų��
        }

        return true;
    }

    private Node getRightMinNode(Node rightChildRoot) {
        Node parent = rightChildRoot;
        Node focusNode = rightChildRoot;

        while (focusNode.leftChild != null) {
            parent = focusNode;
            focusNode = focusNode.leftChild;
        }

        parent.leftChild = null;
        return focusNode;
    }

    public void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.leftChild);
            System.out.print(focusNode.key + " ");
            inOrderTraverse(focusNode.rightChild);
        }
    }

    public void preOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.key + " ");
            preOrderTraverse(focusNode.leftChild);
            preOrderTraverse(focusNode.rightChild);
        }
    }

    public void postOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverse(focusNode.leftChild);
            postOrderTraverse(focusNode.rightChild);
            System.out.print(focusNode.key + " ");
        }
    }

    public Node findNode(int key) {
        // Ʈ���� ����� ��
        if (root == null) return null;

        Node focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            // ã������ ��尡 ���� ��
            if (focusNode == null)
                return null;
        }

        return focusNode;
    }

    public void BFS()
    {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.key + " ");
            if (n.leftChild !=null)
                q.offer(n.leftChild);
            if (n.rightChild !=null)
                q.offer(n.rightChild);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bTree = new BinarySearchTree();

        /**
         *           50
         *         /    \
         *        25    75
         *       / \    / \
         *     15  30  70 85
         *    /\   / \
         *   2 18 26 32
         */
        // Adding nodes to the BinarySearchTree
        bTree.addNode(50);
        bTree.addNode(25);
        bTree.addNode(75);
        bTree.addNode(15);
        bTree.addNode(30);
        bTree.addNode(70);
        bTree.addNode(85);
        bTree.addNode(2);
        bTree.addNode(18);
        bTree.addNode(26);
        bTree.addNode(32);
        bTree.addNode(32);
        bTree.addNode(32);
        bTree.addNode(32);

        bTree.BFS();


        // Tree traversal
        System.out.println("---------- In Order Traversal ----------");
        bTree.inOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Pre Order Traversal ----------");
        bTree.preOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Post Order Traversal ----------");
        bTree.postOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Find Node ----------");
        Node found = bTree.findNode(25);
        System.out.println(found == null ? "not exists" : found);
        System.out.println("\n");

        // Deleting node
        System.out.println("---------- Delete Node Test ----------");
        bTree.deleteNode(15);
        bTree.BFS();
        System.out.println();
    }
}