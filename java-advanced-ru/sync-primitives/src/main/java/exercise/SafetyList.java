package exercise;

class SafetyList {
    // BEGIN
    private int[] elements;
    private int size;

    SafetyList() {
        elements = new int[10];
        size = 0;
    }

    public synchronized void add(int element) {
        elements[size] = element;
        size++;

        if (size == elements.length) {
            var expandedElements = new int[elements.length * 2];
            System.arraycopy(elements, 0, expandedElements, 0, size);
            elements = expandedElements;
        }
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bounds");
        } else {
            return elements[index];
        }
    }

    public int getSize() {
        return size;
    }

    // END
}
