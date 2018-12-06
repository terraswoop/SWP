package BST;

import BST.Node;

public class BinaryTree<T> {
	private Node<T> root;
	private int size = 0;

	public void insert(T value) {
		Node<T> n = new Node<T>(value);
		if (root == null) {
			root = n;
		} else {
			// System.out.println("hallo");
			Node<T> tmp = root;
			while (true) {
				if (n.biggerThan(tmp)) {
					if (tmp.getBigger() == null) {
						tmp.setBigger(n);
						// System.out.println(n.getValue()+" größer");
						break;
					}
					tmp = tmp.getBigger();
				} else {
					if (tmp.getSmaller() == null) {
						tmp.setSmaller(n);
						// System.out.println(n.getValue()+" kleiner");
						break;
					}
					tmp = tmp.getSmaller();
				}
			}

		}
		size++;
	}

	public int getSize() {
		return size;
	}

	public Node<T> getNode(T t) throws ElementNotFoundException {
		Node<T> tmp = root;
		while (true) {
			if ((int) t > (int) tmp.getValue()) {
				// System.out.println(tmp.getBigger().getValue());
				if (tmp.getBigger() == null) {
					if (t != tmp.getValue()) {
						throw new ElementNotFoundException();
					}
				}
				if (t == tmp.getValue()) {
					return tmp;
				}
				tmp = tmp.getBigger();
			} else {
				// System.out.println("smaller");
				if (tmp.getSmaller() == null) {
					if (t != tmp.getValue()) {
						throw new ElementNotFoundException();
					}
				}
				if (t == tmp.getValue()) {
					return tmp;
				}
				tmp = tmp.getSmaller();
			}
		}
	}

	public Node<T> getSmallestFrom(Node<T> tmp) {
		tmp = tmp.getBigger();
		while (tmp.getSmaller() != null) {
			tmp = tmp.getSmaller();
		}
		return tmp;
	}

	public Node<T> searchPreviousElement(Node<T> end) {
		Node<T> tmp = root;
		while (true) {
			if (end.biggerThan(tmp) && tmp.getBigger() != end) {
				tmp = tmp.getBigger();
			} else if (tmp.biggerThan(end) && tmp.getSmaller() != end) {
				tmp = tmp.getSmaller();
			} else {
				return tmp;
			}
		}
	}

	public Node<T> getSecondSmallestFrom(Node<T> tmp) {
		if (tmp.getBigger() != null) {
			tmp = tmp.getBigger();
			if (tmp.getSmaller() != null) {
				while (tmp.getSmaller().getSmaller() != null) {
					tmp = tmp.getSmaller();
				}
			} else {
				return new Node<T>(null);
			}
			return tmp;
		} else
			return null;
	}

	public void removeElement(T value) throws ElementNotFoundException {
		Node<T> tmp = root;
		boolean stop = false;
		while (!stop) {
			if ((int) value > (int) tmp.getValue()) {
				if (tmp.getBigger() != null) {
					tmp = tmp.getBigger();
				} else {
					System.out.println("Element does not exist!");
					stop = true;
				}
			}
			if ((int) value < (int) tmp.getValue()) {
				if (tmp.getSmaller() != null) {
					tmp = tmp.getSmaller();
				} else {
					System.out.println("Element does not exist!");
					stop = true;
				}
			}
			if ((int) value == (int) tmp.getValue()) {
				if (getSecondSmallestFrom(tmp) == null) {
					Node<T> vorher = searchPreviousElement(tmp);
					if (vorher.getSmaller() == tmp) {
						vorher.setSmaller(tmp.getSmaller());
					} else {
						vorher.setBigger(tmp.getSmaller());
					}
				} else if (getSecondSmallestFrom(tmp).getValue() == null) {
					tmp.setValue(tmp.getBigger().getValue());
					if (tmp.getBigger() != null) {
						Node<T> prev = searchPreviousElement(tmp);
						prev.setBigger(tmp.getBigger());
					} else {
						tmp.setBigger(null);
					}
				} else {
					Node<T> last = getSecondSmallestFrom(tmp);
					if (last.getBigger() != null || last.getSmaller() != null) {
						removeElement(tmp.getValue());
					} else {
						tmp = getSmallestFrom(tmp);
						last.setSmaller(null);
					}
				}
				stop = true;
			}
		}

	}
}