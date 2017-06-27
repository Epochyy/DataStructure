// LinkList.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "LinkList.h"


int main()
{
	LinkList<int> l;
	for (int i = 1; i < 8; i++){
		l.TailInsert(i);
	}
	l.Insert(8, 8);
	l.Delete(8);
	l.showList();
	LinkList<int> m;
	m=l.Reverse();
	m.showList();
	l.reverse();
	l.showList();
	return 0;
}

