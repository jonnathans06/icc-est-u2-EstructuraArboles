package materia.controller;

import materia.model.Node;

public class ArbolBinario {
    private Node root;

    public ArbolBinario() {
        this.root = null;
    }
    public void insert (int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }

        if (value < padre.getValue()){
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre; // Retorna porque el nodo padre no ha cambiado
    }

    public void imprimirArbolInorder () {
        imprimirRecInorder(root);
    }

    public void imprimirRecInorder(Node node) {
        if (node != null) {
            imprimirRecInorder(node.getLeft());
            System.out.print(node.getValue() + " ");
            imprimirRecInorder(node.getRight());
        }
    }

    public void imprimirArbolPreorder () {
        imprimirRecPreorder(root);
    }

    private void imprimirRecPreorder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            imprimirRecPreorder(node.getLeft());
            imprimirRecPreorder(node.getRight());
        }
    }

    public void imprimirArbolPostorder () {
        imprimirRecPostorder(root);
    }

    private void imprimirRecPostorder(Node node) {
        if (node != null) {
            imprimirRecPostorder(node.getLeft());
            imprimirRecPostorder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    public boolean buscar(int value) {
        return buscarRec(root, value);
    }

    private boolean buscarRec(Node root, int value) {
        if (root == null) {
            return false; // Si el nodo es nulo, el valor no está en el árbol
        }
        if (value == root.getValue()) {
            return true; // Si el valor coincide con el nodo actual, se encontró
        }
        if (value < root.getValue()) {
            return buscarRec(root.getLeft(), value); // Busca en el subárbol izquierdo
        } else {
            return buscarRec(root.getRight(), value); // Busca en el subárbol derecho
        }
    }
}
