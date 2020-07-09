#include <iostream>
using namespace std;

struct Element{
    int r,c,ele;
};

struct Sparse{
    int row, col, num;
    struct Element *element;
};

void createSparse(struct Sparse &s)
{
    cout<<"Enter the size of matrix row col: ";
    cin>>s.row>>s.col;
    cout<<"Also number of non zero element: ";
    cin>>s.num;
    s.element=new Element [s.num];
    cout<<"Enter the elements of the matrix: ";
    for(int i=0;i<s.num;i++)
    {
        cout<<"Enter the row of the elements: ";
        cin>>s.element[i].r;
        cout<<"Enter the col of the elements: ";
        cin>>s.element[i].c;
        cout<<"Enter the element: ";
        cin>>s.element[i].ele;
    }
}

void displayMatrix(struct Sparse s)
{
    int k=0;
    for(int i=0;i<s.row;i++)
    {
        for(int j=0;j<s.col;j++)
        {
            if(i==s.element[k].r && j==s.element[k].c)
            {
                cout<<s.element[k++].ele<<" ";
            }
            else 
                cout<<"0 ";
        }
        cout<<"\n";
    }
}

struct Sparse addMatrix(struct Sparse s1, struct Sparse s2)
{
    struct Sparse s3;
    s3.element=new Element[s1.num+s2.num];
    int i=0,j=0,k=0;
    while(i!=s1.num || j!=s2.num)
    {
        if(s1.element[i].r < s2.element[j].r)
            s3.element[k++]=s1.element[i++];
        else if(s1.element[i].r > s2.element[j].r)
            s3.element[k++]=s2.element[j++];
        else
            {
                if(s1.element[i].c < s2.element[j].c)
                    s3.element[k++]=s1.element[i++];
                else if(s1.element[i].c > s2.element[j].c)
                    s3.element[k++]=s2.element[j++];
                else
                    {
                        s3.element[k]=s2.element[j];
                        s3.element[k++].ele=s2.element[j++].ele + s1.element[i++].ele;
                    }    
            }
    }  
    for(;i<s1.num;i++)
        s3.element[k++]=s1.element[i];
    for(;j<s2.num;j++)
       s3.element[k++]=s2.element[j];
    s3.row=s2.row;
    s3.col=s2.col;
    s3.num=k;
    return s3;
}

int main()
{
    struct Sparse s1,s2,sum;
    createSparse(s1);
    displayMatrix(s1);
    
    createSparse(s2);
    displayMatrix(s2);
    
    cout<<"\n\n";
    sum=addMatrix(s1,s2);
    displayMatrix(sum);
    return 0;
}
