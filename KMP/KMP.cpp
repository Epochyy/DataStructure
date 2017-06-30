// KMP.cpp : 定义控制台应用程序的入口点。
// 模式匹配KMP算法

#include "stdafx.h"
#include<iostream>
using namespace std;

//朴素字符串匹配算法
int NaivePatternMatch(string S,string P)
{
	int i = 0, j = 0;
	int slen = S.length();
	int plen = P.length();
	while (i<slen && j<plen)
	{
		if (S[i] == P[j])
		{
			i++; j++;
		}
		else
		{
			i = i - j + 1;
			j = 0;
		}
	}
	if (j == plen)
	{
		return i - j;
	}
	return -1;
}

//求next数组——最长相同前后缀
void getNext(string p, int next[])
{
	int plen = p.length();
	int i = 0, j = -1;
	next[0] = -1;
	while (i < plen)
	{
		if (j == -1 || p[i] == p[j])
		{
			i++;
			j++;
			next[i] = j;
		}
		else
		{
			j = next[j];
		}
	}
}

int KMP(string S, string P, int next[])
{
	getNext(P, next);
	int i = 0, j = 0;
	int slen = 0, plen = 0;
	slen = S.length();
	plen = P.length();
	while (i < slen && j < plen)
	{
		if (j==-1 || S[i]==P[j])
		{
			i++; j++;
		}
		else
		{
			j = next[j];
		}
	}
	if (j == plen)
	{
		return i - j;
	}
	else
	{
		return -1;
	}
}

//最优相同前后缀    //优化版kmp无法解决字符串重复问题
void NgetNext(string p, int next[])
{
	int i = 0, j = -1;
	int plen = p.length();
	while (i<plen)
	{
		if (j = -1 || p[i] == p[j])
		{
			i++; j++;
			if (p[i]!=p[j])
			{
				next[i] = j;
			}
			else
			{
				next[i] = next[j];
			}
		}
		else
		{
			j = next[j];
		}
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	int next[30];
	string P = "ABCDAB";
	string S = "ABCABF EABCSK ABCDABC ABCFGHHA";
	cout << KMP(S, P, next) << endl;;
	return 0;
}

