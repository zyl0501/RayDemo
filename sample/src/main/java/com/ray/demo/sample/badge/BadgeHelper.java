package com.ray.demo.sample.badge;

import android.util.SparseArray;

import com.ray.demo.common.Log;
import com.ray.demo.sample.badge.BadgeNumber.BadgeMode;

import java.util.ArrayList;
import java.util.List;


public class BadgeHelper {
    private static BadgeHelper instance;

    private BadgeNumberNode root;
    private SparseArray<BadgeNumberNode> badgeArray;
    private SparseArray<OnChangeListener> listeners;

    private BadgeHelper() {
        root = new BadgeNumberNode();
        root.setSelfId(BadgeGraph.root);
        BadgeNumber rootNumber = new BadgeNumber();
        rootNumber.setCount(0);
        rootNumber.setBadgeId(BadgeGraph.root);
        rootNumber.setDisplayMode(BadgeMode.NUMBER);
        root.setObj(rootNumber);
        badgeArray = new SparseArray<>();
        badgeArray.put(root.getSelfId(), root);
        listeners = new SparseArray<>();
    }

    public static BadgeHelper I() {
        if (instance == null) {
            instance = new BadgeHelper();
        }
        return instance;
    }

    public int plus(int id, int num, int mode) {
        BadgeNumberNode node = badgeArray.get(id);
        //如果之前没有这个node，则新增
        if (node == null) {
            insertBadge(id, num, mode);
            return num;
        }

        BadgeNumber number = node.getObj();
        int oldCount = number.getCount();
        int newCount = oldCount + num;

        //计数为0
        if (newCount == 0) {
            delBadge(node);
        } else {
            updateBadge(id, newCount, mode);
        }
        return number.getCount();
    }

    public int plus(int id, int mode) {
        return plus(id, 1, mode);
    }

    public int reduce(int id, int num, int mode) {
        return plus(id, -num, mode);
    }

    public int reduce(int id, int mode) {
        return plus(id, -1, mode);
    }

    public void clear(int id) {
        BadgeNumberNode node = badgeArray.get(id);
        if (node != null)
            delBadge(node);
    }

    private BadgeNumber getBadge(int id) {
        BadgeNumberNode node = badgeArray.get(id);
        if (node != null && node.getObj() != null) {
            return node.getObj();
        } else {
            return null;
        }
    }

    private void insertBadge(int id, int count, int mode) {
        BadgeNumberNode node = badgeArray.get(id);
        if (node != null) {
            updateBadge(id, count, mode);
            throw new RuntimeException("cannot insert already exist node!");
        } else {
            BadgeNumberNode insertNode = new BadgeNumberNode();
            BadgeNumber number = new BadgeNumber(id);
            number.setCount(count);
            number.setDisplayMode(mode);
            insertNode.setObj(number);
            insertNode.setSelfId(id);
            badgeArray.put(id, insertNode);
            notifyChange(number, 0);
            int parentId = getParentId(id);
            insertNode.setParentId(parentId);
            BadgeNumberNode parentNode = badgeArray.get(parentId);
            if (parentNode == null) {
                insertParent(insertNode);
            } else {
                insertNode.setParentNode(parentNode);
                parentNode.addChildNode(insertNode);
                int newCount = calCount(parentNode, parentNode.getObj().getDisplayMode());
                updateBadge(parentId, newCount,mode);
            }
        }
    }

    private void insertParent(BadgeNumberNode childNode) {
        int parentId = getParentId(childNode.getSelfId());
        BadgeNumberNode parentNode = badgeArray.get(parentId);
        if (parentNode != null) {
            childNode.setParentNode(parentNode);
            childNode.setParentId(parentId);
        }
        while (parentNode == null) {
            BadgeNumber childNumber = childNode.getObj();
            BadgeNumber number = new BadgeNumber(parentId);
            number.setDisplayMode(childNumber.getDisplayMode());
            number.setCount(childNumber.getCount());
            List<TreeNode<BadgeNumber>> children = new ArrayList<>();
            children.add(childNode);
            //创建parentNode
            parentNode = new BadgeNumberNode();
            parentNode.setChildList(children);
            parentNode.setSelfId(parentId);
            parentNode.setObj(number);
            //parent 的 parent
            int ppId = getParentId(parentId);
            BadgeNumberNode ppNode = badgeArray.get(ppId);
            parentNode.setParentId(ppId);
            parentNode.setParentNode(ppNode);
            badgeArray.put(parentId, parentNode);

            //设置childNode的parent属性
            childNode.setParentNode(parentNode);
            childNode.setParentId(parentId);

            notifyChange(number, 0);
            childNode = parentNode;
            parentNode = ppNode;
            parentId = ppId;
        }
    }


