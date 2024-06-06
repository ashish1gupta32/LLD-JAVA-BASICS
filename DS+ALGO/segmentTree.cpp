#include <bits/stdc++.h>
using namespace std;
 
vector<int>res;  
int sz;
int query(int l,int r,int x,int y,int i){
	if(x>y || i>=sz)return 0;
	if(r<x || l>y)return 0;
	if(l<=x && r>=y)return res[i];
	int mid=(x+y)/2;
	return query(l,r,x,mid,2*i+1)+query(l,r,mid+1,y,2*i+2);

}
int segmentTree(vector<int>&v,int i,int l,int r){
	int mid=(l+r)/2;
	if(l>r)return 0;
	if(l==r){
		return res[i]=v[l];
	}
	int val1=segmentTree(v,2*i+1,l,mid);
	int val2=segmentTree(v,2*i+2,mid+1,r);
	return res[i]=val1+val2;

}
void constructSegmentTree(vector<int>&v){
	int n=v.size();
	sz=1;
	while(sz<n)sz*=2;
	sz=2*sz-1;
    res=vector<int>(sz,0);
    segmentTree(v,0,0,n-1);
}
void update(int ind,int val,int x,int y,int i){
	if(ind<x || ind>y)return ;
	int mid=(x+y)/2;
	res[i]+=val;
	if(x!=y){
		update(ind,val,x,mid,2*i+1);
		update(ind,val,mid+1,y,2*i+2);
	}
}
int main() {
	int i,j,n,a;
	cin>>n;
	vector<int>v;
	for(i=0;i<n;i++){
		cin>>a;
		v.push_back(a);
	}
	constructSegmentTree(v);
	
	cout<<"\n";
	cout<<query(0,1,0,n-1,0)<<"\n";
	cout<<query(0,2,0,n-1,0)<<"\n";
	cout<<query(0,3,0,n-1,0)<<"\n";
	cout<<query(1,3,0,n-1,0)<<"\n";
	cout<<query(2,3,0,n-1,0)<<"\n";
	cout<<query(2,4,0,n-1,0)<<"\n";
	cout<<"\n";
	update(0,10,0,n-1,0);
	cout<<query(0,1,0,n-1,0)<<"\n";
	cout<<query(0,2,0,n-1,0)<<"\n";
	cout<<query(0,3,0,n-1,0)<<"\n";
	cout<<query(1,3,0,n-1,0)<<"\n";
	cout<<query(2,3,0,n-1,0)<<"\n";
	cout<<query(2,4,0,n-1,0)<<"\n";
	cout<<"\n"; 
	update(2,10,0,n-1,0);
	cout<<query(0,1,0,n-1,0)<<"\n";
	cout<<query(0,2,0,n-1,0)<<"\n";
	cout<<query(0,3,0,n-1,0)<<"\n";
	cout<<query(1,3,0,n-1,0)<<"\n";
	cout<<query(2,3,0,n-1,0)<<"\n";
	cout<<query(2,4,0,n-1,0)<<"\n";
}







