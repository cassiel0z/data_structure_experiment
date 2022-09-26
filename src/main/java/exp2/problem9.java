package exp2;



public class problem9 {


    //主方法
    public static void main(String[] args) {
        PolynList polynomial = new PolynList();
        Node link1=new Node();
        Node link2=new Node();
        //第一个多项式
        polynomial.insert(link1,10,1000);
        polynomial.insert(link1,5,14);
        polynomial.insert(link1,1,0);


        //第二个多项式
        polynomial.insert(link2,3,1990);
        polynomial.insert(link2,-2,1492);
        polynomial.insert(link2,11,1);
        polynomial.insert(link2,5,0);






        link1 = polynomial.add(link1, link2);

        while(link1!=null){
            if(link1.exp== 0)
                System.out.print(link1.coef);
            else
                System.out.print(link1.coef+"x^"+link1.exp);
            link1=link1.next;
            if(link1!=null)
                if (link1.coef>0)
                    System.out.print("+");
        }
    }

}

class PolynList{
    public Node add(Node link1, Node link2) {
        Node pre=link1;
        Node qre=link2;
        Node p=pre.next;
        Node q=qre.next;
        Node result=p;
        while(p!=null && q!=null){
            if(p.exp<q.exp){
                pre=p;
                p=p.next;
            }else if(p.exp>q.exp){
                Node temp=q.next;
                pre.next=q;
                q.next=p;
                q=temp;
            }else{
                p.coef=p.coef+q.coef;
                if(p.coef==0){
                    pre.next=p.next;
                    p=pre.next;
                }else{
                    pre=p;
                    p=p.next;
                }
                qre.next=q.next;
                q=qre.next;
            }
        }
        if(q!=null){
            pre.next=q;
        }
        return result;
    }

    //添加数据方法
    public Node insert(Node link,int coef,int exp) {//添加节点
        Node node=new Node(coef,exp);
        if(link==null){
            link.next=node;
        }else{
            Node temp=link;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
        }
        return link;
    }
}

class Node{
    public int coef;//系数
    public int exp;//指数
    public Node next=null;//下个节点
    public Node(){
        coef=0;
        exp=0;
    }
    public Node(int coef,int exp){
        this.coef=coef;
        this.exp=exp;
    }
}
