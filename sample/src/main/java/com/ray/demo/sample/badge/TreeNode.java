package com.ray.demo.sample.badge;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private int parentId;
    private int selfId;
    protected String nodeName;
    protected T obj;
    protected TreeNode<T> parentNode;
    protected List<TreeNode<T>> childList;

    public TreeNode() {
        initChildList();
    }

    public TreeNode(TreeNode<T> parentNode) {
        this.getParentNode();
        initChildList();
    }

    public boolean isLeaf() {
        return childList == null || childList.isEmpty();
    }

    /* 插入一个child节点到当前节点中 */
    public void addChildNode(TreeNode<T> treeNode) {
        initChildList();
        childList.add(treeNode);
    }

    public void initChildList() {
        if (childList == null)
            childList = new ArrayList<>();
    }

    public boolean isValidTree() {
        return true;
    }

    /* 返回当前节点的父辈节点集合 */
    public List<TreeNode<T>> getElders() {
        List<TreeNode<T>> elderList = new ArrayList<>();
        TreeNode<T> parentNode = this.getParentNode();
        if (parentNode == null) {
            return elderList;
        } else {
            elderList.add(parentNode);
            elderList.addAll(parentNode.getElders());
            return elderList;
        }
    }

    /* 返回当前节点的晚辈集合 */
    public List<TreeNode<T>> getJuniors() {
        List<TreeNode<T>> juniorList = new ArrayList<>();
        List<TreeNode<T>> childList = this.getChildList();
        if (childList == null) {
            return juniorList;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode junior = childList.get(i);
                juniorList.add(junior);
                juniorList.addAll(junior.getJuniors());
            }
            return juniorList;
        }
    }

    /* 返回当前节点的孩子集合 */
    public List<TreeNode<T>> getChildList() {
        return childList;
    }

    /* 删除节点和它下面的晚辈 */
    public void deleteNode() {
        TreeNode parentNode = this.getParentNode();
        int id = this.getSelfId();

        if (parentNode != null) {
            parentNode.deleteChildNode(id);
        }
    }

    /* 删除当前节点的某个子节点 */
    public void deleteChildNode(int childId) {
        List<TreeNode<T>> childList = this.getChildList();
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            if (child.getSelfId() == childId) {
                childList.remove(i);
                return;
            }
        }
    }

    /* 动态的插入一个新的节点到当前树中 */
    public boolean insertJuniorNode(TreeNode treeNode) {
        int juniorParentId = treeNode.getParentId();
        if (this.parentId == juniorParentId) {
            addChildNode(treeNode);
            return true;
        } else {
            List<TreeNode<T>> childList = this.getChildList();
            int childNumber = childList.size();
            boolean insertFlag;

            for (int i = 0; i < childNumber; i++) {
                TreeNode childNode = childList.get(i);
                insertFlag = childNode.insertJuniorNode(treeNode);
                if (insertFlag)
                    return true;
            }
            return false;
        }
    }

    /* 找到一颗树中某个节点 */
    public TreeNode<T> findTreeNodeById(int id) {
        if (this.selfId == id)
            return this;
        if (childList.isEmpty() || childList == null) {
            return null;
        } else {
            int childNumber = childList.size();
            for (int i = 0; i < childNumber; i++) {
                TreeNode<T> child = childList.get(i);
                TreeNode<T> resultNode = child.findTreeNodeById(id);
                if (resultNode != null) {
                    return resultNode;
                }
            }
            return null;
        }
    }

    /* 遍历一棵树，层次遍历 */
    public void traverse() {
        if (selfId < 0)
            return;
        print(this.selfId);
        if (childList == null || childList.isEmpty())
            return;
        int childNumber = childList.size();
        for (int i = 0; i < childNumber; i++) {
            TreeNode child = childList.get(i);
            child.traverse();
        }
    }

    public void print(String content) {
        System.out.println(content);
    }

    public void print(int content) {
        System.out.println(String.valueOf(content));
    }

    public void setChildList(List<TreeNode<T>> childList) {
        this.childList = childList;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSelfId() {
        return selfId;
    }

    public void setSelfId(int selfId) {
        this.selfId = selfId;
    }

    public TreeNode<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode<T> parentNode) {
        this.parentNode = parentNode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}  