class MyCircularQueue {
    int[] data;
    int front=-1,rear=-1,size=0;
    public MyCircularQueue(int k) {
        data=new int[k];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            front=0;
        }
        rear=(rear+1)%data.length;
        data[rear]=value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(front ==rear){
            front=-1;
            rear=-1;
        }
        front=(front+1)%data.length;;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==data.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */