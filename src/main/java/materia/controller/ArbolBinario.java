package materia.controller;

import materia.model.Node;

public class ArbolBinario {
    private Node root;
    private int weight;

    public ArbolBinario() {
        this.root = null;
    }

    // Método para insertar un nuevo valor en el árbol
    public void insert (int value) {
        root = insertRec(root, value);
        weight++;
    }

    // Método recursivo para insertar un nuevo valor en el árbol
    private Node insertRec(Node padre, int value) {
        if (padre == null) {
            return new Node(value);
        }

        if (value < padre.getValue()) {
            padre.setLeft(insertRec(padre.getLeft(), value));
        } else if (value > padre.getValue()) {
            padre.setRight(insertRec(padre.getRight(), value));
        }
        return padre; // Retorna porque el nodo padre no ha cambiado
    }

    // Método para imprimir el árbol en inorden
    public void imprimirArbolInorder() {
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
    public void imprimirArbolPreorder() {
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
    public void imprimirArbolPostorder() {
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

    // Método que devuelve la altura del árbol
    public int getHeigth() {
        return getHeightRec(root);
    }

    // Método recursivo para obtener la altura
    private int getHeightRec(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightRec(node.getLeft());
        int rightHeight = getHeightRec(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1; // Suma 1 en caso de que sea un solo nivel
    }

    // Método que calcula el peso
    public int getWeight() {
        return weight;
    }

    // Método que imprime en indorder más la altura del nodo
    public void printInorderHeight() {
        printInorderHeightRec(root);
        System.out.println();
    }
    // Método recursivo para imprimir inorder más altura del nodo
    private void printInorderHeightRec(Node node) {
        if (node != null) { // Para esto se le tiene que verificar que el nodo sea diferente de null
            printInorderHeightRec(node.getLeft());
            System.out.print(node.getValue() + " (h=" + getHeightRec(node) + ") "); // Se le envia el nodo a calcular
            printInorderHeightRec(node.getRight());
        }
    }

    public void valueBalance () {
        valueBalanceRec(root);
        System.out.println();
    }

    public void valueBalanceRec (Node node) {
        if (node != null) {
            valueBalanceRec(node.getLeft());
            int balance = getHeightRec(node.getLeft()) -  getHeightRec(node.getRight());
            System.out.print(node.getValue() + " (b= " + balance + ") ");
            valueBalanceRec(node.getRight());
        }
    }

    public boolean balanceTree() {
        return balanceTreeRec(root);
    }

    private boolean balanceTreeRec(Node node) {
        if (node != null) {
            if (Math.abs(getHeightRec(node.getLeft()) - getHeightRec(node.getRight())) > 1) {
                return false; // El árbol no esta balanceado
            }
        }
        return true;
    }

    public void desbalancesNode () {
        desbalanceNodeRec(root);
        System.out.println();
    }

    public void desbalanceNodeRec(Node node) {
        if (node != null) {
            desbalanceNodeRec(node.getLeft());
            int balance = getHeightRec(node.getLeft()) - getHeightRec(node.getRight());
            if (Math.abs(balance) > 1 || Math.abs(balance) < -1) {
                System.out.print(node.getValue() + " (b= " + balance + ") ");
            }
            desbalanceNodeRec(node.getRight());
        }
    }

}
