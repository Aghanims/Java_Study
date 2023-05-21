package DataStructures;

/*
Page.903
    A linked list is a data structure consisting  of objects known as nodes.
    Each node can contain both data and a reference to one other node so that
    the nodes link together to form a list.
*/

public class ListNode 
{
    private String data;
    private ListNode link; // this variable will contain a reference to another object of the class ListNode

    public ListNode()
    {
        link = null;
        data = null;
    }

    public ListNode(String newData, ListNode linkValue)
    {
        data = newData;
        link =  linkValue;
    }

    public void setData(String newData)
    {
        data = newData;
    }

    public String getData()
    {
        return data;
    }

    public void setLink(ListNode newLink)
    {
        link = newLink;
    }

    public ListNode getlink()
    {
        return link;
    }
}
