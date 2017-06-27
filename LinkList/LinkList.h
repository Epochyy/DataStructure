//LinkList.h头文件

#include<iostream>
#include "node.h"
using namespace std;

template <class T>
class LinkList
{
public:
	LinkList();
	~LinkList();
	bool TailInsert(T data);
	bool HeadInsert(T data);
	bool Insert(int location, T data);
	bool Delete(int location);
	void showList();
	//归并排序
	//LinkList<T> mergeList(LinkList<T> la, LinkList<T> lb);
	//链表逆置
	LinkList<T> Reverse();
	//原地逆置
	void reverse();
private:
	int length;
	node<T> *head;
};

template <class T>
LinkList<T>::LinkList()
{
	head = new node<T>(0);
	length = 1;
}

template <class T>
LinkList<T> LinkList<T>:: Reverse()
{
	LinkList<T> lb;
	LinkList<T> lc;
	node<T> *p;
	node<T> *q = lc.head;
	node<T> *s;
	node<T> *n;
	for (p = lb.head->next; p; p = s)
	{
		s = p->next;
		n = q->next;
		p->next = n;
		q->next = p;
		q = lc.head;
	}
	return lc;
}

template <class T>
void LinkList<T>:: reverse()
{
	node<T> *p;
	node<T> *q;
	node<T> *s;
	p = head->next;
	q = p->next;
	s = q->next;
	p->next = NULL;
	while (s->next)
	{
		q->next = p;
		p = q;
		q = s;
		s = s->next;
	}
	q->next = p;
	s->next = q;
	head->next = s;
}


template <class T>
bool LinkList<T>::HeadInsert(T data)
{
	node<T> *q = new node<T>(data);
	node<T> *p = head;
	q->next = p->next;
	p->next = q;
	length++;
}

template <class T>
bool LinkList<T>::TailInsert(T data)
{
	node<T> *q=new node<T> (data);
	node<T> *p = head;
	for (p = head; p->next; p = p->next)
	{
	}
	p->next = q;
	length++;
	return true;
}

template <class T>
bool LinkList<T>::Insert(int location, T data)
{
	if (location > length){
		cout << "插入位置超出链表长度！" << endl;
		return false;
	}
	node<T> *q = new node<T>(data);
	node<T> *p;
	p = head;
	int count = 0;
	while (p->next)
	{
		count++;
		if (count==location)
		{
			break;
		}
		p = p->next;
	}
	q->next = p->next;
	p->next = q;
	length++;
	return true;
}

template <class T>
bool LinkList<T>::Delete(int location)
{
	if (location > length){
		cout << "插入位置超出链表长度！" << endl;
		return false;
	}
	node<T> *p;
	int count = 0;
	for (p = head; p; p = p->next)
	{
		count++;
		if (count == location)
		{
			break;
		}
	}
	node<T> *q = p->next;
	p->next = q->next;
	length--;
	delete q;
	return true;
}

template <class T>
void LinkList<T>::showList()
{
	node<T> *p;
	for (p = head->next; p; p = p->next)
	{
		cout << p->data << "\t";
	}
	cout << endl;
}


template <class T>
LinkList<T>::~LinkList()
{

}