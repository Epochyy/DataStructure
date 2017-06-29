//Stack.h

#include<iostream>
using namespace std;
#define error -1

template <class T>
class Stack
{
public:
	Stack(int size);
	~Stack();
	bool push(T x);
	T pop();
	bool empty();
	T peek();
	bool clear();
	int size();
private:
	T *elem;
	int top;
	int maxsize;
};

template <class T>
Stack<T>::Stack(int size)
{
	elem = new T[size];
	maxsize = size;
	top = -1;
}

template <class T>
Stack<T>::~Stack()
{
	delete[] elem;
}

template <class T>
bool Stack<T>::push(T x)
{
	if (top == maxsize - 1){
		cout << "Full Stack!" << endl;
		return false;
	}
	else{
		elem[++top] = x;
		return true;
	}
}

template <class T>
T Stack<T>::pop()
{
	if (top == -1){
		cout << "Empty Stack!" << endl;
		return error;
	}
	else{
		return elem[top--];
	}
}

template <class T>
T Stack<T>::peek()
{
	return elem[top];
}

template <class T>
bool Stack<T>::empty()
{
	if (top == -1)
	{
		return true;
	}
	else{
		return false;
	}
}

template <class T>
bool Stack<T>::clear()
{
	top == -1;
}

template <class T>
int Stack<T>::size()
{
	return top + 1;
}