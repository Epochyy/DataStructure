//node.h ½ÚµãÀà

template <typename T>
class node
{
public:
	node();
	node(T data);
	~node();
	node<T> *next;
	T data;
};

template <typename T>
node<T>::node()
{
	next = NULL;
}

template <typename T>
node<T>::node(T data)
{
	this->data = data;
	next = NULL;
}

template <typename T>
node<T>::~node()
{
	
}