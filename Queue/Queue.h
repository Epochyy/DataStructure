//Queue.h
//

#include<iostream>
using namespace std;
#define error -1

template <class T>
class Queue
{
public:
	Queue(int size);
	~Queue();
	bool EnQueue(T x);
	T DlQueue();
	bool Empty();
	bool clear();
	int Size();
	T head();
	T Tail();
private:
	T *elem;
	int front;
	int rear;
	int maxsize;
};

template <class T>
Queue<T>::Queue(int size)
{
	elem = new T[size];
	front = 0;
	rear = -1;
	maxsize = size;
}

template <class T>
Queue<T>::~Queue()
{
	delete[] elem;
}

template <class T>
bool Queue<T>::EnQueue(T x)
{
	if (((rear+1)%maxsize)==front && rear!=-1){
		cout << "Full Queue!" << endl;
		return false;
	}
	else{
		rear = (rear + 1) % maxsize;
		elem[rear] = x;
		return true;
	}
}

template <class T>
T Queue<T>::DlQueue()
{
	if (rear == (front+1) % maxsize || rear==-1){
		cout << "Empty Queue!" << endl;
		return error;
	}
	else{
		front = (front + 1) % maxsize;
		return true;
	}
}

template <class T>
bool Queue<T>::Empty()
{
	if (rear == (front + 1) % maxsize){
		return true;
	}
	else{
		return false;
	}
}

template <class T>
bool Queue<T>::clear()
{
	rear = front + 1;
	return true;
}

template <class T>
int Queue<T>::Size()
{
	if (rear - front > 0)
	{
		return rear - front +1;
	}
	else
	{
		return rear - front + maxsize +1;
	}
}

template <class T>
T Queue<T>::head()
{
	if (!Empty()){
		return elem[front];
	}
	else{
		cout << "Empty Queue!" << endl;
		return error;
	}
}
template <class T>
T Queue<T>::Tail()
{
	if (!Empty()){
		return elem[rear];
	}
	else{
		cout << "Empty Queue!" << endl;
		return error;
	}
}