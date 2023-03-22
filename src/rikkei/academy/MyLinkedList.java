package rikkei.academy;

import java.util.LinkedList;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

    }

    //thêm đối tượng vào vị trí index
    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }


    // thêm đối tượng vào vị trí đầu tiên
    public void addFist(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    //thêm đối tượng vào vị trí cuối
    public void addLast(Object data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp = new Node(data);
        numNodes++;
    }

    //loại bỏ 1 đối tượng
    public Object remove(int index) {
        // khởi tạo nút tạm thời trỏ đầu đến danh sách liên kết
        Node temp = head;
        //hoder là nút tạm thời được sử dụng để lu trữ nút tiếp theo trong danh sách sau khi loại bỏ nút
        Node holder;
        //resul là nút được loại khỏi danh sách liên kết
        Node resul;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        resul = temp;
        holder = temp.next.next;
        temp.next = holder;
        numNodes--;
        return resul;
    }

    public int size() {
        return ++numNodes;
    }

    // clone 1 đối tượng
    public Object clone() {
        Node newList = new Node(head.data);
        Node temp = head;
        newList.next = temp.next;
        return newList;
    }

    // kiểm tra xem đối tượng có nằm trong danh sách không
    public boolean contains(Object data) {
        Node temp = head;
        Node checkValue = new Node(data);
        while (!temp.data.equals(checkValue.data) && temp.next != null) {
            temp = temp.next;
        }
        if (temp.data == checkValue.data) {
            return true;
        }
        return false;
    }

    //tìm ra vị trí thứ đầu tiên mà đối tượng xuất hiện
    public int indexOf(Object data) {
        int index = 0;
        Node temp = head;
        Node checkValue = new Node(data);
        while (!temp.data.equals(checkValue.data) && temp.next != null) {
            temp = temp.next;
            index++;
        }
        if (temp.data == checkValue.data) {
            return index;
        } else {
            return 0;
        }
    }

    // trả về giá trị kiểu boolean khi danh sách có chưa 1 phần tử chỉ định
    public boolean add(Object data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp = new Node(data);
        numNodes++;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        numNodes = minCapacity;
    }

    public void get(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            System.out.println(temp.next);
        }
        System.out.println(temp.next);
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                ", numNodes=" + numNodes +
                '}';
    }
}
