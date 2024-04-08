public class Main {

static class Node {
    String item;
    Node next;
}

static Node push(String item, Node next) {
    Node node = new Node();
    node.item = item;
    node.next = next;
    next = node;
    return node;
}

static int length(Node currentNode) {
    int count = 0;
    while(currentNode != null) {
        currentNode = currentNode.next;
        count++;
    }
    return count;
}

static Node merge(Node lo1, Node hi1, Node lo2, Node hi2) {
    Node temp = null;
    if(lo1.item.compareTo(lo2.item) > 0) {
        Node tempNode = lo1;
        lo1 = lo2;
        lo2 = tempNode;
        tempNode = hi1;
        hi1 = hi2;
        hi2 = tempNode;
    }

    Node aStart = lo1;
    Node aEnd = hi1;
    Node bStart = lo2;
    Node bEnd = hi1;

    while(aStart != aEnd && bStart != bEnd) {
        if (aStart.next.item.compareTo(bStart.item) > 0) {
            temp = bStart.next;
            bStart.next = aStart.next;
            aStart.next = bStart;
            bStart = temp;
        }

        aStart = aStart.next;
    }
    if (aStart == aEnd) {
        aStart.next = bStart;
    } else {
        hi2 = hi1;
    }
    return lo1;
}

static Node mergeSort(Node head) {
    if (head == null) {
        return head;
    }

    Node lo1 = null, hi1 = null;
    Node lo2 = null, hi2 = null;
    Node prevend = null;
    int length = length(head);
    for (int gap = 1; gap < length; gap = gap*2) {
        lo1 = head;

        while(lo1 != null) {

            boolean isFirstIteration = false;
            if(lo1 == head) {
                isFirstIteration = true;
            }

            int counter = gap;
            hi1 = lo1;
            while(--counter > 0 && hi1.next != null) {
                hi1 = hi1.next;
            }

            lo2 = hi1.next;
            if (lo2 == null) {
                break;
            }

            counter = gap;
            hi2 = lo2;
            while (--counter > 0 && hi2.next != null) {
                hi2 = hi2.next;
            }

            Node temp = hi2.next;
            merge(lo1,hi1,lo2,hi2);

            if (isFirstIteration) {
                head = lo1;
            } else {
                prevend.next = lo1;
            }
            prevend = hi2;
            lo1 = temp;
        }
        prevend.next = lo1;
    }
    return head;
}

static void print(Node head)
{
    if ((head) == null)
        return;
    Node temp = head;
    while (temp != null) 
    {
        System.out.println(temp.item);
        temp = temp.next;
    }

}

public static void main(String[] args) {
    Node head = null;
    head = push("a",head); 
    head = push("c",head); 
    head = push("d",head); 
    head = push("a",head); 
    head = push("a",head); 
    head = push("c",head); 
    head = push("b",head); 

    head = mergeSort(head);

    print(head);
}
}
