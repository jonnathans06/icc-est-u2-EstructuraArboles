package materia.controller;

import materia.model.Node;

public class ArbolBinario {
    private Node root;

    public ArbolBinario() {
        this.root = null;
    }

    // Método para insertar un nuevo valor en el árbol
    public void insert (int value) {
        root = insertRec(root, value);
    }

    // Método recursivo para insertar un nuevo valor en el árbol
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

    // Método para imprimir el árbol en inorden
    public void imprimirArbolInorder () {
        imprimirRecInorder(root);
    }

    // Método recursivo para imprimir el árbol en inorden
    public void imprimirRecInorder(Node node) {
        if (node != null) {
            imprimirRecInorder(node.getLeft());
            System.out.print(node.getValue() + " ");
            imprimirRecInorder(node.getRight());
        }
    }

    // Método para imprimir el árbol en preorden
    public void imprimirArbolPreorder () {
        imprimirRecPreorder(root);
    }

    // Método recursivo para imprimir el árbol en preorden
    private void imprimirRecPreorder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            imprimirRecPreorder(node.getLeft());
            imprimirRecPreorder(node.getRight());
        }
    }

    // Método para imprimir el árbol en postorden
    public void imprimirArbolPostorder () {
        imprimirRecPostorder(root);
    }

    // Método recursivo para imprimir el árbol en postorden
    private void imprimirRecPostorder(Node node) {
        if (node != null) {
            imprimirRecPostorder(node.getLeft());
            imprimirRecPostorder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    // Método para buscar un valor en el árbol
    public boolean buscar(int value) {
        return buscarRec(root, value);
    }

    // Método recursivo para buscar un valor en el árbol
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
