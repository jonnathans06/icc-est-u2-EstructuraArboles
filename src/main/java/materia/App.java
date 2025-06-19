package materia;

import materia.controller.ArbolBinario;

public class App {
    public static void main(String[] args) {
        ArbolBinario arbolBinario = new ArbolBinario();
        arbolBinario.insert(50);
        arbolBinario.insert(17);
        arbolBinario.insert(76);
        arbolBinario.insert(9);
        arbolBinario.insert(23);
        arbolBinario.insert(54);
        arbolBinario.insert(14);
        arbolBinario.insert(19);

        System.out.println("-".repeat(30) + " \nNombre: Jonnathan Saavedra \n" + "-".repeat(30));
        System.out.println("El peso del árbol es -> " + arbolBinario.getWeight());
        System.out.println("Altura del árbol es -> " + arbolBinario.getHeigth());
        System.out.print("Árbol Inrorder -> "); arbolBinario.imprimirArbolInorder();
        System.out.println();
        System.out.print("Árbol Inorder con alturas -> "); arbolBinario.printInorderHeight();
        System.out.print("Árbol Inforder con factor equilibrio ->"); arbolBinario.valueBalance();
        System.out.println("Árbol esta equilibrado -> " + arbolBinario.balanceTree());
        arbolBinario.insert(15);
        System.out.println("-".repeat(30));
        System.out.println("Instartamos el valor -> 15");
        System.out.print("Árbol Inorder con factor equilibrio -> ");  arbolBinario.valueBalance();
        System.out.print("Nodos desbalanceados -> "); arbolBinario.desbalancesNode();
    }
}