    private void updateBadge(int id, int newCount, int newMode) {
        BadgeNumberNode node = badgeArray.get(id);
        if (node == null) {
            return;
        }
        if (node.getObj().getCount() == newCount && node.getObj().getDisplayMode() == newMode) {
            return;
        }
        if (newCount <= 0) {
            delBadge(node);
            return;
        }
        TreeNode<BadgeNumber> parentNode = node.getParentNode();
        TreeNode<BadgeNumber> childNode = node;
        BadgeNumber childNum = childNode.getObj();
        int oldChildCount = childNum.getCount();
        int oldMode = childNum.getDisplayMode();
        childNum.setCount(newCount);
        childNum.setDisplayMode(newMode);
        notifyChange(childNum, oldChildCount);
        while (parentNode != null) {
            BadgeNumber parentNum = parentNode.getObj();
            int oldParentCount = parentNum.getCount();
            int newParentCount = calCount(parentNode, parentNum.getDisplayMode());
            parentNum.setCount(newParentCount);
            parentNum.setDisplayMode(calMode(parentNode));
            notifyChange(parentNum, oldParentCount);

            parentNode = parentNode.getParentNode();
        }
    }

    private void delBadge(BadgeNumberNode node) {
        if (node == null) {
            return;
        }
        TreeNode<BadgeNumber> parentNode = node.getParentNode();
        TreeNode<BadgeNumber> childNode = node;
        while (parentNode != null) {
            delChild(childNode);
            badgeArray.remove(childNode.getSelfId());
            notifyDisplay(childNode.getObj(), false);
            parentNode.deleteChildNode(childNode.getSelfId());

            BadgeNumber parentNum = parentNode.getObj();
            BadgeNumber childNum = childNode.getObj();
            int parentMode = parentNum.getDisplayMode();
            int childMode = childNum.getDisplayMode();

            if (parentMode == BadgeMode.NUMBER) {
                int numCount = calCount(parentNode, BadgeMode.NUMBER);
                if (numCount <= 0) {
                    int dotCount = calCount(parentNode, BadgeMode.DOT);
                    if (dotCount <= 0) {
                        childNode = parentNode;
                        parentNode = parentNode.getParentNode();
                        continue;
                    } else {
                        updateBadge(parentNum.getBadgeId(), dotCount, BadgeMode.DOT);
                        break;
                    }
                } else {
                    updateBadge(parentNum.getBadgeId(), numCount,BadgeMode.NUMBER);
                    break;
                }
            } else {
                //父节点是点类型，孩子节点是数字类型，不应该存在这种情况
                if (childMode == BadgeMode.NUMBER) {
                    Log.w("badge", "the mode between child and parent is error?");
                    break;
                } else {
                    int dotCount = calCount(parentNode, BadgeMode.DOT);
                    if (dotCount <= 0) {
                        childNode = parentNode;
                        parentNode = parentNode.getParentNode();
                        continue;
                    } else {
                        updateBadge(parentNum.getBadgeId(), dotCount,BadgeMode.DOT);
                        break;
                    }
                }
            }
        }
    }

    private void delChild(TreeNode<BadgeNumber> node) {
        List<TreeNode<BadgeNumber>> children = node.getChildList();
        if (children == null || children.size() <= 0) {
            node.getParentNode().deleteChildNode(node.getSelfId());
            badgeArray.remove(node.getSelfId());
            notifyDisplay(node.getObj(), false);
            return;
        }
        for (TreeNode<BadgeNumber> ch : children) {
            delChild(ch);
            badgeArray.remove(ch.getSelfId());
            notifyDisplay(ch.getObj(), false);
        }
        node.setChildList(null);
    }

    /**
     * 计算node的count
     */
    private int calCount(TreeNode<BadgeNumber> node, @BadgeMode int mode) {
        List<TreeNode<BadgeNumber>> children = node.getChildList();
        BadgeNumber number = node.getObj();
        int count = 0;
        if (children != null && children.size() > 0) {
            for (TreeNode<BadgeNumber> child : children) {
                if (mode == child.getObj().getDisplayMode()) {
                    count += child.getObj().getCount();
                }
            }
        }
        return count;
    }

    private int calMode(TreeNode<BadgeNumber> node){
        List<TreeNode<BadgeNumber>> children = node.getChildList();
        if (children != null && children.size() > 0) {
            for (TreeNode<BadgeNumber> child : children) {
                if (BadgeMode.NUMBER == child.getObj().getDisplayMode()) {
                    return BadgeMode.NUMBER;
                }
            }
        }
        return BadgeMode.DOT;
    }

    private int getParentId(int id) {
        BadgeGraph.BadgeBridge badge = BadgeGraph.BadgeBridge.get(id);
        return badge.parent;
    }

    private void notifyChange(BadgeNumber badge, int oldCount) {
        OnChangeListener listener = listeners.get(badge.getBadgeId());
        if (listener != null) {
            listener.onChange(badge, oldCount);
        }
    }

    private void notifyDisplay(BadgeNumber badge, boolean show) {
        OnChangeListener listener = listeners.get(badge.getBadgeId());
        if (listener != null) {
            listener.onDisplay(badge, show);
        }
    }

    public void addListener(int id, OnChangeListener listener) {
        listeners.put(id, listener);
    }

    public interface OnChangeListener {
        void onChange(BadgeNumber badge, int oldCount);

        void onDisplay(BadgeNumber badge, boolean show);
    }

}