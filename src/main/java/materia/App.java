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

        System.out.print("Árbol Inrorder -> "); arbolBinario.imprimirArbolInorder();
        System.out.println();
        System.out.print("Árbol Preorder -> "); arbolBinario.imprimirArbolPreorder();
        System.out.println();
        System.out.print("Árbol Postorder -> "); arbolBinario.imprimirArbolPostorder();
        System.out.println();
        System.out.println("El número 23 esta en el arbol -> "+ arbolBinario.buscar(23));
        System.out.println("El número 77 esta en el arbol -> "+ arbolBinario.buscar(77));
    }
}
