package ua.nure.tuhaibei.practice6.part5;

public class Tree<E extends Comparable<E>> {
	
	private Node<E> root;
	private static final String INDENT = " ";
	private StringBuilder sb = new StringBuilder(INDENT);
	
		public boolean add(E element) {
			if (root == null) {
				root = new Node<E>();
				root.value = element;
				return true;
			} else {
				Node<E> temp = root;
				while (true) {
					if (temp.value.compareTo(element) == 0 && temp != null) {
						return false;
					}
					if (temp.value.compareTo(element) < 0) {
						if (temp.right == null) {
							Node<E> node = new Node<>();
							node.value = element;
							node.parent = temp;
							temp.right = node;
							return true;
						} else {
							temp = temp.right;
						}
					} else {
						if (temp.left == null) {
							Node<E> node = new Node<>();
							node.value = element;
							node.parent = temp;
							temp.left = node;
							return true;
						} else {
							temp = temp.left;
						}
					}
				}
			}
		}
	 
		public void add(E[] elements) {
			for (E e : elements) {
				add(e);
			}
		}

		
		public boolean remove(E element) {
			if (root == null) {
				return false;
			}
			return remove(element, root);
		}
		
		private boolean remove(E element, Node<E> node) {
			Node<E> parent = node.parent;
			if (node.value.compareTo(element) == 0) {
				if (node.left == null && node.right == null) {
					if (node.parent.left == node) {
						node.parent.left = null;
					} else {
						node.parent.right = null;
					}
					return true;
				}
				if (node.left == null && node.right != null) {
					if (node.parent.left == node) {
						node.parent.left = node.right;
					} else {
						node.parent.right = node.right;
					}
					node.parent = parent;
					return true;
				}
				if (node.left != null && node.right == null) {
					if (node.parent.left == node) {
						node.parent.left = node.left;
					} else {
						node.parent.right = node.left;
					}
					node.parent = parent;
					return true;
				}
				if (node.right.left == null) {
					if (node.parent.left == node) {
						node.parent.left = node.right;
					} else {
						node.parent.right = node.right;
					}
					node.right.left = node.left;
					node.parent = parent;
					return true;
				} else {
					Node<E> temp = node.right;
					while (temp.left.left != null) {
						temp = temp.left;
					}
					node.value = temp.left.value;
					temp.left = null;
					node.parent = parent;
					return true;
				}
			}
			if (node.left != null && node.right != null) {
				if (node.value.compareTo(element) > 0) {
					return remove(element, node.left);
				} else {
					return remove(element, node.right);
				}
			}
			if (node.left == null && node.right != null) {
				if (node.value.compareTo(element) > 0) {
					return false;
				} else {
					return remove(element, node.right);
				}
			}
			if (node.right == null && node.left != null) {
				if (node.value.compareTo(element) < 0) {
					return false;
				} else {
					return remove(element, node.left);
				}
			}
			return false;
		}

	 
		public void print() {
			print(root);
		}
		
		public void print(Node<E> node) {
			if (node != null) {
				sb.append(INDENT);
				print(node.left);
				sb.append(INDENT);
				if (node.equals(root)) {
					System.out.println(node.value);
				} else {
					System.out.println(sb.toString() + node.value);
				}
				sb.append(INDENT);
				print(node.right);
				sb.delete(0, sb.length());
				sb.append(INDENT);
			}

		}
		private static class Node<E> {
			E value;
		    Node<E> left;
		    Node<E> right;   
		    Node<E> parent;
		    
		    }
	
}
