package ua.nure.tuhaibei.practice6.part5;

public class Tree<E extends Comparable<E>> {

	private Node<E> myRoot;
	private static final String SPACE = "  ";

	public boolean add(E element) {
		if (myRoot == null) {
            myRoot = new Node<E>(element, null, null, null);
            return true;
        }
        Node<E> root = myRoot;

        while (root != null) {
            int comp = root.info.compareTo(element);
            if (comp == 0)
                return false;
            if (comp > 0) {
                if (root.left == null) {
                    root.left = new Node<E>(element, null, null, root);
                    return true;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right == null) {
                    root.right = new Node<E>(element, null, null, root);
                    return true;
                } else {
                    root = root.right;
                }
            }
        }
        // can never reach here
        return false;
	}

	public void add(E[] elements) {
		for (E e : elements) {
			add(e);
		}
	}

	public boolean remove(E element) {
		 Node<E> root = myRoot;
	        while (root != null) {
	            int comp = root.info.compareTo(element);
	            if (comp == 0) {
	                remove(root);
	                return true;
	            } else if (comp > 0) {
	                root = root.left;
	            } else {
	                root = root.right;
	            }
	        }
	        return false;
	}
	
    private void remove(Node<E> root) {
        if (root.left == null && root.right == null) {
            // удаление листа
            if (root.parent == null) { // удаление корня?
                myRoot = null; // дерево теперь пустое
            } else {
                if (root.parent.left == root) {
                    root.parent.left = null;
                } else {
                    root.parent.right = null;
                }
            }
        } else if (root.left == null || root.right == null) {
            // один ребенок, а не два
            Node<E> child = root.left;  // только ребенок с лева?
            if (root.left == null) {     // нет это правый
                child = root.right;
            }
            if (root.parent == null) {   // новый корень
                myRoot = child;
            } else if (root.parent.left == root) {
                root.parent.left = child;
            } else {
                root.parent.right = child;
            }
            child.parent = root.parent;
        } else {                          // удаление узла с двумя детьми
            Node<E> successor = root.right;
            if (successor.left == null) {
                root.info = successor.info;
                root.right = successor.right;
                if (successor.right != null) {
                    successor.right.parent = root;
                }
            } else {                    
                // у непосредственного правого потомка удаленного узла есть левый потомок
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.info = successor.info;
                successor.parent.left = successor.right;
                if (successor.right != null) {
                    successor.right.parent = successor.parent;
                }
            }
        }
    }

	public void print() {
		print(myRoot, new StringBuilder());
	}

	private void print(Node<E> node, StringBuilder sb) {
		if (node != null) {
			sb.delete(0, sb.length());
			sb.append(SPACE);
			print(node.left, sb);

			sb.append(SPACE);
			if (node.equals(myRoot)) {
				System.out.println(node.info);
			} else {
				System.out.println(sb.toString() + node.info);
			}
			print(node.right, sb);

			sb.delete(0, sb.length());
		}
	}

	private static class Node<E> {
		private E info;
		private Node<E> left;
		private Node<E> right;
		private Node<E> parent;

		public Node(E element, Node<E> left, Node<E> right, Node<E> parent) {
			this.info = element;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}

		 

	}
}
