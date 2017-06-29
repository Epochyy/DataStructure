// Stack.cpp : 定义控制台应用程序的入口点。
//

#include "stdafx.h"
#include "Stack.h"


int _tmain(int argc, _TCHAR* argv[])
{
	Stack<int> st(8);
	st.push(1);
	st.push(2);
	st.push(3);
	cout << st.pop() << endl;
	return 0;
}

