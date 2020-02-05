/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;



import Exception.EmptyCollectionException;
import Interface.BinaryTreeADT;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 8150121 e 8150133
 * @param <T> tipo genérico
 */
public class BinaryTree<T> implements BinaryTreeADT<T> {

    protected int count;
    protected BinaryTreeNode<T> root;

    /**
     * Cria uma BinaryTree vazia
     */
    public BinaryTree() {
        this.count = 0;
        root = null;
    }

    /**
     * Cria uma BinaryTree com um elemento específico
     *
     * @param element elemento a ser adicionado à BinaryTree
     */
    public BinaryTree(T element) {
        this.count = 1;
        root = new BinaryTreeNode<>(element);
    }

    /**
     * Devolve a referência para o elemento root
     *
     * @return referência para o elemento root
     */
    @Override
    public T getRoot() {
        if (isEmpty()) {
            return null;
        } else {
            return this.root.getElement();
        }

    }

    /**
     * Verifica se a BinaryTree está vazia
     *
     * @return true se a BinaryTree estiver fazia, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Devolve o número de elementos que a BinaryTree possui
     *
     * @return o numero de elementos da BinaryTree
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Verifica se certo elemento existe na BinaryTree
     *
     * @param t elemento a ser verificado
     * @return true se o elemento existir na BinaryTree, false caso contrário
     */
    @Override
    public boolean contains(T t) {
        boolean contains;

        try {
            this.find(t);
            contains = true;
        } catch (Exception ex) {
            contains = false;
        }

        return contains;
    }

    /**
     * Permite encontrar na BinaryTree algum elemento dado
     *
     * @param t elemento a procurar na BinaryTree
     * @return referencia para o elemento procurado, se este existir
     */
    @Override
    public T find(T t) {
        BinaryTreeNode<T> current = findAgain(t, this.root);

        if (current == null) {
            try {
                throw new Exception("BinaryTree vazia");
            } catch (Exception ex) {
                Logger.getLogger(BinaryTree.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return (current.element);
    }

    /**
     * Metodo para auxiliar na procura do elemento na BinaryTree
     *
     * @param target elemento a procurar na BinaryTree
     * @param next geralmente é o root element da BinaryTree
     * @return referencia para o elemento procurado
     */
    private BinaryTreeNode<T> findAgain(T target, BinaryTreeNode<T> next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(target)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(target, next.left);

        if (temp == null) {
            temp = findAgain(target, next.right);
        }

        return temp;
    }

    /**
     * Executa uma travessia inorder na BinaryTree que começa no elemento root
     *
     * @return iterator dos elementos da BinaryTree
     */
    @Override
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        inorder(this.root, templist);
        return templist.iterator();
    }

    /**
     * Método auxilar do iteratorInOrder
     *
     * @param node geralmente é o elemento root da BinaryTree
     * @param tempList recebe uma UnorderedArrayList
     */
    protected void inorder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {

        if (node != null) {
            inorder(node.left, tempList);
            tempList.addToRear(node.element);
            inorder(node.right, tempList);
        }

    }

    /**
     * Executa uma travessia preorder na BinaryTree que começa no elemento root
     *
     * @return iterator dos elementos da BinaryTree
     */
    @Override
    public Iterator<T> iteratorPreOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        preOrder(this.root, templist);
        return templist.iterator();
    }

    /**
     * Método auxilar do iteratorPreOrder
     *
     * @param node geralmente é o elemento root da BinaryTree
     * @param tempList recebe uma UnorderedArrayList
     */
    protected void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            tempList.addToRear(node.element);
            preOrder(node.left, tempList);
            preOrder(node.right, tempList);
        }

    }

    /**
     * Executa uma travessia preorder na BinaryTree que começa no elemento root
     *
     * @return iterator dos elementos da BinaryTree
     */
    @Override
    public Iterator<T> iteratorPostOrder() {
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();
        postOrder(this.root, templist);
        return templist.iterator();

    }

    /**
     * Método auxilar do iteratorPostOrder
     *
     * @param node geralmente é o elemento root da BinaryTree
     * @param tempList recebe uma UnorderedArrayList
     */
    protected void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
        if (node != null) {
            postOrder(node.left, tempList);
            postOrder(node.right, tempList);
            tempList.addToRear(node.element);
        }

    }

    /**
     * Executa uma travessia levelorder na BinaryTree usando uma queue
     *
     * @return iterator com os elementos da BinaryTree
     */
    @Override
    public Iterator<T> iteratorLevelOrder() throws EmptyCollectionException {
        LinkedQueue<BinaryTreeNode> nodes = new LinkedQueue<>();
        ArrayUnorderedList<T> templist = new ArrayUnorderedList<>();

        nodes.enqueue(this.root);

        while (nodes.isEmpty() == false) {
            BinaryTreeNode aux = null;
            aux = nodes.dequeue();
            if (aux != null) {
                templist.addToRear((T) aux.element);
                nodes.enqueue(aux.left);
                nodes.enqueue(aux.right);
            }
        }

        return templist.iterator();
    }
}
