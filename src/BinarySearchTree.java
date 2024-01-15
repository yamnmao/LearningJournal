public class BinarySearchTree {
    private TreeNode root;
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }
//    public void insert(Node node){
//        private Node insertHelper(Node root,Node node){
//            return null;
//        }
//    }

    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();
        String myStr1="John";
        String myStr2="Mary";
        System.out.println(myStr1.compareTo(myStr2));
    }
}
