#include <bits/stdc++.h>
using namespace std;
struct Node{
	Node* left;
	Node* right;
	int val;
	int height;
	Node(int value){
		left=NULL;
		right=NULL;
		val=value;
		height=1;
	}
};

int height(Node *node){
	return node==NULL?0:node->height;
}

Node* rightRotate(Node * root){

	Node* newRoot=root->left;
	Node* tp=newRoot->right;

	newRoot->right=root;
	root->left=tp;

	root->height=max(height(root->left),height(root->right))+1;
	newRoot->height=max(height(newRoot->left),height(newRoot->right))+1;
	return newRoot;
}

Node* leftRotate(Node * root){
	Node* newRoot=root->right;
	Node* tp=newRoot->left;

	newRoot->left=root;
	root->right=tp;

	root->height=max(height(root->left),height(root->right))+1;
	newRoot->height=max(height(newRoot->left),height(newRoot->right))+1;
	return newRoot;
}
Node* insert(int val,Node *node){
	if(node==NULL)return new Node(val);

	if(val<node->val)
		node->left=insert(val,node->left);
	else if(val>node->val)
		node->right=insert(val,node->right);
	else return node;

	node->height=1+max(height(node->left),height(node->right));
	int balance=height(node->left)-height(node->right);
	// cout<<balance<<" ";
	if(balance>1 && val<node->left->val)
		node=rightRotate(node);
	else if(balance<-1 && val>node->right->val)
		node=leftRotate(node);
	else if(balance>1 && val>node->left->val)
	{
		node->left=leftRotate(node->left);
		node=rightRotate(node);
	}
	else if(balance<-1 && val<node->right->val)
	{
		node->right=rightRotate(node->right);
		node=leftRotate(node);
	}
	return node;
}
Node* deleteNode(Node* root,int val){

	if(root==NULL)return root;
	else if(val<root->val)
		root->left=deleteNode(root->left,val);
	else if(val>root->val)
		root->right=deleteNode(root->right,val);
	else{

		if(root->left==NULL && root->right==NULL){free(root);return NULL;}
		else if(root->left==NULL){
			Node * newRoot=root->right;
			free(root);
			return newRoot;
		}
		else if(root->right==NULL){
			Node * newRoot=root->left;
			free(root);
			return newRoot;
		}else{
			Node *tmp=root->right;
			while(tmp->left!=NULL)tmp=tmp->left;
			root->val=tmp->val;
			root->right=deleteNode(root->right,tmp->val);
		}
	}

	root->height=1+max(height(root->left),height(root->right));
	int balance=height(root->left)-height(root->right);
	// cout<<balance<<" ";
	if(balance>1 && val<root->left->val)
		root=rightRotate(root);
	else if(balance<-1 && val>root->right->val)
		root=leftRotate(root);
	else if(balance>1 && val>root->left->val)
	{
		root->left=leftRotate(root->left);
		root=rightRotate(root);
	}
	else if(balance<-1 && val<root->right->val)
	{
		root->right=rightRotate(root->right);
		root=leftRotate(root);
	}
	return root;


}
void preorder(Node *node){
	if(!node)return;
	cout<<(node->val)<<" ";
	preorder(node->left);
	preorder(node->right);

}
void inorder(Node *node){
	if(node==NULL)return;
	inorder(node->left);
	cout<<node->val<<" ";
	inorder(node->right);

}
int main(){
	Node *root=new Node(12);
	root=insert(10,root);
	root=insert(12,root);
	root=insert(14,root);
	root=insert(16,root);
	root=insert(20,root);
	root=insert(25,root);
	root=insert(30,root);
	inorder(root);
	cout<<"\n";
	root=deleteNode(root,12);
	inorder(root);
	cout<<"\n";
	root=deleteNode(root,10);
	inorder(root);
	cout<<"\n";

	
}
