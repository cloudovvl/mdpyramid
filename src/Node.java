class Node {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    public Node(String value){
        this.value = Integer.parseInt(value);
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public Node getLeft(){
        return left;
    }

    public void setLeft(Node value){
        this.left = value;
    }

    public Node getRight(){
        return right;
    }

    public void setRight(Node value){
        this.right = value;
    }

}