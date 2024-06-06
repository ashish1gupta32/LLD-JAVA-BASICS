#include <bits/stdc++.h>
using namespace std;

string longestPalindrome(string &st1){
	int i;
	string st;
	for(i=0;i<st1.size();i++){
		st+="$";
		st+=st1[i];
	}
	st+="$";
	cout<<st<<" ";
	int n=st.size();
	vector<int>dp(n,0);
	int center=0,left=0,right=0;
	for(i=1;i<n-1;i++){
		int mirror=2*center-i;
		if(i<right){
			dp[i]=dp[mirror];
		}
		while(i+dp[i]+1<n && i-dp[i]-1>=0 && st[i+dp[i]+1]==st[i-dp[i]-1])
			dp[i]++;
		if(i+dp[i]>right){
			center=i;
			right=i+dp[i];
		}
		cout<<dp[i]<<" ";
	}
	int mxlen=0,j=0;
	for(i=1;i<n;i++){
		if(mxlen<dp[i]){
			mxlen=dp[i];
			j=i;
		}
	}
	return st1.substr((j-mxlen)/2,mxlen);


}

int main() {
	int i,j,n,a;
	string st;
	cin>>n;
	while(n--){
	cin>>st;
	cout<<longestPalindrome(st)<<"\n";
	}
	unordered_map<int,int>mp;
	mp[10]=10;
	mp.insert({10,12});
	cout<<mp[10]<<" ";
}
//(a*b)+c+d
//[+]
//ab*c+d+

//a+b*(c+d)
//(d+c)*b+a
//[][]
//dc+b*a+
//+a*b+cd







