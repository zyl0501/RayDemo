package com.ray.demo.sample.badge;


import android.support.annotation.NonNull;

/**
 * 红点的结构图
 */
public interface BadgeGraph {
    int root = 0;
    int home = 1;
    int task = 2;
    int message = 3;
    int me = 4;
    /**
     * 服务-待处理tab
     */
    int t_tab_l = 201;
    /**
     * 服务-待接受tab
     */
    int t_tab_r = 202;

    /**
     * 服务-待处理tab-全部
     */
    int t_tl_tab_all = 203;
    /**
     * 服务-待处理tab-抢单
     */
    int t_tl_tab_active = 204;
    /**
     * 服务-待处理tab-点名
     */
    int t_tl_tab_name = 205;
    /**
     * 服务-待处理tab-推送
     */
    int t_tl_tab_push = 206;

    /**
     * 服务-待接受tab-全部
     */
    int t_tr_tab_all = 207;
    /**
     * 服务-待接受tab-抢单
     */
    int t_tr_tab_active = 208;
    /**
     * 服务-待接受tab-点名
     */
    int t_tr_tab_name = 209;
    /**
     * 服务-待接受tab-推送
     */
    int t_tr_tab_push = 210;

    /**
     * 服务-待处理tab-全部-item
     */
    int t_tl_tab_all_item = 211;

    enum BadgeBridge {
        Home(home, root),
        Task(task, root),
        Message(message, root),
        Me(me, root),

        T_Tab_l(t_tab_l, task),
        T_Tab_r(t_tab_r, task),

        T_Tl_tab_all(t_tl_tab_all, t_tab_l),
        T_Tl_tab_active(t_tl_tab_active, t_tab_l),
        T_Tl_tab_name(t_tl_tab_name, t_tab_l),
        T_Tl_tab_push(t_tl_tab_push, t_tab_l),

        T_Tr_tab_all(t_tr_tab_all, t_tab_r),
        T_Tr_tab_active(t_tr_tab_active, t_tab_r),
        T_Tr_tab_name(t_tr_tab_name, t_tab_r),
        T_Tr_tab_push(t_tr_tab_push, t_tab_r),
        T_Tl_tab_all_item(t_tl_tab_all_item, t_tl_tab_all),;

        BadgeBridge(int id, int parent) {
            this.id = id;
            this.parent = parent;
        }

        BadgeBridge(int id, int parent, String desc) {
            this.id = id;
            this.parent = parent;
            this.desc = desc;
        }

        String desc;
        int id;
        int parent;

        static
        @NonNull
        BadgeBridge get(int id) {
            BadgeBridge[] all = values();
            for (BadgeBridge badge : all) {
                if (badge.id == id) {
                    return badge;
                }
            }
            throw new RuntimeException("传入了一个非法id: " + id);
        }

        static
        @NonNull
        BadgeBridge getParent(int id) {
            BadgeBridge[] all = values();
            for (BadgeBridge badge : all) {
                if (badge.id == id) {
                    return badge;
                }
            }
            throw new RuntimeException("传入了一个非法id: " + id);
        }

    }
}
