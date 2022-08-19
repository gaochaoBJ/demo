package com.test.demo;

public class Test {

    public  static Integer gaochao = 1;
    public static Node generateBinaryTree(Node parent,int high){
        if(high < 0){
            return null;
        }
        try{
            Node leftChild = new Node();
            Node rightChild = new Node();
            System.out.println(high);
            parent.leftChild = generateBinaryTree(leftChild,--high);
            parent.rightChild = generateBinaryTree(rightChild,--high);
        }catch (Exception e){

        }

        return parent;
    }

    public static void generate(int high){
        if(high <= 0){
            System.out.println("tree high error");
        }
        Node parent = new Node();
        System.out.println(high);
        parent = generateBinaryTree(parent,high);
    }

    public static void main(String[] args) {
        generate(5);
    }
}
