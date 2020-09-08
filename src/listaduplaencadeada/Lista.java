/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaduplaencadeada;

/**
 *
 * @author lab212
 */
public class Lista {

    private static class No {

        public No prox;
        public No ant;
        public int valor;

        public No(int elemento) {
            valor = elemento;
            prox = null;
            ant = null;
        }
    }

    private No inicio;
    private No fim;
    private int size;

    public Lista() {
        inicio = null;
        fim = null;
        size = 0;
    }

    public boolean isEmpty() {
        return (inicio == null && fim == null);
    }

    public void removerFim() {
        if (isEmpty()) {
            System.out.println("A lista está vazia");
            return;
        } else if (inicio == fim) {  // a lista so tem um elemento
            fim = null;
            inicio = null;
            size--;
        } else {
            fim = fim.ant;
            fim.prox = null;
            size--;
        }
    }

    public void removerInicio() {
        if (isEmpty()) {
            System.out.println("A lista está vazia");
            return;
        } else if (inicio == fim) {
            fim = null;
            inicio = null;
            size--;
        } else {
            inicio.ant = null;
            inicio = inicio.prox;
            size--;
        }
    }

    public void inserirFim(int elemento) {
        No novoNo = new No(elemento);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.ant = fim;
            fim.prox = novoNo;
            fim = novoNo;
        }
        size++;
    }

    public void inserirInicio(int elemento) {
        No novoNo = new No(elemento);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.ant = novoNo;
            novoNo.prox = inicio;
            inicio = novoNo;
        }
        size++;
    }

    public String exibir() {
        String s = "Lista duplamente encadeada: ";
        if (isEmpty()) {
            System.out.println("Lista vazia");
        } else {

            System.out.println("Tamanho da lista: " + size);
            for (No nodo = inicio; nodo != null; nodo = nodo.prox) {
                s += " " + nodo.valor;
            }
        }
        return s + "\n";
    }
}
