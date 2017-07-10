#include<bits/stdc++.h>

using namespace std;


class AutoComplete
{
private:
    struct node
    {
        int end;
        int freq;
        node* child[26];

        node() : end(0),freq(0)
        {
            for(int i=0;i<26;i++)
                child[i]=NULL;
        }
    };

    node* root;

public:
    AutoComplete()
    {
        root = new node();
    }


    void addWord(string &A)
    {
      int n = A.size();
      node* p = root;

      for(int i=0;i<n;i++)
      {
          if(p->child[A[i]-'a']==NULL)
            p->child[A[i]-'a'] = new node();

          p = p->child[A[i]-'a'];
      }

        p->end=1; //mark end of word
    }

    void getWords(string & A,vector <string>& words)
    {
      int n = A.size();
      node* p = root;
      for(int i=0;i<n;i++)
      {
          if(p->child[A[i]-'a']==NULL)
            return ;

          p = p->child[A[i]-'a'];
      }

      getPre(p,A,words);

    }

    void getPre(node* p , string &curr , vector <string>& words)
    {
        if(p->end == 1)
        {
            words.push_back(curr);
        }


        for(int i=0;i<26;i++)
        {
            if(p->child[i])
            {
                curr+= 'a'+i;
                getPre(p->child[i],curr,words);
                curr.pop_back();
            }
        }
    }

    void DisplaySuggestions(vector<string>&pre)
    {
        for(int i=0;i<pre.size();i++)
        {
            string curr = pre[i];
            vector<string>ans;
            getWords(curr,ans);

            if(!ans.size())
                cout<<"No matching strings starting with prefix \" "<<curr<<" \" "<<endl;
            else
            {
                cout<<curr<<"-> ";
                for(int j=0;j<ans.size();j++)
                    cout<<ans[j]<<" ";
                cout<<endl;
            }
        }
    }

};


int main()
{
ios_base::sync_with_stdio(false);

vector<string>dict,pre;

dict.push_back("abc");
dict.push_back("abcd");
dict.push_back("abcdefg");
dict.push_back("bababc");
dict.push_back("dasabc");
dict.push_back("bbabc");
dict.push_back("bcdabc");
dict.push_back("xyzzabc");
dict.push_back("ddxyzzabc");




pre.push_back("a");
pre.push_back("abc");
pre.push_back("x");
pre.push_back("da");
pre.push_back("d");
pre.push_back("a");
pre.push_back("ab");
pre.push_back("p");
pre.push_back("bab");



AutoComplete *T = new AutoComplete();

cout<<"The words in the dictionary are :"<<endl;
for(auto A : dict)
{
    T->addWord(A);
    cout<<A<<" ";
}
cout<<endl;

T->DisplaySuggestions(pre);

return 0;
}
