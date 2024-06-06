#include <bits/stdc++.h>
using namespace std;

int findPivotPosition(int l,int r,vector<int>&v){
	int pivot=r;
	int i,j=l;
	for(i=l;i<r;i++){
		if(v[i]<v[pivot]){
			swap(v[i],v[j++]);
		}
	}
	swap(v[pivot],v[j]);
	return j;
}
void quickSort(int l,int r,vector<int>&v){

	if(l>=r)return;
	int pivot=findPivotPosition(l,r,v);
	quickSort(l,pivot-1,v);
	quickSort(pivot+1,r,v);
}
int main(){
	int i,j,n,a,t;
	cin>>t;
	while(t--){
	vector<int>v;
	cin>>n;
	for(i=0;i<n;i++){
		cin>>a;v.push_back(a);
	}
	quickSort(0,n-1,v);
	for(auto x:v)cout<<x<<" ";
	cout<<"\n";
	}	
}
// Time Complexity:Best Case: Ω (N log (N))
// Average Case: θ ( N log (N))
// Worst Case: O(N2)
//Auxiliary Space: O(1)