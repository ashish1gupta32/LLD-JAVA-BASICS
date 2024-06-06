#include <bits/stdc++.h>
using namespace std;

void solve(){
	int i,j,n,m,k,a;
	cin>>n;
	set<int>st;
	for(int i=0;i<n;i++){
		cin>>a;
		st.insert(a);
	}
	int prev=0,flag=1;
	vector<int>v;
	for(auto x:st){
		v.push_back(x-prev);
		if(x-prev==1)flag=0;
		prev=x;
	}
	if(flag){cout<<"Alice\n";return;}
	for(int i=0;i<v.size();i++){
		if(v[i]!=1){
			if(i%2==0)cout<<"Alice\n";
			else cout<<"Bob\n";
			return;
		}
	}
	if(v.size()%2!=0)cout<<"Alice\n";
	else cout<<"Bob\n";
    


	




}
int main() {
	int i,j,t,a;
	cin>>t;
	while(t--){
	solve();
	}
	
}