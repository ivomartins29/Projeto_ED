/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

/**
 *
 * @author 8150121 e 8150133
 * @param <T>
 */
public class BinaryTreeNode<T> {

    protected T element;
    protected BinaryTreeNode<T> left, right;

    /**
     * Cria um construtor para um novo Node
     *
     * @param element
     */
    public BinaryTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    /**
     * Permite descobrir o número de filhos que o Node possui
     *
     * @return o numero de filhos do Node
     */
    public int numChildren() {
        int children = 0;

        if (this.left != null) {
            children = 1 + left.numChildren();
        }

        if (this.right != null) {
            children = children + 1 + this.right.numChildren();
        }

        return children;
    }

    /**
     * Permite obter o elemnto
     *
     * @return do elemento
     */
    public T getElement() {
        return element;
    }

    /**
     * permite alterar o elemento
     *
     * @param element
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Permite retornar o filho esquerdo do Node
     *
     * @return filho esquerdo
     */
    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    /**
     * Permite alterar o filho esquerdo do Node
     *
     * @param left filho a ser alterado
     */
    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Permite retornar o filho direito do Node
     *
     * @return filho direito
     */
    public BinaryTreeNode<T> getRight() {
        return right;
    }

    /**
     * Permite alterar o filho direito do Node
     *
     * @param right filho a ser alterado
     */
    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

}
