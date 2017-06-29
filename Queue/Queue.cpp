// Queue.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "Queue.h"


int _tmain(int argc, _TCHAR* argv[])
{
	Queue<int> q(8);
	//q.DlQueue();
	for (int i = 0; i < 7; i++)
	{
		q.EnQueue(i);
	}
	q.EnQueue(7);
	q.DlQueue();
	q.EnQueue(8);
	cout << q.head() << endl;
	cout << q.Tail() << endl;
	return 0;
}

